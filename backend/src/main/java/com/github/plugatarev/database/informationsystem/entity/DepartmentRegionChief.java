package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department_region_chief")
@Getter
@Setter
public class DepartmentRegionChief extends Employee {
}