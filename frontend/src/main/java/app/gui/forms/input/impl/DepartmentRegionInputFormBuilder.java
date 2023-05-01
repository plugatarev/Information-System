package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.DepartmentRegion;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class DepartmentRegionInputFormBuilder extends AbstractEntityInputFormBuilder<DepartmentRegion> {
    public DepartmentRegionInputFormBuilder(RequestExecutor requestExecutor) {
        super(DepartmentRegion::new, ServiceFactory.getDepartmentRegionService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            DepartmentRegion departmentRegion,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<DepartmentRegion> controller
    ) {

        ChoiceItemSupplier<Long> chiefIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentRegionChiefService(),
                c -> new ChoiceItem<>(c.getId(), c.getFirstName() + " " + c.getSecondName()),
                "Не удалось загрузить список начальников"
        );

        ChoiceItemSupplier<Long> departmentIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentService(),
                c -> new ChoiceItem<>(c.getId(), c.getDepartmentName()),
                "Не удалось загрузить список цехов"
        );

        if (formType == FormType.CREATION_FORM) {
            controller.addTextField(
                    "Название",
                    departmentRegion.getRegionName(),
                    departmentRegion::setRegionName
            );
        }

        controller.addChoiceBox(
                "Начальник",
                departmentRegion.getDepartmentRegionChief().getId(),
                value -> departmentRegion.getDepartmentRegionChief().setId(value),
                chiefIdSupplier
        );

        controller.addChoiceBox(
                "Цех",
                departmentRegion.getDepartment().getId(),
                value -> departmentRegion.getDepartment().setId(value),
                departmentIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новый участок";
    }

    @Override
    protected String getEditFormWindowTitle(DepartmentRegion departmentRegion) {
        return String.format("%s - изменить", departmentRegion.getRegionName());
    }
}
