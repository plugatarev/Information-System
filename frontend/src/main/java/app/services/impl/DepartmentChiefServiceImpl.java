package app.services.impl;

import app.model.DepartmentChief;
import app.services.DepartmentChiefService;
import app.services.impl.api.DepartmentChiefServiceApi;

public class DepartmentChiefServiceImpl
        extends AbstractCrudServiceImpl<DepartmentChief>
        implements DepartmentChiefService {
    public DepartmentChiefServiceImpl(String baseUrl) {
        super(DepartmentChiefServiceApi.class, DepartmentChief.class, baseUrl, "departmentChief");
    }
}
