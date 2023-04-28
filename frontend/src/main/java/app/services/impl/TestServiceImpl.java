package app.services.impl;

import app.model.Test;
import app.services.TestService;
import app.services.impl.api.TestServiceApi;

public class TestServiceImpl
        extends AbstractCrudServiceImpl<Test>
        implements TestService {

    public TestServiceImpl(String baseUrl) {
        super(TestServiceApi.class, Test.class, baseUrl, "test");
    }
}