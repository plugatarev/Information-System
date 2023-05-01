package app.services.impl.api;

import app.model.Laboratory;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface LaboratoryServiceApi extends CrudServiceApi {
    @GET("laboratory/{productId}/laboratories")
    Call<Page<Laboratory>> getLaboratories(
            @Path("productId") Long productId,
            @QueryMap Map<String, Object> pageInfo
    );
}
