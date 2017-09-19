package com.example.vaadin1.todo;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringComponent
public class TodoListLayout extends VerticalLayout implements TodoChangeListener {

    @Autowired
    TodoRepository repo;

    @PostConstruct
    void init() {
        update();
    }

    private void setTodos(List<Todo> todos) {
        removeAllComponents();
        todos.forEach(todo -> addComponent(new TodoItemLayout(todo, this)));
    }

    private void update() {
        setTodos(repo.findAll());
    }

    public void add(Todo todo) {
        repo.save(todo);
        update();
    }

    public void deleteCompleted() {
        repo.deleteByDone(true);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        add(todo);
    }
}
