package app.services.impl;

import app.model.Employee;
import app.services.EmployeeService;
import app.services.impl.api.EmployeeServiceApi;

public class EmployeeServiceImpl
        extends AbstractCrudServiceImpl<Employee>
        implements EmployeeService {

    public EmployeeServiceImpl(String baseUrl) {
        super(EmployeeServiceApi.class, Employee.class, baseUrl, "employee");
    }
}