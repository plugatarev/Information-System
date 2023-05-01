package app.services.impl.api;

import app.model.Employee;
import app.services.pagination.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface WorkerBrigadeServiceApi extends CrudServiceApi {
    @GET("workerBrigade/{brigadeId}/employees")
    Call<Page<Employee>> getBrigadeWorkers(@Path("brigadeId") Long brigadeId,
                                           @QueryMap Map<String, Object> pageInfo);
}
