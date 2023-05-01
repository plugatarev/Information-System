package app.services.filters;

import app.model.type.EmployeeTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeFilter implements Filter {
    private EmployeeTypeEnum employeeCategory;
}
