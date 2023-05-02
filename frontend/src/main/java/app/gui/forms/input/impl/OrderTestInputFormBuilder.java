package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.*;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class OrderTestInputFormBuilder extends AbstractEntityInputFormBuilder<OrderTest>{
    public OrderTestInputFormBuilder(RequestExecutor requestExecutor) {
        super(OrderTest::new, ServiceFactory.getOrderTestService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(OrderTest orderTest, FormType formType, boolean isContextWindow, EntityInputFormController<OrderTest> controller) {
        ChoiceItemSupplier<LaboratoryOrder> laboratoryOrderIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getLaboratoryOrderService(),
                t -> new ChoiceItem<>(t, t.getLaboratory().getLaboratoryName() + " " + t.getProduct().getCustomer()),
                "Не удалось загрузить список заказов в лабораторию"
        );

        ChoiceItemSupplier<Test> testIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getTestService(),
                t -> new ChoiceItem<>(t, t.getEquipment().getSerialNumber() + " " + t.getTester().getFirstName() + " " + t.getTester().getSecondName()),
                "Не удалось загрузить список тестов"
        );

        controller.addChoiceBox(
                "Заказ в лабораторию",
                orderTest.getLaboratoryOrder() == null ? null : orderTest.getLaboratoryOrder(),
                orderTest::setLaboratoryOrder,
                laboratoryOrderIdSupplier
        );

        controller.addChoiceBox(
                "Тест",
                orderTest.getTest() == null ? null : orderTest.getTest(),
                orderTest::setTest,
                testIdSupplier
        );

        controller.addDateField(
                "Дата тестирования",
                orderTest.getTestingDate(),
                orderTest::setTestingDate
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новый тест в лаборатории";
    }

    @Override
    protected String getEditFormWindowTitle(OrderTest orderTest) {
        return String.format(
                "Тест в лаборатории №%d - изменить",
                orderTest.getId()
        );
    }
}
