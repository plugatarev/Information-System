package app.services;

import app.model.Department;
import app.model.DepartmentRegion;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface DepartmentService extends Service<Department> {

    ServiceResponse<Page<DepartmentRegion>> getDepartmentRegions(Long departmentId, PageInfo pageInfo);

}
