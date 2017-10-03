package com.example.vaadin1.grid.grids;

import com.example.vaadin1.grid.CompaniesRepository;
import com.example.vaadin1.grid.Company;
import com.example.vaadin1.grid.GridUI;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 03.10.17.
 */
public class CompanyForm extends FormLayout {

    private final TextField name = new TextField("Наименование");
    private final TextField address = new TextField("Адрес");
    private final TextField phone = new TextField("Телефон");
    private final TextField email = new TextField("Email");
    private final CheckBox frozen = new CheckBox("Заморозка");
    private final CheckBox veggies = new CheckBox("Овощи");
    private final CheckBox seafood = new CheckBox("Морепродукты");
    private final Button save = new Button("Сохранить");
    private final Button delete = new Button("Удалить");

    private CompaniesRepository repo;
    private GridUI ui;
    private Company company;
    private final Binder<Company> binder = new Binder<>(Company.class);


    public void setCompany(Company company) {
        this.company = company;
        binder.setBean(company);
        setVisible(true);

        delete.setVisible(company.isPersisted());
    }

    public CompanyForm(GridUI ui, CompaniesRepository repo) {
        this.ui = ui;
        this.repo = repo;

        binder.bindInstanceFields(this);
        setVisible(false);
        setWidth("20%");
        addComponents(name, address, phone, email, frozen, veggies, seafood, save, delete);
        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
    }

    private void delete() {
        repo.delete(company);
        ui.updateList();
    }

    private void save() {
        repo.save(company);
        ui.updateList();
    }




}
