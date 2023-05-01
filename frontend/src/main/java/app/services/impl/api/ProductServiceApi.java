package app.services.impl.api;

import app.model.Product;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ProductServiceApi extends CrudServiceApi {
    @GET("product/department/{departmentId}/products")
    Call<Page<Product>> getDepartmentEmployees(
            @Path("departmentId") Long departmentId,
            @QueryMap Map<String, Object> pageInfo
    );

    @GET("product/departmentRegion/{departmentRegionId}/products")
    Call<Page<Product>> getDepartmentRegionEmployees(
            @Path("departmentRegionId") Long departmentRegionId,
            @QueryMap Map<String, Object> pageInfo
    );
}
