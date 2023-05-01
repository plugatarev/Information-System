package app.gui.forms.filtering.impl;

import app.gui.controllers.FilterBoxController;
import app.model.Employee;
import app.model.type.EmployeeTypeEnum;
import app.services.filters.EmployeeFilter;
import app.services.filters.Filter;

public class EmployeeFilterBoxBuilder extends AbstractFilterBoxBuilder<Employee> {

    @Override
    protected void fillFilterBox(FilterBoxController<Employee> controller, Filter filter) {
        EmployeeFilter employeeFilter = (EmployeeFilter) filter;
        controller.setNumberOfRows(3);
        controller.setNumberOfCols(10);

        int row = 0;
        controller.addLabel("Тип сотрудника:", 0, row, 2);
        controller.addChoiceBox(employeeFilter::setEmployeeCategory, EmployeeTypeEnum::getChoiceItems, 2, row, 5);
    }
}
