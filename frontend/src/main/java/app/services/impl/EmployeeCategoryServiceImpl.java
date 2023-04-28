package app.services.impl;

import app.model.EmployeeCategory;
import app.services.EmployeeCategoryService;
import app.services.impl.api.EmployeeCategoryServiceApi;

public class EmployeeCategoryServiceImpl
        extends AbstractCrudServiceImpl<EmployeeCategory>
        implements EmployeeCategoryService {

    public EmployeeCategoryServiceImpl(String baseUrl) {
        super(EmployeeCategoryServiceApi.class, EmployeeCategory.class, baseUrl, "employeeCategory");
    }
}
