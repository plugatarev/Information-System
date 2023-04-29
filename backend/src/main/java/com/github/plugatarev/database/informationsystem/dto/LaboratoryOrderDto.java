package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaboratoryOrderDto extends AbstractDto {
    private ProductDto product;

    private LaboratoryDto laboratory;
}
