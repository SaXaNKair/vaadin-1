package com.example.vaadin1.todo;

import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringUI
public class TodoUI extends UI {

    private VerticalLayout root;
    @Autowired
    TodoListLayout todoListLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addLayout();
        addHeader();
        addNewTodo();
        addTodoList();
        addDeleteButton();
    }

    private void addLayout() {
        root = new VerticalLayout();
        root.setSpacing(true);
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }

    private void addHeader() {
        Label header = new Label("TODOs");
        header.addStyleName(ValoTheme.LABEL_H1);
        root.addComponent(header);
    }

    private void addNewTodo() {
        HorizontalLayout newTodoDiv = new HorizontalLayout();
        newTodoDiv.setSpacing(true);
        newTodoDiv.setWidth("80%");

        TextField text = new TextField();
        text.setWidth("100%");
        text.focus();

        Button addButton = new Button();
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        addButton.setIcon(VaadinIcons.PLUS_CIRCLE);
        addButton.addClickListener(clickEvent -> {
            todoListLayout.add(new Todo(text.getValue()));
            text.clear();
            text.focus();
        });
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        newTodoDiv.addComponentsAndExpand(text);
        newTodoDiv.addComponent(addButton);
        root.addComponent(newTodoDiv);
    }

    private void addTodoList() {
        todoListLayout.setWidth("80%");
        root.addComponent(todoListLayout);
    }

    private void addDeleteButton() {
        Button deleteButton = new Button("Delete completed", clickEvent -> {
            todoListLayout.deleteCompleted();
        });
        root.addComponent(deleteButton);
    }
}
