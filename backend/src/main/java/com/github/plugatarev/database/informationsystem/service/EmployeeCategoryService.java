package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeCategory;
import com.github.plugatarev.database.informationsystem.mapper.EmployeeCategoryMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeCategoryService extends AbstractService<EmployeeCategory, EmployeeCategoryDto> {

    private final EmployeeCategoryRepository employeeCategoryRepository;
    private final EmployeeCategoryMapper employeeCategoryMapper;

    @Override
    protected JpaRepository<EmployeeCategory, Long> getRepository() {
        return employeeCategoryRepository;
    }

    @Override
    protected IMapper<EmployeeCategory, EmployeeCategoryDto> getMapper() {
        return employeeCategoryMapper;
    }
}
