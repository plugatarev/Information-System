package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Master;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class MasterInputFormBuilder extends AbstractEntityInputFormBuilder<Master> {
    public MasterInputFormBuilder(RequestExecutor requestExecutor) {
        super(Master::new, ServiceFactory.getMasterService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Master master, FormType formType, boolean isContextWindow, EntityInputFormController<Master> controller) {
        ChoiceItemSupplier<Long> engineerIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getEmployeeService(),
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("engineering_staff"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + t.getSecondName()),
                "Не удалось загрузить список инженеров"
        );

        ChoiceItemSupplier<Long> chiefIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentRegionChiefService(),
                t -> t.getEmployeeCategoryType().getEmployeeCategory().getName().equals("engineering_staff"),
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + " " + t.getSecondName()),
                "Не удалось загрузить список инженеров"
        );

        controller.addChoiceBox(
                "Мастер",
                master.getId(),
                master::setId,
                engineerIdSupplier
        );

        controller.addChoiceBox(
                "Начальник участка",
                master.getChief().getId(),
                value -> master.getChief().setId(value),
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
