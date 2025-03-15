package ru.relex.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import ru.relex.todoapp.enums.Status;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    Long id;
    String title;
    Status status = Status.NOT_STARTED;
    String color = "#808080"; // Серый цвет по умолчанию

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TodoItem() {
    }

    public TodoItem(String title, String color) {
        this.title = title;
        this.color = color;
    }
}
