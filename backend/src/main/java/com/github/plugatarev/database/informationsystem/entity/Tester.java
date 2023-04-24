package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "laboratory_employee")
@Getter
@Setter
public class Tester extends Employee {
}