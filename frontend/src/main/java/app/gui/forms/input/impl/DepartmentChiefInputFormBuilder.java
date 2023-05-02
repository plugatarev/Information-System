package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.DepartmentChief;
import app.model.EmployeeCategoryType;
import app.services.EmployeeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class DepartmentChiefInputFormBuilder extends AbstractEntityInputFormBuilder<DepartmentChief> {
    public DepartmentChiefInputFormBuilder(RequestExecutor requestExecutor) {
        super(DepartmentChief::new, ServiceFactory.getDepartmentChiefService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(DepartmentChief departmentChief, FormType formType, boolean isContextWindow, EntityInputFormController<DepartmentChief> controller) {
        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> c.getEmployeeCategory().getName().equals("engineering_staff"),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Имя сотрудника",
                departmentChief.getFirstName(),
                departmentChief::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                departmentChief.getSecondName(),
                departmentChief::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                departmentChief.getPassport(),
                departmentChief::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                departmentChief.getEmployeeCategoryType() == null ? null : departmentChief.getEmployeeCategoryType().getId(),
                value -> {
                    EmployeeCategoryType categoryType = new EmployeeCategoryType();
                    categoryType.setId(value);
                    departmentChief.setEmployeeCategoryType(categoryType);
                },
                categoryEmployeeIdSupplier
        );

        controller.addDateField(
                "Дата трудоустройства",
                departmentChief.getEmploymentDate(),
                departmentChief::setEmploymentDate
        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата увольнения",
                    departmentChief.getDismissalDate(),
                    departmentChief::setDismissalDate
            );
        }
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового начальника цеха";
    }

    @Override
    protected String getEditFormWindowTitle(DepartmentChief departmentChief) {
        return String.format(
                "Начальник цеха №%d (%s) - изменить",
                departmentChief.getId(),
                departmentChief.getFirstName() + departmentChief.getSecondName()
        );
    }
}
