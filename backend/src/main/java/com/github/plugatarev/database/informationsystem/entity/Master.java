package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master")
@Getter
@Setter
public class Master extends Employee {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_region_chief", referencedColumnName = "id")
    private Employee departmentRegionChief;
}
