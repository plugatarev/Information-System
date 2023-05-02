package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Laboratory;
import app.model.LaboratoryOrder;
import app.model.Product;
import app.services.LaboratoryService;
import app.services.ProductService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class LaboratoryOrderInputFormBuilder extends AbstractEntityInputFormBuilder<LaboratoryOrder> {
    public LaboratoryOrderInputFormBuilder(RequestExecutor requestExecutor) {
        super(LaboratoryOrder::new, ServiceFactory.getLaboratoryOrderService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(LaboratoryOrder laboratoryOrder, FormType formType, boolean isContextWindow, EntityInputFormController<LaboratoryOrder> controller) {
        LaboratoryService laboratoryService = ServiceFactory.getLaboratoryService();
        ProductService productService = ServiceFactory.getProductService();

        ChoiceItemSupplier<Long> laboratoryIdSupplier = makeChoiceItemSupplierFromEntities(
                laboratoryService,
                t -> new ChoiceItem<>(t.getId(), t.getLaboratoryName()),
                "Не удалось загрузить список лабораторий"
        );

        ChoiceItemSupplier<Long> productIdSupplier = makeChoiceItemSupplierFromEntities(
                productService,
                t -> new ChoiceItem<>(t.getId(), "Номер заказа=" + t.getId() + " " + t.getCustomer()),
                "Не удалось загрузить список изделий"
        );

        controller.addChoiceBox(
                "Лаборатория",
                laboratoryOrder.getLaboratory() == null ? null : laboratoryOrder.getLaboratory().getId(),
                value -> {
                    Laboratory laboratory = new Laboratory();
                    laboratory.setId(value);
                    laboratoryOrder.setLaboratory(laboratory);
                },
                laboratoryIdSupplier
        );

        controller.addChoiceBox(
                "Изделие",
                laboratoryOrder.getProduct() == null ? null : laboratoryOrder.getProduct().getId(),
                value -> {
                    Product product = new Product();
                    product.setId(value);
                    laboratoryOrder.setProduct(product);
                },
                productIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить нового начальника участка";
    }

    @Override
    protected String getEditFormWindowTitle(LaboratoryOrder laboratoryOrder) {
        return String.format(
                "Начальник участка №%d (%s) - изменить",
                laboratoryOrder.getId(),
                laboratoryOrder.getLaboratoryNameProperty()
        );
    }
}
