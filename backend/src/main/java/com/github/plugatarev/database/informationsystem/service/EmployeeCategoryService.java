package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.EmployeeCategory;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.repository.EmployeeCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeCategoryService {

    private final EmployeeCategoryRepository employeeCategoryRepository;

    public EmployeeCategory getById(Long id) {
        return employeeCategoryRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("EmployeeCategory entity with id " + id + " not found")
        );
    }

    public List<EmployeeCategory> getAll() {
        return employeeCategoryRepository.findAll();
    }
}
