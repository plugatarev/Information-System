package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BrigadierDto extends EmployeeDto {
    public BrigadierDto(String firstName, String secondName, String passport, EmployeeCategoryTypeDto employeeCategoryType, Date employmentDate, Date dismissalDate) {
        super(firstName, secondName, passport, employeeCategoryType, employmentDate, dismissalDate);
    }

    public BrigadierDto(){
        super();
    }
}
