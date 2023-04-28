package app.services.impl;

import app.model.ProductCategoryType;
import app.services.ProductCategoryTypeService;
import app.services.impl.api.ProductCategoryTypeServiceApi;

public class ProductCategoryTypeServiceImpl
        extends AbstractCrudServiceImpl<ProductCategoryType>
        implements ProductCategoryTypeService {

    public ProductCategoryTypeServiceImpl(String baseUrl) {
        super(ProductCategoryTypeServiceApi.class, ProductCategoryType.class, baseUrl, "productCategoryType");
    }
}