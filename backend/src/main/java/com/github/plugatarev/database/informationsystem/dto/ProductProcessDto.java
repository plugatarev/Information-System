package com.github.plugatarev.database.informationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductProcessDto extends AbstractDto {
    private ProductDto product;
    private String descriptionWork;
    private DepartmentRegionDto departmentRegion;
    private ProductStatusDto status;
    private LocalDate releaseDate;
}
