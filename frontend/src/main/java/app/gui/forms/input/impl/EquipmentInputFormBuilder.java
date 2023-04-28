package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.model.Equipment;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class EquipmentInputFormBuilder extends AbstractEntityInputFormBuilder<Equipment> {
    public EquipmentInputFormBuilder(RequestExecutor requestExecutor) {
        super(Equipment::new, ServiceFactory.getEquipmentService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Equipment entity, FormType formType, boolean isContextWindow, EntityInputFormController<Equipment> controller) {

    }

    @Override
    protected String getCreationFormWindowTitle() {
        return null;
    }

    @Override
    protected String getEditFormWindowTitle(Equipment entity) {
        return null;
    }
}
