package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.MasterDto;
import com.github.plugatarev.database.informationsystem.service.MasterService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/master")
@AllArgsConstructor
public class MasterController extends AbstractController<MasterDto> {

    private final MasterService masterService;

    @Override
    protected Service<MasterDto> getService() {
        return masterService;
    }

    @GetMapping("/departmentRegion/{departmentRegionId}/masters")
    public Page<MasterDto> getDepartmentRegionMasters(@PathVariable("departmentRegionId") Long departmentRegionId, Pageable pageable) {
        return masterService.getDepartmentRegionMasters(departmentRegionId, pageable);
    }

    @GetMapping("/department/{departmentId}/masters")
    public Page<MasterDto> getDepartmentMasters(@PathVariable("departmentId") Long departmentId, Pageable pageable) {
        return masterService.getDepartmentMasters(departmentId, pageable);
    }
}
