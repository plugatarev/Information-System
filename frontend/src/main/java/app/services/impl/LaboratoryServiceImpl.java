package app.services.impl;

import app.model.Laboratory;
import app.services.LaboratoryService;
import app.services.impl.api.LaboratoryServiceApi;

public class LaboratoryServiceImpl
        extends AbstractCrudServiceImpl<Laboratory>
        implements LaboratoryService {

    public LaboratoryServiceImpl(String baseUrl) {
        super(LaboratoryServiceApi.class, Laboratory.class, baseUrl, "laboratory");
    }
}