package app.services.filters;

import app.model.Department;
import app.model.DepartmentRegion;
import app.model.type.EmployeeTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeFilter implements Filter {
    private EmployeeTypeEnum employeeCategory;
    private Department department;
    private DepartmentRegion departmentRegion;
}
