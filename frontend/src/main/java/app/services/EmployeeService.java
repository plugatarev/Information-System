package app.services;

import app.model.Employee;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface EmployeeService extends Service<Employee> {
    ServiceResponse<Page<Employee>> getDepartmentRegionEmployees(Long departmentRegionId, PageInfo pageInfo);
    ServiceResponse<Page<Employee>> getDepartmentEmployees(Long departmentId, PageInfo pageInfo);
}
