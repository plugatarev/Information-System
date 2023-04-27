package com.github.plugatarev.database.informationsystem.dto;

import com.github.plugatarev.database.informationsystem.entity.Laboratory;
import com.github.plugatarev.database.informationsystem.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryOrderDto extends AbstractDto {
    private Product product;

    private Laboratory laboratory;
}
