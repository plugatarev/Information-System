package app.services.impl;

import app.model.EmployeeCategoryType;
import app.services.EmployeeCategoryTypeService;
import app.services.impl.api.EmployeeCategoryTypeServiceApi;

public class EmployeeCategoryTypeServiceImpl
        extends AbstractCrudServiceImpl<EmployeeCategoryType>
        implements EmployeeCategoryTypeService {

    public EmployeeCategoryTypeServiceImpl(String baseUrl) {
        super(EmployeeCategoryTypeServiceApi.class, EmployeeCategoryType.class, baseUrl, "employeeCategoryType");
    }
}
