package app.services.impl;

import app.model.Product;
import app.services.ProductService;
import app.services.ServiceResponse;
import app.services.impl.api.ProductServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class ProductServiceImpl
        extends AbstractCrudServiceImpl<Product>
        implements ProductService {

    public ProductServiceImpl(String baseUrl) {
        super(ProductServiceApi.class, Product.class, baseUrl, "product");
    }

    @Override
    public ServiceResponse<Page<Product>> getDepartmentRegionProduct(Long departmentRegionId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentRegionEmployees(departmentRegionId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    @Override
    public ServiceResponse<Page<Product>> getDepartmentProduct(Long departmentId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentEmployees(departmentId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private ProductServiceApi getServiceApi() {
        return (ProductServiceApi) getCrudServiceApi();
    }
}