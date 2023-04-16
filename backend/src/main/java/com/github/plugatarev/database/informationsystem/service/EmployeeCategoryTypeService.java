package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.EmployeeCategoryType;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.repository.EmployeeCategoryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeCategoryTypeService {

    private final EmployeeCategoryTypeRepository employeeCategoryTypeRepository;

    public EmployeeCategoryType getById(Long id) {
        return employeeCategoryTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("EmployeeCategoryType entity with id " + id + " not found")
        );
    }

    public List<EmployeeCategoryType> getAll() {
        return employeeCategoryTypeRepository.findAll();
    }
}
