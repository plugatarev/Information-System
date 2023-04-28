package app.services.impl;

import app.model.Brigade;
import app.services.BrigadeService;
import app.services.impl.api.BrigadeServiceApi;

public class BrigadeServiceImpl
        extends AbstractCrudServiceImpl<Brigade>
        implements BrigadeService {

    public BrigadeServiceImpl(String baseUrl) {
        super(BrigadeServiceApi.class, Brigade.class, baseUrl, "brigade");
    }
}
