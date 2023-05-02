package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Brigade;
import app.model.Product;
import app.model.ProductProcess;
import app.model.ProductStatus;
import app.services.BrigadeService;
import app.services.ProductService;
import app.services.ProductStatusService;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class ProductProcessInputFormBuilder  extends AbstractEntityInputFormBuilder<ProductProcess> {
    public ProductProcessInputFormBuilder(RequestExecutor requestExecutor) {
        super(ProductProcess::new, ServiceFactory.getProductProcessService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(ProductProcess productProcess, FormType formType, boolean isContextWindow, EntityInputFormController<ProductProcess> controller) {
        ProductService productService = ServiceFactory.getProductService();
        BrigadeService brigadeService = ServiceFactory.getBrigadeService();
        ProductStatusService productStatusService = ServiceFactory.getProductStatusService();

        ChoiceItemSupplier<Long> productIdSupplier = makeChoiceItemSupplierFromEntities(
                productService,
                t -> new ChoiceItem<>(t.getId(), t.getId() + " " + t.getCategoryType().getName() + " " + t.getCustomer()),
                "Не удалось загрузить список изделий"
        );

        ChoiceItemSupplier<Long> brigadeIdSupplier = makeChoiceItemSupplierFromEntities(
                brigadeService,
                t -> new ChoiceItem<>(t.getId(), t.getBrigadeName()),
                "Не удалось загрузить список бригад"
        );

        ChoiceItemSupplier<Long> productStatusIdSupplier = makeChoiceItemSupplierFromEntities(
                productStatusService,
                t -> new ChoiceItem<>(t.getId(), t.getName()),
                "Не удалось загрузить список статусов"
        );

        controller.addChoiceBox(
                "Изделие",
                productProcess.getProduct() == null ? null : productProcess.getProduct().getId(),
                value -> {
                    Product product = new Product();
                    product.setId(value);
                    productProcess.setProduct(product);
                },
                productIdSupplier
        );

        controller.addChoiceBox(
                "Бригада",
                productProcess.getCollectingBrigade() == null ? null : productProcess.getCollectingBrigade().getId(),
                value -> {
                    Brigade brigade = new Brigade();
                    brigade.setId(value);
                    productProcess.setCollectingBrigade(brigade);
                },
                brigadeIdSupplier
        );

        controller.addChoiceBox(
                "Статус",
                productProcess.getStatus() == null ? null : productProcess.getStatus().getId(),
                value -> {
                    ProductStatus productStatus = new ProductStatus();
                    productStatus.setId(value);
                    productProcess.setStatus(productStatus);
                },
                productStatusIdSupplier
        );

        controller.addTextField(
                "Описание",
                productProcess.getDescriptionWork(),
                productProcess::setDescriptionWork

        );

        if (formType == FormType.EDIT_FORM) {
            controller.addDateField(
                    "Дата окончания",
                    productProcess.getReleaseDate(),
                    productProcess::setReleaseDate
            );
        }
    }

    @Override
    protected String getCreationFormWindowTitle() {
        return "Добавить процесс";
    }

    @Override
    protected String getEditFormWindowTitle(ProductProcess productProcess) {
        return String.format(
                "Процесс №%d - изменить",
                productProcess.getId()
        );
    }
}
