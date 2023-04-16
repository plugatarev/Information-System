package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department_chief")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentChief {

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee employee;
}