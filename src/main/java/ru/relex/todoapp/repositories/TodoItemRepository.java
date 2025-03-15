package ru.relex.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.todoapp.model.TodoItem;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // Метод для сортировки по цвету
    List<TodoItem> findAllByOrderByColorAsc();

    // Метод для сортировки по статусу
    List<TodoItem> findAllByOrderByStatusAsc();
}
