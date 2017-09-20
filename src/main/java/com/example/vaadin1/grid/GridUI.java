package com.example.vaadin1.grid;

import com.example.vaadin1.grid.grids.FrozenCompanies;
import com.example.vaadin1.grid.grids.SeafoodCompanies;
import com.example.vaadin1.grid.grids.VeggiesCompanies;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class GridUI extends UI {
    private VerticalLayout root;

    @Autowired
    private FrozenCompanies frozenListLayout;
    @Autowired
    private VeggiesCompanies veggiesLayout;
    @Autowired
    private SeafoodCompanies seafoodLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addLayout();
        addTabSheet();
    }
    private void addTabSheet() {
        TabSheet tabSheet = new TabSheet();
        root.addComponent(tabSheet);

        VerticalLayout tab1 = new VerticalLayout();
        tab1.addComponent(frozenListLayout);
        tabSheet.addTab(tab1, "Заморозка");

        VerticalLayout tab2 = new VerticalLayout();
        tab2.addComponent(veggiesLayout);
        tabSheet.addTab(tab2, "Овощи");

        VerticalLayout tab3 = new VerticalLayout();
        tab3.addComponent(seafoodLayout);
        tabSheet.addTab(tab3, "Морепродукты");
    }

    private void addLayout() {
        root = new VerticalLayout();
        root.setSpacing(true);
        setContent(root);
    }




}
