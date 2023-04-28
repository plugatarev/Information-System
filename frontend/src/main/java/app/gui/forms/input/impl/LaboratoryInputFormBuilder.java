package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.model.Laboratory;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class LaboratoryInputFormBuilder extends AbstractEntityInputFormBuilder<Laboratory> {
    public LaboratoryInputFormBuilder(RequestExecutor requestExecutor) {
        super(Laboratory::new, ServiceFactory.getLaboratoryService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            Laboratory laboratory,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<Laboratory> controller
    ) {
        if (formType == FormType.CREATION_FORM) {
            controller.addTextField(
                    "Название",
                    laboratory.getLaboratoryName(),
                    laboratory::setLaboratoryName
            );
        }
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новую лабораторию";
    }

    @Override
    protected String getEditFormWindowTitle(Laboratory laboratory) {
        return String.format("%s - изменить", laboratory.getLaboratoryName());
    }
}
