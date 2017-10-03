package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.Company;
import com.example.vaadin1.grid.GridUI;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

/**
 * Created by admin on 03.10.17.
 */
public class CompanyForm extends FormLayout {

    private final TextField name = new TextField("Name");
    private final TextField address = new TextField("Address");
    private final TextField phone = new TextField("Phone");
    private final TextField email = new TextField("Email");
    private final CheckBox frozen = new CheckBox("Frozen");
    private final CheckBox veggies = new CheckBox("Veggies");
    private final CheckBox seafood = new CheckBox("Seafood");
    private final Button save = new Button("Сохранить");
    private final Button delete = new Button("Удалить");

    private GridUI ui;
    private Company company;
    private final Binder<Company> binder = new Binder<>(Company.class);


    public void setCompany(Company company) {
        this.company = company;
        binder.setBean(company);
        setVisible(true);

        delete.setVisible(company.isPersisted());
    }

    public CompanyForm(GridUI ui) {
        this.ui = ui;

        binder.bindInstanceFields(this);
        setVisible(false);
        setWidth("20%");
        addComponents(name, address, phone, email, frozen, veggies, seafood, save, delete);
    }
}
