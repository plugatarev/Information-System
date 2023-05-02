package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Department;
import app.model.DepartmentChief;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class DepartmentInputFormBuilder extends AbstractEntityInputFormBuilder<Department> {

    public DepartmentInputFormBuilder(RequestExecutor requestExecutor) {
        super(Department::new, ServiceFactory.getDepartmentService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            Department department,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<Department> controller
    ) {

        ChoiceItemSupplier<Long> chiefIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentChiefService(),
                c -> new ChoiceItem<>(c.getId(), c.getFirstName() + " " + c.getSecondName()),
                "Не удалось загрузить список начальников"
        );

        if (formType == FormType.CREATION_FORM) {
            controller.addTextField(
                    "Название",
                    department.getDepartmentName(),
                    department::setDepartmentName
            );
        }

        controller.addChoiceBox(
                "Начальник",
                department.getDepartmentChief() == null ? null : department.getDepartmentChief().getId(),
                value -> {
                    DepartmentChief dc = new DepartmentChief();
                    dc.setId(value);
                    department.setDepartmentChief(dc);
                },
                chiefIdSupplier
        );

    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новый цех";
    }

    @Override
    protected String getEditFormWindowTitle(Department department) {
        return String.format("%s - изменить", department.getDepartmentName());
    }
}
