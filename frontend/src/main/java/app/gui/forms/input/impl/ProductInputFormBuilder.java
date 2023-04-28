package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Product;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class ProductInputFormBuilder extends AbstractEntityInputFormBuilder<Product> {
    public ProductInputFormBuilder(RequestExecutor requestExecutor) {
        super(Product::new, ServiceFactory.getProductService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(
            Product product,
            FormType formType,
            boolean isContextWindow,
            EntityInputFormController<Product> controller
    ) {

        ChoiceItemSupplier<Long> categoryProductIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getProductCategoryTypeService(),
                c -> new ChoiceItem<>(c.getId(), c.getName()),
                "Не удалось загрузить список типов для изделия"
        );

        ChoiceItemSupplier<Long> departmentIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentService(),
                c -> new ChoiceItem<>(c.getId(), c.getDepartmentName()),
                "Не удалось загрузить список цехов для сборки изделия"
        );

        controller.addTextField(
                "Заказчик",
                product.getCustomer(),
                product::setCustomer
        );

        controller.addChoiceBox(
                "Тип изделия",
                product.getCategoryType().getId(),
                value -> product.getCategoryType().setId(value),
                categoryProductIdSupplier
        );

        controller.addChoiceBox(
                "Цех сборщик",
                product.getManufacturerDepartment().getId(),
                value -> product.getManufacturerDepartment().setId(value),
                departmentIdSupplier
        );
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить новое изделие";
    }

    @Override
    protected String getEditFormWindowTitle(Product product) {
        return String.format("Изделие %s - изменить", product.getCategoryTypeProperty() + " " + product.getCustomer());
    }
}
