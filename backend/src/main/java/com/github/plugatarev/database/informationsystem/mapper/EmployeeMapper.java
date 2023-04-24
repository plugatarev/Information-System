package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    EmployeeDto employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
}
