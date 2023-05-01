package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.BrigadeDto;
import com.github.plugatarev.database.informationsystem.service.BrigadeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brigade")
@AllArgsConstructor
public class BrigadeController extends AbstractController<BrigadeDto> {

    private final BrigadeService brigadeService;

    @Override
    protected Service<BrigadeDto> getService() {
        return brigadeService;
    }

    @GetMapping("/{departmentRegionId}/brigades")
    public Page<BrigadeDto> getBrigades(@PathVariable("departmentRegionId") Long departmentRegionId, Pageable pageable) {
        return brigadeService.getBrigades(departmentRegionId, pageable);
    }
}
