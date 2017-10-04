package com.example.vaadin1.suppliers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompaniesRepository extends JpaRepository<Company, Long> {
    @Transactional
    List<Company> frozen(boolean frozen);

    @Transactional
    List<Company> veggies(boolean frozen);

    @Transactional
    List<Company> seafood(boolean frozen);

}
