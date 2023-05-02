package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Employee extends AbstractEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "passport", nullable = false)
    private String passport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_type")
    private EmployeeCategoryType employeeCategoryType;

    @Column(name = "employment_date", nullable = false)
    private LocalDate employmentDate;

    @Column(name = "dismissal_date")
    private LocalDate dismissalDate;
}
