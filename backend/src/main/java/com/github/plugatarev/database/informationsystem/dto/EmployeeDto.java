package com.github.plugatarev.database.informationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends AbstractDto {
    private String firstName;
    private String secondName;
    private String passport;
    private EmployeeCategoryTypeDto employeeCategoryType;
    private Date employmentDate;
    private Date dismissalDate;
}
