package com.github.plugatarev.database.informationsystem.filter;

import com.github.plugatarev.database.informationsystem.dto.DepartmentDto;
import com.github.plugatarev.database.informationsystem.dto.LaboratoryDto;
import com.github.plugatarev.database.informationsystem.filter.type.ProductStatusEnum;
import com.github.plugatarev.database.informationsystem.filter.type.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductFilter {
    ProductTypeEnum productTypeEnum;
    ProductStatusEnum productStatusEnum;
    Date minAssembledDate;
    Date maxAssembledDate;

    LaboratoryDto laboratory;
    Date minLaboratoryDate;
    Date maxLaboratoryDate;

    DepartmentDto department;
}
