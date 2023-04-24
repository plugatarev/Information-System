package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionChiefDto;
import com.github.plugatarev.database.informationsystem.service.DepartmentRegionChiefService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/departmentRegionChief")
@AllArgsConstructor
public class DepartmentRegionChiefController extends AbstractController<DepartmentRegionChiefDto> {

    private final DepartmentRegionChiefService departmentRegionChiefService;

    @Override
    protected Service<DepartmentRegionChiefDto> getService() {
        return departmentRegionChiefService;
    }
}
