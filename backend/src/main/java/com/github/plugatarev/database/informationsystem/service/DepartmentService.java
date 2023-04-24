package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.DepartmentDto;
import com.github.plugatarev.database.informationsystem.entity.Department;
import com.github.plugatarev.database.informationsystem.mapper.DepartmentMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService extends AbstractService<Department, DepartmentDto> {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    protected JpaRepository<Department, Long> getRepository() {
        return departmentRepository;
    }

    @Override
    protected IMapper<Department, DepartmentDto> getMapper() {
        return departmentMapper;
    }
}
