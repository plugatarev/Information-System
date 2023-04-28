package app.services.impl;

import app.model.Brigadier;
import app.services.BrigadierService;
import app.services.impl.api.BrigadierServiceApi;

public class BrigadierServiceImpl
        extends AbstractCrudServiceImpl<Brigadier>
        implements BrigadierService {
    public BrigadierServiceImpl(String baseUrl) {
        super(BrigadierServiceApi.class, Brigadier.class, baseUrl, "brigadier");
    }
}