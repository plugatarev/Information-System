package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDto extends AbstractDto {
    private String firstName;
    private String secondName;
    private String passport;
    private EmployeeCategoryTypeDto employeeCategoryType;
    private LocalDate employmentDate;
    private LocalDate dismissalDate;
}
