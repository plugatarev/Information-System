package app.services.impl;

import app.model.ProductStatus;
import app.services.ProductStatusService;
import app.services.impl.api.ProductStatusServiceApi;

public class ProductStatusServiceImpl
        extends AbstractCrudServiceImpl<ProductStatus>
        implements ProductStatusService {

    public ProductStatusServiceImpl(String baseUrl) {
        super(ProductStatusServiceApi.class, ProductStatus.class, baseUrl, "productStatus");
    }
}
