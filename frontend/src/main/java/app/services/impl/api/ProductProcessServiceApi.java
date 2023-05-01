package app.services.impl.api;

import app.model.ProductProcess;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ProductProcessServiceApi extends CrudServiceApi {
    @GET("productProcess/products/{productId}")
    Call<Page<ProductProcess>> getProductProcessByProduct(
            @Path("productId") Long productId,
            @QueryMap Map<String, Object> pageInfo
    );
}
