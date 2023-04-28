package app.services.impl;

import app.model.LaboratoryOrder;
import app.services.LaboratoryOrderService;
import app.services.impl.api.LaboratoryOrderServiceApi;

public class LaboratoryOrderServiceImpl
        extends AbstractCrudServiceImpl<LaboratoryOrder>
        implements LaboratoryOrderService {

    public LaboratoryOrderServiceImpl(String baseUrl) {
        super(LaboratoryOrderServiceApi.class, LaboratoryOrder.class, baseUrl, "laboratoryOrder");
    }
}
