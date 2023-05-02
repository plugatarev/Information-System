package app.services.impl;

import app.model.Equipment;
import app.services.EquipmentService;
import app.services.impl.api.EquipmentServiceApi;

public class EquipmentServiceImpl
        extends AbstractCrudServiceImpl<Equipment>
        implements EquipmentService {

    public EquipmentServiceImpl(String baseUrl) {
        super(EquipmentServiceApi.class, Equipment.class, baseUrl, "equipment");
    }
}