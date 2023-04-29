package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto extends AbstractDto {
    private String firstName;
    private String secondName;
    private String passport;
    private EmployeeCategoryTypeDto employeeCategoryType;
    private Date employmentDate;
    private Date dismissalDate;
}
