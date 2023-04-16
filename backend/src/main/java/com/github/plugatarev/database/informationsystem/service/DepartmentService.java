package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.Department;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department save(Department department) {
        String departmentName = department.getDepartmentName();
        if (departmentRepository.existsByDepartmentName(departmentName)) {
            throw new NotUniqueEntityException("Department with name " + departmentName + " already exists!");
        }
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department update(Long id, Department department) {
        Department updateDepartment = departmentRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Department entity with id " + id + " not found")
        );
        updateDepartment.setDepartmentName(department.getDepartmentName());
        updateDepartment.setChief(department.getChief());
        updateDepartment.setCompany(department.getCompany());
        return departmentRepository.save(updateDepartment);
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Department entity with id " + id + " not found")
        );
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
