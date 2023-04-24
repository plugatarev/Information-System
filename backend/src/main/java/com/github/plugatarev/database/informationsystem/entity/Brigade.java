package com.github.plugatarev.database.informationsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brigade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brigade extends AbstractEntity {

    @Column(name = "brigade_name", nullable = false, unique = true)
    private String brigadeName;

    @ManyToOne
    @JoinColumn(name = "brigadier", referencedColumnName = "id")
    private Brigadier brigadier;

    @ManyToOne
    @JoinColumn(name = "department_region", referencedColumnName = "id")
    private DepartmentRegion departmentRegion;
}