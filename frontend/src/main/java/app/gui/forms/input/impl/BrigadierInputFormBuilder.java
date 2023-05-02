package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Brigadier;
import app.model.EmployeeCategoryType;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class BrigadierInputFormBuilder extends AbstractEntityInputFormBuilder<Brigadier> {
    public BrigadierInputFormBuilder(RequestExecutor requestExecutor) {
        super(Brigadier::new, ServiceFactory.getBrigadierService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Brigadier brigadier, FormType formType, boolean isContextWindow, EntityInputFormController<Brigadier> controller) {
        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> c.getEmployeeCategory().getName().equals("worker"),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Имя сотрудника",
                brigadier.getFirstName(),
                brigadier::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                brigadier.getSecondName(),
                brigadier::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                brigadier.getPassport(),
                brigadier::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                brigadier.getEmployeeCategoryType() == null ? null : brigadier.getEmployeeCategoryType().getId(),
                value -> {
                    EmployeeCategoryType categoryType = new EmployeeCategoryType();
                    categoryType.setId(value);
                    brigadier.setEmployeeCategoryType(categoryType);
                },
                categoryEmployeeIdSupplier
        );

        controller.addDateField(
                "Дата трудоустройства",
                brigadier.getEmploymentDate(),
                brigadier::setEmploymentDate
        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата увольнения",
                    brigadier.getDismissalDate(),
                    brigadier::setDismissalDate
            );
        }
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового бригадира";
    }

    @Override
    protected String getEditFormWindowTitle(Brigadier brigadier) {
        return String.format(
                "Бригадик №%d (%s) - изменить",
                brigadier.getId(),
                brigadier.getFirstName() + brigadier.getSecondName()
        );
    }
}
