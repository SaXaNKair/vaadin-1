package com.example.vaadin1.suppliers.backend;

public class Role {
	public static final String GUEST = "гость";
	public static final String ADMIN = "admin";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		return new String[] { GUEST, ADMIN };
	}

}
