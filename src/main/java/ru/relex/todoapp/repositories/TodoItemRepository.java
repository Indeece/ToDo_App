package ru.relex.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.todoapp.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
