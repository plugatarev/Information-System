package app.gui.forms.filtering.impl;

import app.gui.controllers.FilterBoxController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Department;
import app.model.DepartmentRegion;
import app.model.Employee;
import app.model.type.EmployeeTypeEnum;
import app.services.filters.EmployeeFilter;
import app.services.filters.Filter;
import app.utils.ServiceFactory;

public class EmployeeFilterBoxBuilder extends AbstractFilterBoxBuilder<Employee> {

    @Override
    protected void fillFilterBox(FilterBoxController<Employee> controller, Filter filter) {
        ChoiceItemSupplier<Department> departmentIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentService(),
                c -> new ChoiceItem<>(c.clone(),  c.getDepartmentName()),
                "Не удалось загрузить список цехов"
        );

        ChoiceItemSupplier<DepartmentRegion> departmentRegionIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentRegionService(),
                c -> new ChoiceItem<>(c.clone(),  c.getRegionName()),
                "Не удалось загрузить список участков"
        );

        EmployeeFilter employeeFilter = (EmployeeFilter) filter;
        controller.setNumberOfRows(3);
        controller.setNumberOfCols(10);

        int row = 0;
        controller.addLabel("Тип сотрудника:", 0, row, 2);
        controller.addChoiceBox(employeeFilter::setEmployeeCategory, EmployeeTypeEnum::getChoiceItems, 2, row, 5);

        row++;
        controller.addLabel("Цех:", 0, row, 2);
        controller.addChoiceBox(employeeFilter::setDepartment, departmentIdSupplier, 2, row, 5);
        row++;

        controller.addLabel("Участок:", 0, row, 2);
        controller.addChoiceBox(employeeFilter::setDepartmentRegion, departmentRegionIdSupplier, 2, row, 5);
    }
}
