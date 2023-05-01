package app.services.impl;

import app.model.Brigade;
import app.services.BrigadeService;
import app.services.ServiceResponse;
import app.services.impl.api.BrigadeServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class BrigadeServiceImpl
        extends AbstractCrudServiceImpl<Brigade>
        implements BrigadeService {

    public BrigadeServiceImpl(String baseUrl) {
        super(BrigadeServiceApi.class, Brigade.class, baseUrl, "brigade");
    }

    @Override
    public ServiceResponse<Page<Brigade>> getBrigadesByDepartmentRegions(Long departmentRegionId, PageInfo pageInfo) {
        var call = getServiceApi().getBrigadesByDepartmentRegion(departmentRegionId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);
    }

    private BrigadeServiceApi getServiceApi() {
        return (BrigadeServiceApi) getCrudServiceApi();
    }
}
