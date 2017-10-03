package com.example.vaadin1.grid;

import com.example.vaadin1.grid.grids.*;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Theme("valo")
@SpringUI
public class GridUI extends UI {
    private VerticalLayout root;

//    @Autowired
//    private FrozenCompanies frozenListLayout;
//    @Autowired
//    private VeggiesCompanies veggiesLayout;
//    @Autowired
//    private SeafoodCompanies seafoodLayout;
//    @Autowired
//    private AdminUI adminGrid;
//    private CompanyForm form;

    @Autowired
    private CompaniesRepository repo;

    private List<Company> companyList;

    private Company selectedCompany;
    private TabSheet tabSheet;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addLayout();
        updateList();

//        addTabSheet();
    }

    private enum TYPE {
        FROZEN,
        VEGGIES,
        SEAFOOD
    }

    private CompaniesGrid getCompanies(TYPE type) {
        List<Company> selectedCompanies = new ArrayList<>();
        for(Company c : companyList) {
            if (type == TYPE.FROZEN) {
                if (c.isFrozen())
                    selectedCompanies.add(c);
            } else if (type == TYPE.VEGGIES) {
                if (c.isVeggies())
                    selectedCompanies.add(c);
            } else {
                if (c.isSeafood())
                    selectedCompanies.add(c);
            }
        }
        return new CompaniesGrid(selectedCompanies);

    }

    private void addSeafoodTab() {
        CompaniesGrid grid = getCompanies(TYPE.FROZEN);
        VerticalLayout tab = new VerticalLayout(grid);
        tabSheet.addTab(tab, "Заморозка");
    }

    private void addVeggiesTab() {
        CompaniesGrid grid = getCompanies(TYPE.VEGGIES);
        VerticalLayout tab = new VerticalLayout(grid);
        tabSheet.addTab(tab, "Овощи");
    }

    private void addFrozenTab() {
        Grid<Company> grid = getCompanies(TYPE.SEAFOOD);
        VerticalLayout tab = new VerticalLayout(grid);
        tabSheet.addTab(tab, "Заморозка");
    }

    private void addAdminTab() {
        Grid<Company> grid = new AdminCompaniesGrid(repo.findAll());
        HorizontalLayout adminTab = new HorizontalLayout(grid);
        adminTab.setWidth("100%");
        tabSheet.addTab(adminTab, "Администрирование");
    }

    private void addTabs() {
        tabSheet = new TabSheet();
        tabSheet.setSizeFull();
        root.addComponent(tabSheet);
    }

    private void updateList() {
        companyList = repo.findAll();
        if (tabSheet != null)
            tabSheet.removeAllComponents();
        addTabs();
        addAdminTab();
        addFrozenTab();
        addVeggiesTab();
        addSeafoodTab();
    }




//    private void addTabSheet() {
//        TabSheet tabSheet = new TabSheet();
//        tabSheet.setSizeFull();
//        root.addComponent(tabSheet);
//
//        form = new CompanyForm(this);
//        HorizontalLayout adminTab = new HorizontalLayout(adminGrid, form);
//        adminTab.setSizeFull();
//        adminGrid.setSizeFull();
//        adminTab.setExpandRatio(adminGrid, 0.8f);
//        adminGrid.getTable().asSingleSelect().addValueChangeListener(e -> {
//            if (e.getValue() == null)
//                form.setVisible(false);
//            else {
//                form.setVisible(true);
//                form.setCompany(e.getValue());
//            }
//        });
//        tabSheet.addTab(adminTab, "Администрирование");
//
//        VerticalLayout tab1 = new VerticalLayout();
//        tab1.addComponent(frozenListLayout);
//        tabSheet.addTab(tab1, "Заморозка");
//
//        VerticalLayout tab2 = new VerticalLayout();
//        tab2.addComponent(veggiesLayout);
//        tabSheet.addTab(tab2, "Овощи");
//
//        VerticalLayout tab3 = new VerticalLayout();
//        tab3.addComponent(seafoodLayout);
//        tabSheet.addTab(tab3, "Морепродукты");
//    }



    private void addLayout() {
        root = new VerticalLayout();
        root.setSpacing(true);
        setContent(root);
    }




}
