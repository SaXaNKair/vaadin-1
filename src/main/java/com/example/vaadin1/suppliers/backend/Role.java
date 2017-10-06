package com.example.vaadin1.suppliers.backend;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	public static final String USER = "guest";
	public static final String ADMIN = "admin";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		return new String[] {USER, ADMIN };
	}

	@Override
	public String getAuthority() {
		return null;
	}
}
