package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerBrigadeDto extends AbstractDto {
    private EmployeeDto worker;
    private BrigadeDto brigade;
}
