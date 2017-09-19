package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.CompaniesRepository;
import com.example.vaadin1.grid.grids.CompaniesGrid;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringComponent
public class VeggiesCompanies extends VerticalLayout {
    @Autowired
    private CompaniesRepository repo;

    @PostConstruct
    public void init() {
        CompaniesGrid components = new CompaniesGrid(repo.veggies(true));
        addComponent(components);
    }
}
