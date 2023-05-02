package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.EmployeeCategoryType;
import app.model.Laboratory;
import app.model.Tester;
import app.services.EmployeeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class TesterInputFormBuilder extends AbstractEntityInputFormBuilder<Tester> {
    public TesterInputFormBuilder(RequestExecutor requestExecutor) {
        super(Tester::new, ServiceFactory.getTesterService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Tester tester, FormType formType, boolean isContextWindow, EntityInputFormController<Tester> controller) {
        ChoiceItemSupplier<Long> laboratoryIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getLaboratoryService(),
                t -> new ChoiceItem<>(t.getId(), t.getLaboratoryName()),
                "Не удалось загрузить список лабораторий"
        );

        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> c.getEmployeeCategory().getName().equals("laboratory_tester"),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Имя сотрудника",
                tester.getFirstName(),
                tester::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                tester.getSecondName(),
                tester::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                tester.getPassport(),
                tester::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                tester.getEmployeeCategoryType() == null ? null : tester.getEmployeeCategoryType().getId(),
                value -> {
                    EmployeeCategoryType categoryType = new EmployeeCategoryType();
                    categoryType.setId(value);
                    tester.setEmployeeCategoryType(categoryType);
                },
                categoryEmployeeIdSupplier
        );

        controller.addDateField(
                "Дата трудоустройства",
                tester.getEmploymentDate(),
                tester::setEmploymentDate
        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата увольнения",
                    tester.getDismissalDate(),
                    tester::setDismissalDate
            );
        }

        controller.addChoiceBox(
                "Лаборатория",
                tester.getLaboratory() == null ? null : tester.getLaboratory().getId(),
                value -> {
                    Laboratory laboratory = new Laboratory();
                    laboratory.setId(value);
                    tester.setLaboratory(laboratory);
                },
                laboratoryIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового тестировщика";
    }

    @Override
    protected String getEditFormWindowTitle(Tester tester) {
        return String.format(
                "Тестировщик №%d (%s) - изменить",
                tester.getId(),
                tester.getFirstName() + " " + tester.getSecondName() + " " + tester.getLaboratoryProperty()
        );
    }
}
