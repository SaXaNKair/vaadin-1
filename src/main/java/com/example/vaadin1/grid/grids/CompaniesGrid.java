package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.Company;
import com.vaadin.ui.Grid;
import org.vaadin.gridutil.cell.GridCellFilter;

import java.util.List;

public class CompaniesGrid extends Grid<Company> {

    public CompaniesGrid(List<Company> companies) {
        super(Company.class);
        setItems(companies);
        removeColumn("id");
        removeColumn("frozen");
        removeColumn("veggies");
        removeColumn("seafood");
        setColumnOrder("name", "address", "phone", "email");
        setWidth("80%");
        GridCellFilter filter = new GridCellFilter(this, Company.class);
        filter.setTextFilter("name", true, true);
        filter.setTextFilter("address", true, true);
    }
}
