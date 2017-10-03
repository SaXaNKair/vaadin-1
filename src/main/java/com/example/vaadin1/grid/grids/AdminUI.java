package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.CompaniesRepository;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by admin on 03.10.17.
 */
@SpringComponent
public class AdminUI extends VerticalLayout {

    @Autowired
    private CompaniesRepository repo;

    public AdminCompaniesGrid getTable() {
        return table;
    }

    private AdminCompaniesGrid table;

    @PostConstruct
    public void init() {
        table = new AdminCompaniesGrid(repo.findAll());
        addComponent(table);
    }
}
