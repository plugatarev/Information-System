package app.services.impl;

import app.model.Product;
import app.services.ProductService;
import app.services.impl.api.ProductServiceApi;

public class ProductServiceImpl
        extends AbstractCrudServiceImpl<Product>
        implements ProductService {

    public ProductServiceImpl(String baseUrl) {
        super(ProductServiceApi.class, Product.class, baseUrl, "product");
    }
}