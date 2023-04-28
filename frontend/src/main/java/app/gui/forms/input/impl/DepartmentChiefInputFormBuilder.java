package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.DepartmentChief;
import app.services.EmployeeService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class DepartmentChiefInputFormBuilder extends AbstractEntityInputFormBuilder<DepartmentChief> {
    public DepartmentChiefInputFormBuilder(RequestExecutor requestExecutor) {
        super(DepartmentChief::new, ServiceFactory.getDepartmentChiefService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(DepartmentChief departmentChief, FormType formType, boolean isContextWindow, EntityInputFormController<DepartmentChief> controller) {
        EmployeeService employeeService = ServiceFactory.getEmployeeService();

        ChoiceItemSupplier<Long> engineerIdSupplier = makeChoiceItemSupplierFromEntities(
                employeeService,
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("engineer"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + " " + t.getSecondName()),
                "Не удалось загрузить список инженеров"
        );

        controller.addChoiceBox(
                "Инженер",
                departmentChief.getId(),
                departmentChief::setId,
                engineerIdSupplier
        );
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
