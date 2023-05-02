package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Equipment;
import app.model.Test;
import app.model.Tester;
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
                test.getEquipment() == null ? null : test.getEquipment().getId(),
                value -> {
                    Equipment equipment = new Equipment();
                    equipment.setId(value);
                    test.setEquipment(equipment);
                },
                equipmentIdSupplier
        );

        controller.addChoiceBox(
                "Тестировщик",
                test.getTester() == null ? null : test.getTester().getId(),
                value -> {
                    Tester tester = new Tester();
                    tester.setId(value);
                    test.setTester(tester);
                },
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
