package app.services.impl;

import app.model.ProductProcess;
import app.services.ProductProcessService;
import app.services.ServiceResponse;
import app.services.impl.api.ProductProcessServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class ProductProcessServiceImpl
        extends AbstractCrudServiceImpl<ProductProcess>
        implements ProductProcessService {

    public ProductProcessServiceImpl(String baseUrl) {
        super(ProductProcessServiceApi.class, ProductProcess.class, baseUrl, "productProcess");
    }

    @Override
    public ServiceResponse<Page<ProductProcess>> getProductProcessByProduct(Long productId, PageInfo pageInfo) {
        var call = getServiceApi().getProductProcessByProduct(productId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private ProductProcessServiceApi getServiceApi() {
        return (ProductProcessServiceApi) getCrudServiceApi();
    }
}
