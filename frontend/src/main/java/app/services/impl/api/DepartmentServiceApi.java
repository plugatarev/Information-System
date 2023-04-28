package app.services.impl.api;

import app.model.DepartmentRegion;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;


public interface DepartmentServiceApi extends CrudServiceApi {

    @GET("departments/{id}/departmentRegion")
    Call<Page<DepartmentRegion>> getDepartmentRegions(
            @Path("id") Long departmentId,
            @QueryMap Map<String, Object> pageInfo
    );

}
