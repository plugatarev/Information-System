package app.gui.forms.input.impl;

import app.gui.controllers.EntityInputFormController;
import app.model.ProductCategoryType;
import app.utils.RequestExecutor;
import app.utils.ServiceFactory;

public class ProductCategoryTypeInputFormBuilder extends AbstractEntityInputFormBuilder<ProductCategoryType> {
    public ProductCategoryTypeInputFormBuilder(RequestExecutor requestExecutor) {
        super(ProductCategoryType::new, ServiceFactory.getProductCategoryTypeService(), requestExecutor);
    }

    @Override
    protected void fillInputForm(ProductCategoryType entity, FormType formType, boolean isContextWindow, EntityInputFormController<ProductCategoryType> controller) {

    }

    @Override
    protected String getCreationFormWindowTitle() {
        return null;
    }

    @Override
    protected String getEditFormWindowTitle(ProductCategoryType entity) {
        return null;
    }
}
