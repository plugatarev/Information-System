package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master")
@Getter
@Setter
public class Master extends Employee {

    @ManyToOne
    @JoinColumn(name = "chief", referencedColumnName = "id")
    private DepartmentRegionChief chief;
}
