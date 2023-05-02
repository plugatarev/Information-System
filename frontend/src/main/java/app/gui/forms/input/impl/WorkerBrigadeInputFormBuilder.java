package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Brigade;
import app.model.EmployeeCategoryType;
import app.model.WorkerBrigade;
import app.services.BrigadeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class WorkerBrigadeInputFormBuilder extends AbstractEntityInputFormBuilder<WorkerBrigade> {
    public WorkerBrigadeInputFormBuilder(RequestExecutor requestExecutor) {
        super(WorkerBrigade::new, ServiceFactory.getWorkerBrigadeService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(WorkerBrigade workerBrigade, FormType formType, boolean isContextWindow, EntityInputFormController<WorkerBrigade> controller) {
        BrigadeService brigadeService = ServiceFactory.getBrigadeService();
        ChoiceItemSupplier<Long> brigadeIdSupplier = makeChoiceItemSupplierFromEntities(
                brigadeService,
                t -> new ChoiceItem<>(t.getId(), t.getBrigadeName()),
                "Не удалось загрузить список бригад"
        );

        ChoiceItemSupplier<Long> categoryEmployeeIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeCategoryTypeService(),
                c -> c.getEmployeeCategory().getName().equals("worker"),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для сотрудника"
        );

        controller.addTextField(
                "Имя сотрудника",
                workerBrigade.getWorker().getFirstName(),
                workerBrigade.getWorker()::setFirstName
        );

        controller.addTextField(
                "Фамилия сотрудника",
                workerBrigade.getWorker().getSecondName(),
                workerBrigade.getWorker()::setSecondName
        );

        controller.addTextField(
                "Паспорт сотрудника",
                workerBrigade.getWorker().getPassport(),
                workerBrigade.getWorker()::setPassport
        );

        controller.addChoiceBox(
                "Тип сотрудника",
                workerBrigade.getWorker().getEmployeeCategoryType() == null ? null : workerBrigade.getWorker().getEmployeeCategoryType().getId(),
                value -> {
                    EmployeeCategoryType categoryType = new EmployeeCategoryType();
                    categoryType.setId(value);
                    workerBrigade.getWorker().setEmployeeCategoryType(categoryType);
                },
                categoryEmployeeIdSupplier
        );

        controller.addDateField(
                "Дата трудоустройства",
                workerBrigade.getWorker().getEmploymentDate(),
                workerBrigade.getWorker()::setEmploymentDate
        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата увольнения",
                    workerBrigade.getWorker().getDismissalDate(),
                    workerBrigade.getWorker()::setDismissalDate
            );
        }

        controller.addChoiceBox(
                "Бригада",
                workerBrigade.getBrigade() == null ? null : workerBrigade.getBrigade().getId(),
                value -> {
                    Brigade brigade = new Brigade();
                    brigade.setId(value);
                    workerBrigade.setBrigade(brigade);
                },
                brigadeIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Новое назвачение";
    }

    @Override
    protected String getEditFormWindowTitle(WorkerBrigade workerBrigade) {
        return String.format(
                "Назначение №%d - изменить",
                workerBrigade.getId()
        );
    }
}
