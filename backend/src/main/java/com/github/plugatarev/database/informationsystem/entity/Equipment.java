package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true)
    @Size(min = 10, max = 10, message = "Serial number of the equipment must be 10 characters")
    private String serialNumber;
}