package app.services.impl;

import app.model.DepartmentRegionChief;
import app.services.DepartmentRegionChiefService;
import app.services.impl.api.DepartmentRegionChiefServiceApi;

public class DepartmentRegionChiefServiceImpl
        extends AbstractCrudServiceImpl<DepartmentRegionChief>
        implements DepartmentRegionChiefService {
    public DepartmentRegionChiefServiceImpl(String baseUrl) {
        super(DepartmentRegionChiefServiceApi.class, DepartmentRegionChief.class, baseUrl, "departmentRegionChief");
    }
}
