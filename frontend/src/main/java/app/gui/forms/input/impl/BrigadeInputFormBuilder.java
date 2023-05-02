package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Brigade;
import app.model.Brigadier;
import app.model.DepartmentRegion;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class BrigadeInputFormBuilder extends AbstractEntityInputFormBuilder<Brigade> {

    public BrigadeInputFormBuilder(RequestExecutor requestExecutor) {
        super(Brigade::new, ServiceFactory.getBrigadeService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            Brigade brigade,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<Brigade> controller
    ) {

        ChoiceItemSupplier<Long> brigadierIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getBrigadierService(),
                c -> new ChoiceItem<>(c.getId(), c.getFirstName() + " " + c.getSecondName()),
                "Не удалось загрузить список бригадиров"
        );

        ChoiceItemSupplier<Long> departmentRegionIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentRegionService(),
                c -> new ChoiceItem<>(c.getId(),  c.getRegionName()),
                "Не удалось загрузить список участков"
        );

        if (formType == FormType.CREATION_FORM) {
            controller.addTextField(
                    "Название",
                    brigade.getBrigadeName(),
                    brigade::setBrigadeName
            );
        }

        controller.addChoiceBox(
                "Бригадир",
                brigade.getBrigadier() == null ? null : brigade.getBrigadier().getId(),
                value -> {
                    Brigadier brigadier = new Brigadier();
                    brigadier.setId(value);
                    brigade.setBrigadier(brigadier);
                },
                brigadierIdSupplier
        );

        controller.addChoiceBox(
                "Участок",
                brigade.getDepartmentRegion() == null ? null : brigade.getDepartmentRegion().getId(),
                value -> {
                    DepartmentRegion dr = new DepartmentRegion();
                    dr.setId(value);
                    brigade.setDepartmentRegion(dr);
                },
                departmentRegionIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новую бригаду";
    }

    @Override
    protected String getEditFormWindowTitle(Brigade brigade) {
        return String.format("%s - изменить", brigade.getBrigadeName());
    }
}
