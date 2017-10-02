package com.example.vaadin1.grid;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Login extends VerticalLayout {

    private TextField username;
    private TextField password;
    private Button loginButton;

    public Login() {
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        VerticalLayout box = new VerticalLayout();
        this.username = new TextField("username");
        this.password = new TextField("password");
        this.loginButton = new Button("Войти");
        box.addComponents(username, password, loginButton);
        addComponent(box);
    }
}
