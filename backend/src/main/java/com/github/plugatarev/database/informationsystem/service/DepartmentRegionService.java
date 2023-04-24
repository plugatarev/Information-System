package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import com.github.plugatarev.database.informationsystem.mapper.DepartmentRegionMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentRegionService extends AbstractService<DepartmentRegion, DepartmentRegionDto> {


    private final DepartmentRegionRepository departmentRegionRepository;
    private final DepartmentRegionMapper departmentRegionMapper;

    @Override
    protected JpaRepository<DepartmentRegion, Long> getRepository() {
        return departmentRegionRepository;
    }

    @Override
    protected IMapper<DepartmentRegion, DepartmentRegionDto> getMapper() {
        return departmentRegionMapper;
    }
}
