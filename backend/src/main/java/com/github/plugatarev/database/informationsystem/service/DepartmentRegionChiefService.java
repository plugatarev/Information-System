package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRegionChiefRepository;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentRegionChiefService {

    private final DepartmentRegionChiefRepository departmentRegionChiefRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentRegionChief save(Employee departmentRegionChief) {
        String passport = departmentRegionChief.getPassport();
        if (!employeeRepository.existsByPassport(passport)) {
            throw new NotUniqueEntityException("DepartmentChief with passport " + passport + " already exists!");
        }
        return departmentRegionChiefRepository.save(new DepartmentRegionChief(departmentRegionChief));
    }

    public void delete(Long id) {
        departmentRegionChiefRepository.deleteById(id);
    }

    public DepartmentRegionChief update(Long id, Employee departmentChief) {
        DepartmentRegionChief departmentRegionChief = departmentRegionChiefRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("DepartmentRegionChief with id " + id + " not exists!")
        );
        Employee employee = departmentRegionChief.getEmployee();
        employee.setPassport(departmentChief.getPassport());
        employee.setDismissalDate(departmentChief.getDismissalDate());
        employee.setSecondName(departmentChief.getSecondName());
        employee.setFirstName(departmentChief.getFirstName());
        employee.setEmployeeCategoryType(departmentChief.getEmployeeCategoryType());
        return departmentRegionChiefRepository.save(departmentRegionChief);
    }

    public DepartmentRegionChief getById(Long id) {
        return departmentRegionChiefRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("DepartmentChief with id " + id + " not found")
        );

    }

    public List<DepartmentRegionChief> getAll() {
        return departmentRegionChiefRepository.findAll();
    }
}
