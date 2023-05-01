package com.github.plugatarev.database.informationsystem.filter;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryDto;
import com.github.plugatarev.database.informationsystem.dto.ProductDto;
import com.github.plugatarev.database.informationsystem.filter.type.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EquipmentFilter {
    ProductDto product;
    ProductTypeEnum productType;
    LaboratoryDto laboratory;
    Date minDateTest;
    Date maxDateTest;
}
