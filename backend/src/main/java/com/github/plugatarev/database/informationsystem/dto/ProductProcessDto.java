package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductProcessDto extends AbstractDto {
    private ProductDto product;
    private String descriptionWork;
    private BrigadeDto collectingBrigade;
    private ProductStatusDto status;
    private Date releaseDate;
}
