package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.DepartmentChief;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.DepartmentChiefRepository;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentChiefService {

    private final DepartmentChiefRepository departmentChiefRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentChief save(Employee departmentChief) {
        String passport = departmentChief.getPassport();
        if (!employeeRepository.existsByPassport(passport)) {
            throw new NotUniqueEntityException("DepartmentChief with passport " + passport + " already exists!");
        }
        return departmentChiefRepository.save(new DepartmentChief(departmentChief));
    }

    public void delete(Long id) {
        departmentChiefRepository.deleteById(id);
    }

    public DepartmentChief update(Long id, Employee departmentChief) {
        DepartmentChief updateDepartmentChief = departmentChiefRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("DepartmentChief with id " + id + " not exists!")
        );
        Employee employee = updateDepartmentChief.getEmployee();
        employee.setPassport(departmentChief.getPassport());
        employee.setDismissalDate(departmentChief.getDismissalDate());
        employee.setSecondName(departmentChief.getSecondName());
        employee.setFirstName(departmentChief.getFirstName());
        employee.setEmployeeCategoryType(departmentChief.getEmployeeCategoryType());
        return departmentChiefRepository.save(updateDepartmentChief);
    }

    public DepartmentChief getById(Long id) {
        return departmentChiefRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("DepartmentChief with id " + id + " not found")
        );

    }

    public List<DepartmentChief> getAll() {
        return departmentChiefRepository.findAll();
    }
}

