package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Test;
import app.services.EquipmentService;
import app.services.TesterService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class TestInputFormBuilder extends AbstractEntityInputFormBuilder<Test> {
    public TestInputFormBuilder(RequestExecutor requestExecutor) {
        super(Test::new, ServiceFactory.getTestService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(Test test, FormType formType, boolean isContextWindow, EntityInputFormController<Test> controller) {
        EquipmentService equipmentService = ServiceFactory.getEquipmentService();
        TesterService testerService = ServiceFactory.getTesterService();

        ChoiceItemSupplier<Long> equipmentIdSupplier = makeChoiceItemSupplierFromEntities(
                equipmentService,
                t -> new ChoiceItem<>(t.getId(), t.getSerialNumber()),
                "Не удалось загрузить список оборудования"
        );

        ChoiceItemSupplier<Long> testerIdSupplier = makeChoiceItemSupplierFromEntities(
                testerService,
                t -> new ChoiceItem<>(t.getId(), t.getFirstName() + " " + t.getSecondName()),
                "Не удалось загрузить список тестировщиков"
        );

        controller.addChoiceBox(
                "Оборудование",
                test.getEquipment().getId(),
                value -> test.getEquipment().setId(value),
                equipmentIdSupplier
        );

        controller.addChoiceBox(
                "Изделие",
                test.getTester().getId(),
                value -> test.getTester().setId(value),
                testerIdSupplier
        );

        controller.addTextField(
                "Описание эксперимента",
                test.getDescription(),
                test::setDescription
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового начальника участка";
    }

    @Override
    protected String getEditFormWindowTitle(Test test) {
        return String.format(
                "Тест №%d (%s) - изменить",
                test.getId(),
                test.getDescription()
        );
    }
}
