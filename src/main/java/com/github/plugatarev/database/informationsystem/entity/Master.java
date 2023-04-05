package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "master")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Master {
    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "chief", referencedColumnName = "id")
    private DepartmentRegionChief chief;
}
