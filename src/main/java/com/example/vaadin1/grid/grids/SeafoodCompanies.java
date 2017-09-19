package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.CompaniesRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent
public class SeafoodCompanies extends VerticalLayout {
    @Autowired
    private CompaniesRepository repo;

    @PostConstruct
    public void init() {
        CompaniesGrid components = new CompaniesGrid(repo.seafood(true));
        addComponent(components);
    }
}
