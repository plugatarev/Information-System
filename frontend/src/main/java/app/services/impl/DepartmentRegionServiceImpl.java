package app.services.impl;

import app.model.DepartmentRegion;
import app.services.DepartmentRegionService;
import app.services.impl.api.DepartmentRegionServiceApi;

public class DepartmentRegionServiceImpl
        extends AbstractCrudServiceImpl<DepartmentRegion>
        implements DepartmentRegionService {

    public DepartmentRegionServiceImpl(String baseUrl) {
        super(DepartmentRegionServiceApi.class, DepartmentRegion.class, baseUrl, "departmentRegion");
    }
}
