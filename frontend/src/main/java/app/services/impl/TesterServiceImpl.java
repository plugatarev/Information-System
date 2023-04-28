package app.services.impl;

import app.model.Tester;
import app.services.TesterService;
import app.services.impl.api.TesterServiceApi;

public class TesterServiceImpl
        extends AbstractCrudServiceImpl<Tester>
        implements TesterService {

    public TesterServiceImpl(String baseUrl) {
        super(TesterServiceApi.class, Tester.class, baseUrl, "tester");
    }
}