package com.example.vaadin1.suppliers.backend.entity;

import com.example.vaadin1.suppliers.backend.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User extends AbstractEntity implements UserDetails{

	@NotNull
	@Size(min = 1, max = 255)
	private String username;

	@NotNull
	@Size(min = 4, max = 255)
	private String password;

	@NotNull
	@Size(min = 1, max = 255)
	private Collection<Role> role; // TODO: 09.10.17

	private boolean locked = false;

	public User() {
		// An empty constructor is needed for all beans
	}

	public User(String email, String name, String password, Collection<Role> role) {
        Objects.requireNonNull(name);
		Objects.requireNonNull(password);
		Objects.requireNonNull(role);

		this.username = name;
		this.password = password;
        this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
