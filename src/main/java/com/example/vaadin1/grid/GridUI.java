package com.example.vaadin1.grid;

import com.example.vaadin1.grid.grids.FrozenCompanies;
import com.example.vaadin1.grid.grids.SeafoodCompanies;
import com.example.vaadin1.grid.grids.VeggiesCompanies;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
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
        addLogin();
//        aadHeader();
//        addTabSheet();
    }

    private void addLogin() {
        VerticalLayout box = new VerticalLayout();
        box.setStyleName(ValoTheme.LAYOUT_CARD);
        box.setSpacing(true);
        box.setWidth("30%");
        root.addComponent(box);

        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(event -> {
            event.getLoginParameter("username");
        });
        box.addComponent(loginForm);
    }

    private void aadHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setSpacing(true);
        header.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        root.addComponent(header);

        Label label = new Label("База данных поставщиков пищевой продукции");
        label.setStyleName(ValoTheme.LABEL_H1);
        header.addComponent(label);
    }

    private void addTabSheet() {
        HorizontalLayout box = new HorizontalLayout();
        box.setWidth("80%");
        root.addComponent(box);

        TabSheet tabSheet = new TabSheet();
        box.addComponent(tabSheet);

        VerticalLayout tab1 = new VerticalLayout();
        tab1.addComponent(frozenListLayout);
        tab1.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
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
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }




}
