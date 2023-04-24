package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.RegionBrigadeDto;
import com.github.plugatarev.database.informationsystem.service.RegionBrigadeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/regionBrigade")
@AllArgsConstructor
public class RegionBrigadeController extends AbstractController<RegionBrigadeDto> {

    private RegionBrigadeService regionBrigadeService;

    @Override
    protected Service<RegionBrigadeDto> getService() {
        return regionBrigadeService;
    }
}
