package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTestDto extends AbstractDto {
    private LaboratoryOrderDto laboratoryOrder;

    private TestDto test;
}
