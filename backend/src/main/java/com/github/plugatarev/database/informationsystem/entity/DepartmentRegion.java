package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department_region")
@Getter
@Setter
public class DepartmentRegion extends AbstractEntity {
    @Column(name = "region_name", unique = true, nullable = false)
    private String regionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_region_chief")
    private Employee departmentRegionChief;
}