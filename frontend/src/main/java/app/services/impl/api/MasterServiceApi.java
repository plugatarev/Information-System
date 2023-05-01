package app.services.impl.api;

import app.model.Master;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface MasterServiceApi extends CrudServiceApi {
    @GET("master/departmentRegion/{departmentRegionId}/masters")
    Call<Page<Master>> getDepartmentRegionMasters(
            @Path("departmentRegionId") Long departmentRegionId,
            @QueryMap Map<String, Object> pageInfo
    );

    @GET("master/department/{departmentId}/masters")
    Call<Page<Master>> getDepartmentMasters(
            @Path("departmentId") Long departmentId,
            @QueryMap Map<String, Object> pageInfo
    );
}
