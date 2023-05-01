package app.services.impl;

import app.model.Department;
import app.services.DepartmentService;
import app.services.impl.api.DepartmentServiceApi;

public class DepartmentServiceImpl
        extends AbstractCrudServiceImpl<Department>
        implements DepartmentService {

    public DepartmentServiceImpl(String baseUrl) {
        super(DepartmentServiceApi.class, Department.class, baseUrl, "department");
    }
}
