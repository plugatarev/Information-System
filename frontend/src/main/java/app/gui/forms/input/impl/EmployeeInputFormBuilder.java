package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Employee;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class EmployeeInputFormBuilder extends AbstractEntityInputFormBuilder<Employee> {

    public EmployeeInputFormBuilder(RequestExecutor requestExecutor) {
        super(Employee::new, ServiceFactory.getEmployeeService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            Employee employee,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<Employee> controller
    ) {

        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Имя сотрудника",
                employee.getFirstName(),
                employee::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                employee.getSecondName(),
                employee::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                employee.getPassport(),
                employee::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                employee.getEmployeeCategoryType().getId(),
                value -> employee.getEmployeeCategoryType().setId(value),
                categoryEmployeeIdSupplier

        );

        controller.addDateField(
                "Дата трудоустройства",
                employee.getEmploymentDate(),
                employee::setEmploymentDate
        );

        controller.addDateField(
                "Дата увольнения",
                employee.getDismissalDate(),
                employee::setDismissalDate
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового сотрудника";
    }

    @Override
    protected String getEditFormWindowTitle(Employee employee) {
        return String.format("Сотрудник %s - изменить", employee.getFirstName() + employee.getSecondName());
    }
}
