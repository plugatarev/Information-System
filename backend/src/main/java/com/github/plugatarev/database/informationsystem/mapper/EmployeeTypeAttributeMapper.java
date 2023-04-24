package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeeTypeAttributeDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeTypeAttribute;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeTypeAttributeMapper {
    EmployeeTypeAttributeDto employeeTypeAttributeToEmployeeTypeAttributeDto(EmployeeTypeAttribute employeeTypeAttribute);

    EmployeeTypeAttribute employeeTypeAttributeDtoToEmployeeTypeAttribute(EmployeeTypeAttributeDto employeeTypeAttributeDto);
}
