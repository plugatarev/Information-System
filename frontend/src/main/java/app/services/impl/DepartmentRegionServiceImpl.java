package app.services.impl;

import app.model.DepartmentRegion;
import app.services.DepartmentRegionService;
import app.services.ServiceResponse;
import app.services.impl.api.DepartmentRegionServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class DepartmentRegionServiceImpl
        extends AbstractCrudServiceImpl<DepartmentRegion>
        implements DepartmentRegionService {

    public DepartmentRegionServiceImpl(String baseUrl) {
        super(DepartmentRegionServiceApi.class, DepartmentRegion.class, baseUrl, "departmentRegion");
    }

    @Override
    public ServiceResponse<Page<DepartmentRegion>> getDepartmentRegionsByDepartment(Long departmentId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentRegionsByDepartment(departmentId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private DepartmentRegionServiceApi getServiceApi() {
        return (DepartmentRegionServiceApi) getCrudServiceApi();
    }

}
