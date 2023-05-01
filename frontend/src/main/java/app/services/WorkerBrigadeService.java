package app.services;

import app.model.Employee;
import app.model.WorkerBrigade;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface WorkerBrigadeService extends Service<WorkerBrigade> {
    ServiceResponse<Page<Employee>> getWorkersByBrigadeId(Long brigadeId, PageInfo pageInfo);
}
