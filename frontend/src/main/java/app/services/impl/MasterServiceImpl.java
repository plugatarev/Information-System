package app.services.impl;

import app.model.Master;
import app.services.MasterService;
import app.services.impl.api.MasterServiceApi;

public class MasterServiceImpl
        extends AbstractCrudServiceImpl<Master>
        implements MasterService {

    public MasterServiceImpl(String baseUrl) {
        super(MasterServiceApi.class, Master.class, baseUrl, "master");
    }
}