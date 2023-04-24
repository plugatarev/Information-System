package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryDto;
import com.github.plugatarev.database.informationsystem.service.LaboratoryService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/laboratory")
@AllArgsConstructor
public class LaboratoryController extends AbstractController<LaboratoryDto> {
    private final LaboratoryService laboratoryService;

    @Override
    protected Service<LaboratoryDto> getService() {
        return laboratoryService;
    }
}
