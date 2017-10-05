package com.example.vaadin1.suppliers.backend;

import com.example.vaadin1.suppliers.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Company, Long> {
}
