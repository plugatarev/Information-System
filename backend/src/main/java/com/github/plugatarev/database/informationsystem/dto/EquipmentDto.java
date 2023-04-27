package com.github.plugatarev.database.informationsystem.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto extends AbstractDto {
    @Size(min = 10, max = 10, message = "Serial number of the equipment must be 10 characters")
    private String serialNumber;
}
