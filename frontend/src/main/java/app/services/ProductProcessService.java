package app.services;

import app.model.ProductProcess;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface ProductProcessService extends Service<ProductProcess> {
    ServiceResponse<Page<ProductProcess>> getProductProcessByProduct(Long productId, PageInfo pageInfo);
}
