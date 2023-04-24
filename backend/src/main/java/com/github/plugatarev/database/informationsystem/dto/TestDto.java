package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDto extends AbstractDto {
    private EquipmentDto equipment;
    private TesterDto tester;
    private String description;
}
