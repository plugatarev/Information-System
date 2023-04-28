package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.EmployeeCategoryType;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class EmployeeCategoryTypeInputFormBuilder extends AbstractEntityInputFormBuilder<EmployeeCategoryType> {
    public EmployeeCategoryTypeInputFormBuilder(RequestExecutor requestExecutor) {
        super(EmployeeCategoryType::new, ServiceFactory.getEmployeeCategoryTypeService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            EmployeeCategoryType employeeCategoryType,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<EmployeeCategoryType> controller
    ) {

        ChoiceItemSupplier<Long> categoryIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryService(),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Название подтипа",
                employeeCategoryType.getName(),
                employeeCategoryType::setName
        );

        controller.addChoiceBox(
                "Название типа",
                employeeCategoryType.getEmployeeCategory().getId(),
                value -> employeeCategoryType.getEmployeeCategory().setId(value),
                categoryIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новый подтип сотрудника";
    }

    @Override
    protected String getEditFormWindowTitle(EmployeeCategoryType employeeCategoryType) {
        return String.format("Подтип %s - изменить", employeeCategoryType.getName());
    }
}
