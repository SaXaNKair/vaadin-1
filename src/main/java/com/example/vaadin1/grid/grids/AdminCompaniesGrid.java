package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.Company;
import com.vaadin.ui.Grid;
import org.vaadin.gridutil.cell.GridCellFilter;

import java.util.List;

/**
 * Created by admin on 03.10.17.
 * Класс таблицы компаний для администратора с возможностью редактирования
 */
public class AdminCompaniesGrid extends Grid<Company> {

    public AdminCompaniesGrid(List<Company> companies) {
        super(Company.class);
        setItems(companies);
        removeColumn("persisted");
        setColumnOrder("id", "name", "address", "phone", "email");
        setWidth("80%");
        GridCellFilter filter = new GridCellFilter(this, Company.class);
        filter.setTextFilter("name", true, true);
        filter.setTextFilter("address", true, true);
    }

}












