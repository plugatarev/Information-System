package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionDto;
import com.github.plugatarev.database.informationsystem.service.DepartmentRegionService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/departmentRegion")
@AllArgsConstructor
public class DepartmentRegionController extends AbstractController<DepartmentRegionDto> {

    private final DepartmentRegionService departmentRegionService;

    @Override
    protected Service<DepartmentRegionDto> getService() {
        return departmentRegionService;
    }

    @GetMapping("/{departmentId}/regions")
    public Page<DepartmentRegionDto> getDepartmentRegions(@PathVariable("departmentId") Long departmentId, Pageable pageable) {
        return departmentRegionService.getDepartmentRegions(departmentId, pageable);
    }
}
