package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.WorkerBrigade;
import app.services.BrigadeService;
import app.services.EmployeeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class WorkerBrigadeInputFormBuilder extends AbstractEntityInputFormBuilder<WorkerBrigade> {
    public WorkerBrigadeInputFormBuilder(RequestExecutor requestExecutor) {
        super(WorkerBrigade::new, ServiceFactory.getWorkerBrigadeService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(WorkerBrigade workerBrigade, FormType formType, boolean isContextWindow, EntityInputFormController<WorkerBrigade> controller) {
        EmployeeService employeeService = ServiceFactory.getEmployeeService();
        BrigadeService brigadeService = ServiceFactory.getBrigadeService();

        ChoiceItemSupplier<Long> workerIdSupplier = makeChoiceItemSupplierFromEntities(
                employeeService,
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("worker"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + " " + t.getSecondName()),
                "Не удалось загрузить список работников"
        );

        ChoiceItemSupplier<Long> brigadeIdSupplier = makeChoiceItemSupplierFromEntities(
                brigadeService,
                t -> new ChoiceItem<>(t.getId(), t.getBrigadeName()),
                "Не удалось загрузить список бригад"
        );

        controller.addChoiceBox(
                "Работник",
                workerBrigade.getWorker().getId(),
                value -> workerBrigade.getWorker().setId(value),
                workerIdSupplier
        );

        controller.addChoiceBox(
                "Изделие",
                workerBrigade.getBrigade().getId(),
                value -> workerBrigade.getBrigade().setId(value),
                brigadeIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового начальника участка";
    }

    @Override
    protected String getEditFormWindowTitle(WorkerBrigade workerBrigade) {
        return String.format(
                "Назначение №%d - изменить",
                workerBrigade.getId()
        );
    }
}
