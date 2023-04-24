package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionDto;
import com.github.plugatarev.database.informationsystem.service.DepartmentRegionService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
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
}
