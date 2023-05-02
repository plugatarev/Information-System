package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Department;
import app.model.Product;
import app.model.ProductCategoryType;
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
        controller.addChoiceBox(
                "Тип изделия",
                product.getCategoryType() == null ? null : product.getCategoryType().getId(),
                value -> {
                    ProductCategoryType productCategoryType = new ProductCategoryType();
                    productCategoryType.setId(value);
                    product.setCategoryType(productCategoryType);
                },
                categoryProductIdSupplier
        );

        controller.addChoiceBox(
                "Цех сборщик",
                product.getManufacturerDepartment() == null ? null : product.getManufacturerDepartment().getId(),
                value -> {
                    Department department = new Department();
                    department.setId(value);
                    product.setManufacturerDepartment(department);
                },
                departmentIdSupplier
        );

        controller.addTextField(
                "Заказчик",
                product.getCustomer(),
                product::setCustomer
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
