package app.services.impl.api;

import app.model.Brigade;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface BrigadeServiceApi extends CrudServiceApi {

    @GET("brigade/{departmentRegionId}/brigades")
    Call<Page<Brigade>> getBrigadesByDepartmentRegion(
            @Path("departmentRegionId") Long departmentId,
            @QueryMap Map<String, Object> pageInfo
    );
}
