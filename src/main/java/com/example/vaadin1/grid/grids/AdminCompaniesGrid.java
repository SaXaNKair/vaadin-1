package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.Company;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.ComponentRenderer;
import org.vaadin.gridutil.cell.GridCellFilter;
import org.vaadin.gridutil.renderer.BooleanRenderer;

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
        setSizeFull();

        removeColumn("frozen");
        addColumn(company -> {
            CheckBox checkBox = new CheckBox();
            checkBox.setValue(company.isFrozen());
            return checkBox;
        }, new ComponentRenderer()).setCaption("Заморозка").setWidth(100);

        removeColumn("veggies");
        addColumn(company -> {
            CheckBox checkBox = new CheckBox();
            checkBox.setValue(company.isVeggies());
            return checkBox;
        }, new ComponentRenderer()).setCaption("Овощи").setWidth(100);

        removeColumn("seafood");
        addColumn(company -> {
            CheckBox checkBox = new CheckBox();
            checkBox.setValue(company.isSeafood());
            return checkBox;
        }, new ComponentRenderer()).setCaption("Морепродукты").setWidth(100);

        GridCellFilter filter = new GridCellFilter(this, Company.class);
        filter.setTextFilter("name", true, true);
        filter.setTextFilter("address", true, true);
    }

}












