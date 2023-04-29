package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
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
        EmployeeService employeeService = ServiceFactory.getEmployeeService();

        ChoiceItemSupplier<Long> employeeIdSupplier = makeChoiceItemSupplierFromEntities(
                employeeService,
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("laboratory_tester"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + t.getSecondName()),
                "Не удалось загрузить список тестировщиков"
        );

        controller.addChoiceBox(
                "Тестировщик",
                tester.getId(),
                tester::setId,
                employeeIdSupplier
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
                tester.getFirstName() + tester.getSecondName()
        );
    }
}
