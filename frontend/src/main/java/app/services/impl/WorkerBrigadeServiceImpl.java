package app.services.impl;

import app.model.Employee;
import app.model.WorkerBrigade;
import app.services.ServiceResponse;
import app.services.WorkerBrigadeService;
import app.services.impl.api.WorkerBrigadeServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class WorkerBrigadeServiceImpl
        extends AbstractCrudServiceImpl<WorkerBrigade>
        implements WorkerBrigadeService {
    public WorkerBrigadeServiceImpl(String baseUrl) {
        super(WorkerBrigadeServiceApi.class, WorkerBrigade.class, baseUrl, "workerBrigade");
    }

    @Override
    public ServiceResponse<Page<Employee>> getWorkersByBrigadeId(Long brigadeId, PageInfo pageInfo) {
        var call = getServiceApi().getBrigadeWorkers(brigadeId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);

    }

    private WorkerBrigadeServiceApi getServiceApi() {
        return (WorkerBrigadeServiceApi) getCrudServiceApi();
    }
}
