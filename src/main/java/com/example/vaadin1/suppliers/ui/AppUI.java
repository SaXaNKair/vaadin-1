package com.example.vaadin1.suppliers.ui;

import com.example.vaadin1.suppliers.app.HasLogger;
import com.example.vaadin1.suppliers.backend.CompaniesRepository;
import com.example.vaadin1.suppliers.backend.entity.Company;
import com.example.vaadin1.suppliers.ui.elements.AdminCompaniesGrid;
import com.example.vaadin1.suppliers.ui.elements.CompaniesGrid;
import com.example.vaadin1.suppliers.ui.elements.CompanyForm;
import com.example.vaadin1.suppliers.ui.navigation.NavigationManager;
import com.vaadin.annotations.Theme;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Theme("apptheme")
@SpringUI
public class AppUI extends UI implements HasLogger {

    private final SpringViewProvider viewProvider;

    private final NavigationManager navigationManager;

    private final MainView mainView;

    @Autowired
    public AppUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
        this.viewProvider = viewProvider;
        this.navigationManager = navigationManager;
        this.mainView = mainView;
    }

    private VerticalLayout root;

    @Autowired
    private CompaniesRepository repo;

    private List<Company> companyList;
    private TabSheet tabSheet;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setErrorHandler(event -> {
            Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
            getLogger().error("Error during request", t);
        });

        addLayout();
        addHeader();
        updateList();
        addFooter();
    }

    private void addFooter() {

    }

    private void addHeader() {
        Label header = new Label("БАЗА ДАННЫХ ПОСТАВЩИКОВ ПРОДУКТОВ ПИТАНИЯ");
        header.addStyleName(ValoTheme.LABEL_H1);
        root.addComponent(header);
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
        CompaniesGrid grid = getCompanies(TYPE.SEAFOOD);
        VerticalLayout tab = new VerticalLayout(grid);
        tabSheet.addTab(tab, "Морепродукты");
    }

    private void addVeggiesTab() {
        CompaniesGrid grid = getCompanies(TYPE.VEGGIES);
        VerticalLayout tab = new VerticalLayout(grid);
        tabSheet.addTab(tab, "Овощи");
    }

    private void addFrozenTab() {
        Grid<Company> grid = getCompanies(TYPE.FROZEN);
        VerticalLayout tab = new VerticalLayout(grid);
        tabSheet.addTab(tab, "Заморозка");
    }

    private void addAdminTab() {

        Grid<Company> grid = new AdminCompaniesGrid(repo.findAll());
        CompanyForm form = new CompanyForm(this, repo);

        HorizontalLayout gridAndForm = new HorizontalLayout(grid, form);
        gridAndForm.setSizeFull();
        gridAndForm.setExpandRatio(grid, 1);
        grid.asSingleSelect().addValueChangeListener(e -> {
           if (e.getValue() == null)
               form.setVisible(false);
           else {
               form.setVisible(true);
               form.setCompany(e.getValue());
           }
        });

        Button addCompanyBtn = new Button("Добавить компанию");
        addCompanyBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCompany(new Company());
        });

        VerticalLayout adminTab = new VerticalLayout(addCompanyBtn, gridAndForm);
        adminTab.setSizeFull();
        adminTab.setSpacing(true);
        tabSheet.addTab(adminTab, "Администрирование");
    }

    private void addTabs() {
        if (tabSheet == null)
            tabSheet = new TabSheet();
        tabSheet.setSizeFull();
        root.addComponent(tabSheet);
    }

    public void updateList() {
        companyList = repo.findAll();
        if (tabSheet != null)
            tabSheet.removeAllComponents();
        addTabs();
        addAdminTab();
        addFrozenTab();
        addVeggiesTab();
        addSeafoodTab();
    }

    private void addLayout() {
        root = new VerticalLayout();
        root.setId("root");
        root.setSpacing(true);
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }

}
