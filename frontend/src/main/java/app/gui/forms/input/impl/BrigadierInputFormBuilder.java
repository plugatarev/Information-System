package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Brigadier;
import app.services.EmployeeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class BrigadierInputFormBuilder extends AbstractEntityInputFormBuilder<Brigadier> {
    public BrigadierInputFormBuilder(RequestExecutor requestExecutor) {
        super(Brigadier::new, ServiceFactory.getBrigadierService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Brigadier brigadier, FormType formType, boolean isContextWindow, EntityInputFormController<Brigadier> controller) {
        EmployeeService employeeService = ServiceFactory.getEmployeeService();

        ChoiceItemSupplier<Long> brigadierIdSupplier = makeChoiceItemSupplierFromEntities(
                employeeService,
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("worker"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + t.getSecondName()),
                "Не удалось загрузить список работников"
        );

        controller.addChoiceBox(
                "Работник",
                brigadier.getId(),
                brigadier::setId,
                brigadierIdSupplier
        );
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
