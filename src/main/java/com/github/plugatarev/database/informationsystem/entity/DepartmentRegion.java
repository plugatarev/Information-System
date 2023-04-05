package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department_region")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_name", unique = true, nullable = false)
    private String regionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collecting_brigade")
    private Brigade collectingBrigade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief")
    private DepartmentRegionChief chief;

    @OneToMany(mappedBy = "departmentRegion")
    private List<ProductProcess> productProcesses = new ArrayList<>();
}