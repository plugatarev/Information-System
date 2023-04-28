package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.model.EmployeeCategory;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class EmployeeCategoryInputFormBuilder extends AbstractEntityInputFormBuilder<EmployeeCategory> {

    public EmployeeCategoryInputFormBuilder(RequestExecutor requestExecutor) {
        super(EmployeeCategory::new, ServiceFactory.getEmployeeCategoryService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            EmployeeCategory employeeCategory,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<EmployeeCategory> controller
    ) {

        controller.addTextField(
                "Название",
                employeeCategory.getName(),
                employeeCategory::setName
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новый тип сотрудника";
    }

    @Override
    protected String getEditFormWindowTitle(EmployeeCategory employeeCategory) {
        return String.format("Тип %s - изменить", employeeCategory.getName());
    }
}
