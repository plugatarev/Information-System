package app.services.impl;

import app.model.Department;
import app.model.DepartmentRegion;
import app.services.DepartmentService;
import app.services.ServiceResponse;
import app.services.impl.api.DepartmentServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class DepartmentServiceImpl
        extends AbstractCrudServiceImpl<Department>
        implements DepartmentService {

    public DepartmentServiceImpl(String baseUrl) {
        super(DepartmentServiceApi.class, Department.class, baseUrl, "department");
    }

    @Override
    public ServiceResponse<Page<DepartmentRegion>> getDepartmentRegions(Long departmentId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentRegions(departmentId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private DepartmentServiceApi getServiceApi() {
        return (DepartmentServiceApi) getCrudServiceApi();
    }

}
