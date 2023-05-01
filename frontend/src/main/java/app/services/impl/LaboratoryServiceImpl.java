package app.services.impl;

import app.model.Employee;
import app.model.Laboratory;
import app.services.LaboratoryService;
import app.services.ServiceResponse;
import app.services.impl.api.LaboratoryServiceApi;
import app.services.impl.api.WorkerBrigadeServiceApi;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public class LaboratoryServiceImpl
        extends AbstractCrudServiceImpl<Laboratory>
        implements LaboratoryService {
    public LaboratoryServiceImpl(String baseUrl) {
        super(LaboratoryServiceApi.class, Laboratory.class, baseUrl, "laboratory");
    }

    @Override
    public ServiceResponse<Page<Laboratory>> getLaboratoriesByProductId(Long productId, PageInfo pageInfo) {
        var call = getServiceApi().getLaboratories(productId, PageInfo.toMap(pageInfo));
        return getServerResponse(call);

    }

    private LaboratoryServiceApi getServiceApi() {
        return (LaboratoryServiceApi) getCrudServiceApi();
    }
}