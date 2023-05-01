package app.services.impl;

import app.model.Employee;
import app.services.EmployeeService;
import app.services.ServiceResponse;
import app.services.impl.api.EmployeeServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class EmployeeServiceImpl
        extends AbstractCrudServiceImpl<Employee>
        implements EmployeeService {

    public EmployeeServiceImpl(String baseUrl) {
        super(EmployeeServiceApi.class, Employee.class, baseUrl, "employee");
    }

    @Override
    public ServiceResponse<Page<Employee>> getDepartmentRegionEmployees(Long departmentRegionId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentRegionEmployees(departmentRegionId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    @Override
    public ServiceResponse<Page<Employee>> getDepartmentEmployees(Long departmentId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentEmployees(departmentId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private EmployeeServiceApi getServiceApi() {
        return (EmployeeServiceApi) getCrudServiceApi();
    }
}