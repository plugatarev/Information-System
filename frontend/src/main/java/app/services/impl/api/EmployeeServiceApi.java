package app.services.impl.api;

import app.model.Employee;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface EmployeeServiceApi extends CrudServiceApi {
    @GET("departmentRegion/{id}/employees")
    Call<Page<Employee>> getDepartmentRegionEmployees(
            @Path("id") Long departmentRegion,
            @QueryMap Map<String, Object> pageInfo
    );

    @GET("department/{id}/employees")
    Call<Page<Employee>> getDepartmentEmployees(
            @Path("id") Long departmentRegion,
            @QueryMap Map<String, Object> pageInfo
    );
}
