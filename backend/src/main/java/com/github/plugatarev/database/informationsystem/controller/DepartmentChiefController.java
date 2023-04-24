package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.DepartmentChiefDto;
import com.github.plugatarev.database.informationsystem.service.DepartmentChiefService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/departmentChief")
@AllArgsConstructor
public class DepartmentChiefController extends AbstractController<DepartmentChiefDto> {

    private final DepartmentChiefService departmentChiefService;

    @Override
    protected Service<DepartmentChiefDto> getService() {
        return departmentChiefService;
    }
}