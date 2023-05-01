package app.services.impl;

import app.model.Master;
import app.services.MasterService;
import app.services.ServiceResponse;
import app.services.impl.api.MasterServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class MasterServiceImpl
        extends AbstractCrudServiceImpl<Master>
        implements MasterService {

    public MasterServiceImpl(String baseUrl) {
        super(MasterServiceApi.class, Master.class, baseUrl, "master");
    }

    @Override
    public ServiceResponse<Page<Master>> getDepartmentRegionMasters(Long departmentRegionId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentRegionMasters(departmentRegionId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    @Override
    public ServiceResponse<Page<Master>> getDepartmentMasters(Long departmentId, PageInfo pageInfo) {
        var call = getServiceApi().getDepartmentMasters(departmentId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private MasterServiceApi getServiceApi() {
        return (MasterServiceApi) getCrudServiceApi();
    }
}