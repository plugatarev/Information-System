package app.services;

import app.model.DepartmentRegion;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface DepartmentRegionService extends Service<DepartmentRegion> {
    ServiceResponse<Page<DepartmentRegion>> getDepartmentRegionsByDepartment(Long departmentId, PageInfo pageInfo);
}
