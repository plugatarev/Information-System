package app.gui.controllers;

import app.gui.controllers.interfaces.ContextWindowBuilder;
import app.gui.forms.filtering.Filter;
import app.gui.forms.filtering.FilterBoxBuilder;
import app.gui.forms.input.EntityInputFormBuilder;
import app.gui.forms.input.impl.*;
import app.model.*;
import app.services.DepartmentRegionService;
import app.services.DepartmentService;
import app.services.Service;
import app.utils.LocalDateFormatter;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import lombok.SneakyThrows;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainController {

    private RequestExecutor requestExecutor;

    @FXML
    private TabPane contentTabPane;

    @FXML
    private Label statusBarLabel;

    @FXML
    private Tab defaultTab;

    @SneakyThrows
    public void init(RequestExecutor requestExecutor) {
        this.requestExecutor = requestExecutor;
        contentTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
    }

    @FXML
    void openDepartmentRegions() {
        createEntityTable(
                "Участки",
                DepartmentRegion.getPropertyNames(),
                DepartmentRegion.getSortPropertyNames(),
                ServiceFactory.getDepartmentRegionService(),
                new DepartmentRegionInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openBrigades() {
        createEntityTable(
                "Бригады",
                Brigade.getPropertyNames(),
                Brigade.getSortPropertyNames(),
                ServiceFactory.getBrigadeService(),
                new BrigadeInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openDepartmentChiefs() {
        createEntityTable(
                "Начальники цехов",
                DepartmentChief.getPropertyNames(),
                DepartmentChief.getSortPropertyNames(),
                ServiceFactory.getDepartmentChiefService(),
                new DepartmentChiefInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openDepartmentRegionChiefs() {
        createEntityTable(
                "Начальники участков",
                DepartmentRegionChief.getPropertyNames(),
                DepartmentRegionChief.getSortPropertyNames(),
                ServiceFactory.getDepartmentRegionChiefService(),
                new DepartmentRegionChiefInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openMasters() {
        createEntityTable(
                "Мастера",
                Master.getPropertyNames(),
                Master.getSortPropertyNames(),
                ServiceFactory.getMasterService(),
                new MasterInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openTesters() {
        createEntityTable(
                "Тестировщики",
                Tester.getPropertyNames(),
                Tester.getSortPropertyNames(),
                ServiceFactory.getTesterService(),
                new TesterInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openProducts() {
        createEntityTable(
                "Изделия",
                Product.getPropertyNames(),
                Product.getSortPropertyNames(),
                ServiceFactory.getProductService(),
                new ProductInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openLaboratoryOrders() {
        createEntityTable(
                "Заказы тестирования",
                LaboratoryOrder.getPropertyNames(),
                LaboratoryOrder.getSortPropertyNames(),
                ServiceFactory.getLaboratoryOrderService(),
                new LaboratoryOrderInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openLaboratories() {
        createEntityTable(
                "Лаборатории",
                Laboratory.getPropertyNames(),
                Laboratory.getSortPropertyNames(),
                ServiceFactory.getLaboratoryService(),
                new LaboratoryInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openTests() {
        createEntityTable(
                "Тесты",
                Test.getPropertyNames(),
                Test.getSortPropertyNames(),
                ServiceFactory.getTestService(),
                new TestInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    @SneakyThrows
    void openEmployees() {
        createEntityTable(
                "Работники",
                Employee.getPropertyNames(),
                Employee.getSortPropertyNames(),
                ServiceFactory.getEmployeeService(),
                new EmployeeInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    @SneakyThrows
    void openDepartments() {
        DepartmentService departmentService = ServiceFactory.getDepartmentService();
        DepartmentRegionService departmentRegionService = ServiceFactory.getDepartmentRegionService();

        ContextWindowBuilder<Department> infoWindowBuilder = department -> {
            var teamPropertyNames = new LinkedHashMap<>(DepartmentRegion.getPropertyNames());
            teamPropertyNames.remove("departmentNameProperty");
            var teamSortPropertyNames = new LinkedHashMap<>(DepartmentRegion.getSortPropertyNames());
            teamSortPropertyNames.remove("departmentName");

            Node departmentRegionTable = createInfoWindowEntityTable(
                    teamPropertyNames,
                    teamSortPropertyNames,
                    pageInfo -> departmentService.getDepartmentRegions(department.getId(), pageInfo),
                    departmentRegionService::deleteById,
                    new DepartmentRegionInputFormBuilder(requestExecutor),
                    () -> {
                        DepartmentRegion departmentRegion = new DepartmentRegion();
                        departmentRegion.getDepartment().setId(department.getId());
                        return departmentRegion;
                    }
            );

            return EntityInfoWindowBuilder
                    .newInfoWindow(department.getDepartmentName())
                    .addTab(departmentRegionTable, "Участки")
                    .build();
        };

        createEntityTable(
                "Отделы",
                Department.getPropertyNames(),
                Department.getSortPropertyNames(),
                ServiceFactory.getDepartmentService(),
                new DepartmentInputFormBuilder(requestExecutor),
                infoWindowBuilder,
                null,
                null
        );
    }

    private void setStatusBarMessage(String message) {
        Platform.runLater(() -> {
            String messageTime = LocalDateFormatter.getFormattedDateTime(Instant.now().toEpochMilli());
            String messageWithTime = String.format("%s: %s", messageTime, message);
            statusBarLabel.textProperty().setValue(messageWithTime);
        });
    }

    @SneakyThrows
    private <T extends Entity> EntityTableController<T> createEntityTable(
            String tableName,
            Map<String, String> entityPropertyNames,
            Map<String, String> entitySortPropertyNames,
            Service<T> entityService,
            EntityInputFormBuilder<T> inputFormBuilder,
            ContextWindowBuilder<T> infoWindowBuilder,
            FilterBoxBuilder<T> filterBoxBuilder,
            Supplier<Filter<T>> newFilterSupplier
    ) {
        FXMLLoader tableLoader = FxmlLoaderFactory.createEntityTableLoader();
        Node table = tableLoader.load();

        Tab tableTab = new Tab(tableName);
        tableTab.setContent(table);
        tableTab.setOnClosed(event -> {
            if (contentTabPane.getTabs().isEmpty()) {
                contentTabPane.getTabs().add(defaultTab);
            }
        });

        contentTabPane.getTabs().remove(defaultTab);
        contentTabPane.getTabs().add(tableTab);
        contentTabPane.getSelectionModel().select(tableTab);

        EntityTableController<T> controller = tableLoader.getController();
        controller.setInfoWindowBuilder(infoWindowBuilder);

        controller.setEntityRemover(entityService::deleteById);

        Node filterBox = null;
        if (filterBoxBuilder != null && newFilterSupplier != null) {
            Filter<T> filter = newFilterSupplier.get();
            filterBox = filterBoxBuilder.buildFilterBox(filter);
            controller.setEntitySource(pageInfo -> entityService.search(filter, pageInfo));
        } else {
            controller.setEntitySource(entityService::getAll);
        }

        controller.setRequestExecutor(requestExecutor);

        controller.init(
                entityPropertyNames,
                entitySortPropertyNames,
                inputFormBuilder,
                null,
                false,
                this::setStatusBarMessage,
                filterBox
        );

        return controller;
    }

    @SneakyThrows
    private <T extends Entity> Node createInfoWindowEntityTable(
            Map<String, String> entityPropertyNames,
            Map<String, String> entitySortPropertyNames,
            EntityTableController.EntitySource<T> entitySource,
            EntityTableController.EntityRemover<T> entityRemover,
            EntityInputFormBuilder<T> inputFormBuilder,
            Supplier<T> newEntitySupplier
    ) {

        FXMLLoader tableLoader = FxmlLoaderFactory.createEntityTableLoader();
        Node table = tableLoader.load();

        EntityTableController<T> entityTableController = tableLoader.getController();
        entityTableController.setEntitySource(entitySource);
        entityTableController.setEntityRemover(entityRemover);
        entityTableController.setRequestExecutor(requestExecutor);
        entityTableController.init(
                entityPropertyNames,
                entitySortPropertyNames,
                inputFormBuilder,
                newEntitySupplier,
                true,
                this::setStatusBarMessage,
                null
        );

        return table;
    }

}
