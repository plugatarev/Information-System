package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.DepartmentRegionChief;
import app.model.EmployeeCategoryType;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class DepartmentRegionChiefInputFormBuilder extends AbstractEntityInputFormBuilder<DepartmentRegionChief> {
    public DepartmentRegionChiefInputFormBuilder(RequestExecutor requestExecutor) {
        super(DepartmentRegionChief::new, ServiceFactory.getDepartmentRegionChiefService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(DepartmentRegionChief departmentRegionChief, FormType formType, boolean isContextWindow, EntityInputFormController<DepartmentRegionChief> controller) {
        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> c.getEmployeeCategory().getName().equals("engineering_staff"),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Имя сотрудника",
                departmentRegionChief.getFirstName(),
                departmentRegionChief::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                departmentRegionChief.getSecondName(),
                departmentRegionChief::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                departmentRegionChief.getPassport(),
                departmentRegionChief::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                departmentRegionChief.getEmployeeCategoryType() == null ? null : departmentRegionChief.getEmployeeCategoryType().getId(),
                value -> {
                    EmployeeCategoryType categoryType = new EmployeeCategoryType();
                    categoryType.setId(value);
                    departmentRegionChief.setEmployeeCategoryType(categoryType);
                },
                categoryEmployeeIdSupplier
        );

        controller.addDateField(
                "Дата трудоустройства",
                departmentRegionChief.getEmploymentDate(),
                departmentRegionChief::setEmploymentDate
        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата увольнения",
                    departmentRegionChief.getDismissalDate(),
                    departmentRegionChief::setDismissalDate
            );
        }
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового начальника участка";
    }

    @Override
    protected String getEditFormWindowTitle(DepartmentRegionChief departmentRegionChief) {
        return String.format(
                "Начальник участка №%d (%s) - изменить",
                departmentRegionChief.getId(),
                departmentRegionChief.getFirstName() + departmentRegionChief.getSecondName()
        );
    }
}
