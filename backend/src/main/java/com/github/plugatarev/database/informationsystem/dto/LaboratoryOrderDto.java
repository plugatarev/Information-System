package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaboratoryOrderDto extends AbstractDto {
    private LaboratoryOrderDto laboratoryOrder;
    private TestDto test;
}
