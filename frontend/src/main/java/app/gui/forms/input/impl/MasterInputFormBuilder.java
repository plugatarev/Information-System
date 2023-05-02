package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.DepartmentRegionChief;
import app.model.EmployeeCategoryType;
import app.model.Master;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class MasterInputFormBuilder extends AbstractEntityInputFormBuilder<Master> {
    public MasterInputFormBuilder(RequestExecutor requestExecutor) {
        super(Master::new, ServiceFactory.getMasterService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Master master, FormType formType, boolean isContextWindow, EntityInputFormController<Master> controller) {
        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> c.getEmployeeCategory().getName().equals("engineering_staff"),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        ChoiceItemSupplier<Long> chiefIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentRegionChiefService(),
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("engineering_staff"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + " " + t.getSecondName()),
                "Не удалось загрузить список инженеров"
        );

        controller.addTextField(
                "Имя сотрудника",
                master.getFirstName(),
                master::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                master.getSecondName(),
                master::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                master.getPassport(),
                master::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                master.getEmployeeCategoryType() == null ? null : master.getEmployeeCategoryType().getId(),
                value -> {
                    EmployeeCategoryType categoryType = new EmployeeCategoryType();
                    categoryType.setId(value);
                    master.setEmployeeCategoryType(categoryType);
                },
                categoryEmployeeIdSupplier
        );

        controller.addDateField(
                "Дата трудоустройства",
                master.getEmploymentDate(),
                master::setEmploymentDate
        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата увольнения",
                    master.getDismissalDate(),
                    master::setDismissalDate
            );
        }

        controller.addChoiceBox(
                "Начальник участка",
                master.getDepartmentRegionChief() == null ? null : master.getDepartmentRegionChief().getId(),
                value -> {
                    DepartmentRegionChief chief = new DepartmentRegionChief();
                    chief.setId(value);
                    master.setDepartmentRegionChief(chief);
                },
                chiefIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового мастера";
    }

    @Override
    protected String getEditFormWindowTitle(Master master) {
        return String.format(
                "Мастер №%d (%s) - изменить",
                master.getId(),
                master.getFirstName() + " " + master.getSecondName()
        );
    }
}
