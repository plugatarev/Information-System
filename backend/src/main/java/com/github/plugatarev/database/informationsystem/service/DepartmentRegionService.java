package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentRegionService {

    private final DepartmentRegionRepository departmentRegionRepository;

    public DepartmentRegion save(DepartmentRegion departmentRegion) {
        String regionName = departmentRegion.getRegionName();
        if (departmentRegionRepository.existsByRegionName(regionName)) {
            throw new NotUniqueEntityException("DepartmentRegion with name " + regionName + " already exists!");
        }
        return departmentRegionRepository.save(departmentRegion);
    }

    public void delete(Long id) {
        departmentRegionRepository.deleteById(id);
    }

    public DepartmentRegion update(Long id, DepartmentRegion departmentRegion) {
        DepartmentRegion updateDepartmentRegion = departmentRegionRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("DepartmentRegion entity with id " + id + " not found")
        );
        updateDepartmentRegion.setDepartment(departmentRegion.getDepartment());
        updateDepartmentRegion.setChief(departmentRegion.getChief());
        updateDepartmentRegion.setRegionName(departmentRegion.getRegionName());
        updateDepartmentRegion.setCollectingBrigade(departmentRegion.getCollectingBrigade());
        return departmentRegionRepository.save(updateDepartmentRegion);
    }

    public DepartmentRegion getById(Long id) {
        return departmentRegionRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("DepartmentRegion entity with id " + id + " not found")
        );
    }

    public List<DepartmentRegion> getAll() {
        return departmentRegionRepository.findAll();
    }
}
