package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department_chief")
@Getter
@Setter
public class DepartmentChief extends Employee {
}