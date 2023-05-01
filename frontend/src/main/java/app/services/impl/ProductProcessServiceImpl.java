package app.services.impl;

import app.model.ProductProcess;
import app.services.ProductProcessService;
import app.services.impl.api.ProductProcessServiceApi;

public class ProductProcessServiceImpl
        extends AbstractCrudServiceImpl<ProductProcess>
        implements ProductProcessService {

    public ProductProcessServiceImpl(String baseUrl) {
        super(ProductProcessServiceApi.class, ProductProcess.class, baseUrl, "productProcess");
    }
}
