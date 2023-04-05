package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
