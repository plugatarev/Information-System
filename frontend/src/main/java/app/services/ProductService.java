package app.services;

import app.model.Product;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface ProductService extends Service<Product>{
    ServiceResponse<Page<Product>> getDepartmentRegionProduct(Long departmentId, PageInfo pageInfo);

    ServiceResponse<Page<Product>> getDepartmentProduct(Long departmentRegionId, PageInfo pageInfo);
}
