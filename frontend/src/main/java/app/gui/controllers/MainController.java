package app.gui.controllers;

import app.gui.controllers.interfaces.ContextWindowBuilder;
import app.gui.forms.filtering.FilterBoxBuilder;
import app.gui.forms.filtering.impl.EmployeeFilterBoxBuilder;
import app.gui.forms.filtering.impl.ProductFilterBoxBuilder;
import app.gui.forms.input.EntityInputFormBuilder;
import app.gui.forms.input.impl.*;
import app.model.*;
import app.services.*;
import app.services.filters.EmployeeFilter;
import app.services.filters.Filter;
import app.services.filters.ProductFilter;
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
        BrigadeService brigadeService = ServiceFactory.getBrigadeService();

        ContextWindowBuilder<DepartmentRegion> infoWindowBuilder = departmentRegion -> {
            var brigadePropertyNames = new LinkedHashMap<>(Brigade.getPropertyNames());
            brigadePropertyNames.remove("brigadeName");
            var brigadeSortPropertyNames = new LinkedHashMap<>(Brigade.getSortPropertyNames());
            brigadeSortPropertyNames.remove("brigadeName");

            Node brigadeTable = createInfoWindowEntityTable(
                    brigadePropertyNames,
                    brigadeSortPropertyNames,
                    pageInfo -> brigadeService.getBrigadesByDepartmentRegions(departmentRegion.getId(), pageInfo),
                    brigadeService::deleteById,
                    new BrigadeInputFormBuilder(requestExecutor),
                    null
            );

            var employeesPropertyNames = new LinkedHashMap<>(Employee.getPropertyNames());
            var employeesSortPropertyNames = new LinkedHashMap<>(Employee.getSortPropertyNames());

            Node employeeTable = createInfoWindowEntityTable(
                    employeesPropertyNames,
                    employeesSortPropertyNames,
                    pageInfo -> ServiceFactory.getEmployeeService().getDepartmentRegionEmployees(departmentRegion.getId(), pageInfo),
                    ServiceFactory.getEmployeeService()::deleteById,
                    new EmployeeInputFormBuilder(requestExecutor),
                    null
            );

            var productsPropertyNames = new LinkedHashMap<>(Product.getPropertyNames());
            var productsSortPropertyNames = new LinkedHashMap<>(Product.getSortPropertyNames());

            Node productTable = createInfoWindowEntityTable(
                    productsPropertyNames,
                    productsSortPropertyNames,
                    pageInfo -> ServiceFactory.getProductService().getDepartmentRegionProduct(departmentRegion.getId(), pageInfo),
                    ServiceFactory.getProductService()::deleteById,
                    new ProductInputFormBuilder(requestExecutor),
                    null
            );

            var mastersPropertyNames = new LinkedHashMap<>(Master.getPropertyNames());
            var mastersSortPropertyNames = new LinkedHashMap<>(Master.getSortPropertyNames());

            Node masterTable = createInfoWindowEntityTable(
                    mastersPropertyNames,
                    mastersSortPropertyNames,
                    pageInfo -> ServiceFactory.getMasterService().getDepartmentRegionMasters(departmentRegion.getId(), pageInfo),
                    ServiceFactory.getMasterService()::deleteById,
                    new MasterInputFormBuilder(requestExecutor),
                    null
            );

            return EntityInfoWindowBuilder
                    .newInfoWindow(departmentRegion.getRegionName())
                    .addTab(brigadeTable, "Бригады")
                    .addTab(employeeTable, "Сотрудники")
                    .addTab(productTable, "Продукты")
                    .addTab(masterTable, "Мастера")
                    .build();
        };
        createEntityTable(
                "Участки",
                DepartmentRegion.getPropertyNames(),
                DepartmentRegion.getSortPropertyNames(),
                ServiceFactory.getDepartmentRegionService(),
                new DepartmentRegionInputFormBuilder(requestExecutor),
                infoWindowBuilder,
                null,
                null
        );
    }

    @FXML
    void openBrigadiers() {
        createEntityTable(
                "Бригадиры",
                Brigadier.getPropertyNames(),
                Brigadier.getSortPropertyNames(),
                ServiceFactory.getBrigadierService(),
                new BrigadierInputFormBuilder(requestExecutor),
                null,
                null,
                null,
                false
        );
    }

    @FXML
    void openWorkerBrigade() {
        createEntityTable(
                "Работники бригад",
                WorkerBrigade.getPropertyNames(),
                WorkerBrigade.getSortPropertyNames(),
                ServiceFactory.getWorkerBrigadeService(),
                new WorkerBrigadeInputFormBuilder(requestExecutor),
                null,
                null,
                null
        );
    }

    @FXML
    void openBrigades() {
        EmployeeService employeeService = ServiceFactory.getEmployeeService();
        WorkerBrigadeService workerBrigadeService = ServiceFactory.getWorkerBrigadeService();
        ContextWindowBuilder<Brigade> infoWindowBuilder = brigade -> {
            var employeesPropertyNames = new LinkedHashMap<>(Employee.getPropertyNames());
            var employeesSortPropertyNames = new LinkedHashMap<>(Employee.getSortPropertyNames());

            Node employeesTable = createInfoWindowEntityTable(
                    employeesPropertyNames,
                    employeesSortPropertyNames,
                    pageInfo -> workerBrigadeService.getWorkersByBrigadeId(brigade.getId(), pageInfo),
                    employeeService::deleteById,
                    new EmployeeInputFormBuilder(requestExecutor),
                    null
            );

            return EntityInfoWindowBuilder
                    .newInfoWindow(String.format("Бригада №%d", brigade.getId()))
                    .addTab(employeesTable, "Сотрудники")
                    .build();
        };
        createEntityTable(
                "Бригады",
                Brigade.getPropertyNames(),
                Brigade.getSortPropertyNames(),
                ServiceFactory.getBrigadeService(),
                new BrigadeInputFormBuilder(requestExecutor),
                infoWindowBuilder,
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
                null,
                false
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
                null,
                false
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
                null,
                false
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
                null,
                false
        );
    }

    @FXML
    void openProducts() {
        EmployeeService employeeService = ServiceFactory.getEmployeeService();
        WorkerBrigadeService workerBrigadeService = ServiceFactory.getWorkerBrigadeService();
        LaboratoryService laboratoryService = ServiceFactory.getLaboratoryService();

        ContextWindowBuilder<Product> infoWindowBuilder = product -> {
            var employeesPropertyNames = new LinkedHashMap<>(Employee.getPropertyNames());
            var employeesSortPropertyNames = new LinkedHashMap<>(Employee.getSortPropertyNames());

            Node employeesTable = createInfoWindowEntityTable(
                    employeesPropertyNames,
                    employeesSortPropertyNames,
                    pageInfo -> workerBrigadeService.getWorkersByProductId(product.getId(), pageInfo),
                    employeeService::deleteById,
                    new EmployeeInputFormBuilder(requestExecutor),
                    null
            );

            var laboratoriesPropertyNames = new LinkedHashMap<>(Laboratory.getPropertyNames());
            var laboratoriesSortPropertyNames = new LinkedHashMap<>(Laboratory.getSortPropertyNames());

            Node laboratoriesTable = createInfoWindowEntityTable(
                    laboratoriesPropertyNames,
                    laboratoriesSortPropertyNames,
                    pageInfo -> laboratoryService.getLaboratoriesByProductId(product.getId(), pageInfo),
                    laboratoryService::deleteById,
                    new LaboratoryInputFormBuilder(requestExecutor),
                    null
            );

            return EntityInfoWindowBuilder
                    .newInfoWindow(String.format("Состав бригад для продукта №%d", product.getId()))
                    .addTab(employeesTable, "Сотрудники")
                    .addTab(laboratoriesTable, "Лаборатории")
                    .build();
        };

        createEntityTable(
                "Изделия",
                Product.getPropertyNames(),
                Product.getSortPropertyNames(),
                ServiceFactory.getProductService(),
                new ProductInputFormBuilder(requestExecutor),
                infoWindowBuilder,
                new ProductFilterBoxBuilder(),
                ProductFilter::new
        );
    }

    @FXML
    void openProductProcess() {
        createEntityTable(
                "Учет изделий",
                ProductProcess.getPropertyNames(),
                Product.getSortPropertyNames(),
                ServiceFactory.getProductProcessService(),
                new ProductProcessInputFormBuilder(requestExecutor),
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
                new EmployeeFilterBoxBuilder(),
                EmployeeFilter::new
        );
    }

    @FXML
    @SneakyThrows
    void openDepartments() {
        DepartmentRegionService departmentRegionService = ServiceFactory.getDepartmentRegionService();

        ContextWindowBuilder<Department> infoWindowBuilder = department -> {
            var drPropertyNames = new LinkedHashMap<>(DepartmentRegion.getPropertyNames());
            drPropertyNames.remove("departmentNameProperty");
            var drSortPropertyNames = new LinkedHashMap<>(DepartmentRegion.getSortPropertyNames());
            drSortPropertyNames.remove("departmentName");

            Node departmentRegionTable = createInfoWindowEntityTable(
                    drPropertyNames,
                    drSortPropertyNames,
                    pageInfo -> departmentRegionService.getDepartmentRegionsByDepartment(department.getId(), pageInfo),
                    departmentRegionService::deleteById,
                    new DepartmentRegionInputFormBuilder(requestExecutor),
                    null
            );

            var employeesPropertyNames = new LinkedHashMap<>(Employee.getPropertyNames());
            var employeesSortPropertyNames = new LinkedHashMap<>(Employee.getSortPropertyNames());

            Node employeeTable = createInfoWindowEntityTable(
                    employeesPropertyNames,
                    employeesSortPropertyNames,
                    pageInfo -> ServiceFactory.getEmployeeService().getDepartmentEmployees(department.getId(), pageInfo),
                    ServiceFactory.getEmployeeService()::deleteById,
                    new EmployeeInputFormBuilder(requestExecutor),
                    null
            );

            var productsPropertyNames = new LinkedHashMap<>(Product.getPropertyNames());
            var productsSortPropertyNames = new LinkedHashMap<>(Product.getSortPropertyNames());

            Node productTable = createInfoWindowEntityTable(
                    productsPropertyNames,
                    productsSortPropertyNames,
                    pageInfo -> ServiceFactory.getProductService().getDepartmentProduct(department.getId(), pageInfo),
                    ServiceFactory.getProductService()::deleteById,
                    new ProductInputFormBuilder(requestExecutor),
                    null
            );

            var mastersPropertyNames = new LinkedHashMap<>(Master.getPropertyNames());
            var mastersSortPropertyNames = new LinkedHashMap<>(Master.getSortPropertyNames());

            Node masterTable = createInfoWindowEntityTable(
                    mastersPropertyNames,
                    mastersSortPropertyNames,
                    pageInfo -> ServiceFactory.getMasterService().getDepartmentMasters(department.getId(), pageInfo),
                    ServiceFactory.getMasterService()::deleteById,
                    new MasterInputFormBuilder(requestExecutor),
                    null
            );

            return EntityInfoWindowBuilder
                    .newInfoWindow(department.getDepartmentName())
                    .addTab(departmentRegionTable, "Участки")
                    .addTab(employeeTable, "Сотрудники")
                    .addTab(productTable, "Продукты")
                    .addTab(masterTable, "Мастера")
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
            Supplier<Filter> newFilterSupplier
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
            Filter filter = newFilterSupplier.get();
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
                filterBox,
                true
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
                null,
                true
        );

        return table;
    }

    @SneakyThrows
    private <T extends Entity> Node createInfoWindowEntityTable(
            Map<String, String> entityPropertyNames,
            Map<String, String> entitySortPropertyNames,
            EntityTableController.EntitySource<T> entitySource,
            EntityTableController.EntityRemover<T> entityRemover,
            EntityInputFormBuilder<T> inputFormBuilder,
            Supplier<T> newEntitySupplier,
            boolean isUpdatable
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
                null,
                isUpdatable
        );

        return table;
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
            Supplier<Filter> newFilterSupplier,
            boolean isUpdatable
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
            Filter filter = newFilterSupplier.get();
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
                filterBox,
                isUpdatable
        );

        return controller;
    }

}
