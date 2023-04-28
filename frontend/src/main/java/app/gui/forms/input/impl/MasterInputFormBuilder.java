package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Master;
import app.services.EmployeeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class MasterInputFormBuilder extends AbstractEntityInputFormBuilder<Master> {
    public MasterInputFormBuilder(RequestExecutor requestExecutor) {
        super(Master::new, ServiceFactory.getMasterService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Master master, FormType formType, boolean isContextWindow, EntityInputFormController<Master> controller) {
        EmployeeService employeeService = ServiceFactory.getEmployeeService();

        ChoiceItemSupplier<Long> engineerIdSupplier = makeChoiceItemSupplierFromEntities(
                employeeService,
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("engineer"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + t.getSecondName()),
                "Не удалось загрузить список инженеров"
        );

        controller.addChoiceBox(
                "Инженер",
                master.getId(),
                master::setId,
                engineerIdSupplier
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
