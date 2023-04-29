package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter
@Setter
public class Equipment extends AbstractEntity {
    @Column(name = "serial_number", nullable = false, unique = true)
    @Size(min = 10, max = 10, message = "Serial number of the equipment must be 10 characters")
    private String serialNumber;
}