package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.DepartmentRegionChief;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class DepartmentRegionChiefInputFormBuilder extends AbstractEntityInputFormBuilder<DepartmentRegionChief> {
    public DepartmentRegionChiefInputFormBuilder(RequestExecutor requestExecutor) {
        super(DepartmentRegionChief::new, ServiceFactory.getDepartmentRegionChiefService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(DepartmentRegionChief departmentRegionChief, FormType formType, boolean isContextWindow, EntityInputFormController<DepartmentRegionChief> controller) {

        ChoiceItemSupplier<Long> engineerIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeService(),
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("engineering_staff"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + t.getSecondName()),
                "Не удалось загрузить список инженеров"
        );

        controller.addChoiceBox(
                "Инженер",
                departmentRegionChief.getId(),
                departmentRegionChief::setId,
                engineerIdSupplier
        );
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
