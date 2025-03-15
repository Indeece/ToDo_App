package ru.relex.todoapp.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.relex.todoapp.enums.Status;
import ru.relex.todoapp.model.TodoItem;
import ru.relex.todoapp.repositories.TodoItemRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public TodoController(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public String index(Model model) {

        List<TodoItem> allTodos = todoItemRepository.findAll();
        model.addAttribute("allTodos", allTodos);
        model.addAttribute("newTodo", new TodoItem());

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem) {
        if (!todoItem.getTitle().trim().equals(""))
            todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/removeAll")
    public String deleteAll() {
        todoItemRepository.deleteAll();
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<TodoItem> allItems = todoItemRepository.findAll();
        List<TodoItem> searchResults = new ArrayList<>();

        for (TodoItem item : allItems) {
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(item);
            }
        }

        model.addAttribute("allTodos", searchResults);
        model.addAttribute("newTodo", new TodoItem());

        return "index";
    }

    @PostMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam("status") Status status) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow();
        todoItem.setStatus(status);
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/updateColor/{id}")
    public String updateColor(@PathVariable Long id, @RequestParam("color") String color) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow();
        todoItem.setColor(color);
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
