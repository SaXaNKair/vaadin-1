package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.Company;
import com.vaadin.ui.Grid;

import java.util.List;

public class CompaniesGrid extends Grid<Company> {

    public CompaniesGrid(List<Company> companies) {
        super(Company.class);
        setItems(companies);
        removeColumn("id");
        removeColumn("frozen");
        removeColumn("veggies");
        removeColumn("seafood");
        setColumnOrder("name", "address");
        setWidth("80%");
    }
}
