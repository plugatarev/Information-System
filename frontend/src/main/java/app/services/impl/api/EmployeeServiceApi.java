package app.services.impl.api;

import app.model.Employee;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface EmployeeServiceApi extends CrudServiceApi {
    @GET("employee/departmentRegion/{departmentRegionId}/employees")
    Call<Page<Employee>> getDepartmentRegionEmployees(
            @Path("departmentRegionId") Long departmentRegionId,
            @QueryMap Map<String, Object> pageInfo
    );

    @GET("employee/department/{departmentId}/employees")
    Call<Page<Employee>> getDepartmentEmployees(
            @Path("departmentId") Long departmentId,
            @QueryMap Map<String, Object> pageInfo
    );
}
