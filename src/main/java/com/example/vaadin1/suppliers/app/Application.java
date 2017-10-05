package com.example.vaadin1.suppliers.app;

import com.vaadin.annotations.Viewport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
public class Application {

	public static final String APP_URL = "/";
	public static final String LOGIN_URL = "/login.html";
	public static final String LOGOUT_URL = "/login.html?logout";
	public static final String LOGIN_FAILURE_URL = "/login.html?error";
	public static final String LOGIN_PROCESSING_URL = "/login";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
