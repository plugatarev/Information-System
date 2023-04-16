package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        String passport = employee.getPassport();
        if (!employeeRepository.existsByPassport(passport)) {
            throw new NotUniqueEntityException("Employee with passport " + passport + " already exists!");
        }
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(Long id, Employee employee) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Employee with id " + id + " not exists!")
        );
        updateEmployee.setPassport(employee.getPassport());
        updateEmployee.setDismissalDate(employee.getDismissalDate());
        updateEmployee.setSecondName(employee.getSecondName());
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setEmployeeCategoryType(employee.getEmployeeCategoryType());
        return employeeRepository.save(updateEmployee);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Employee with id " + id + " not found")
        );

    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
