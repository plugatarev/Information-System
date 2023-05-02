package app.services.impl;

import app.model.OrderTest;
import app.services.OrderTestService;
import app.services.impl.api.OrderTestServiceApi;

public class OrderTestServiceImpl extends AbstractCrudServiceImpl<OrderTest>
        implements OrderTestService {

    public OrderTestServiceImpl(String baseUrl) {
        super(OrderTestServiceApi.class, OrderTest.class, baseUrl, "orderTest");
    }
}
