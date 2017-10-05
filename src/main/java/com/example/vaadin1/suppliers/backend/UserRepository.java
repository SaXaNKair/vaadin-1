package com.example.vaadin1.suppliers.backend;

import com.example.vaadin1.suppliers.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 05.10.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
