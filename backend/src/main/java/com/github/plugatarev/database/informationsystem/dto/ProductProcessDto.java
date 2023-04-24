package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductProcessDto extends AbstractDto {
    private ProductDto product;
    private String descriptionWork;
    private DepartmentRegionDto departmentRegion;
    private ProductStatusDto status;
    private LocalDate releaseDate;
}
