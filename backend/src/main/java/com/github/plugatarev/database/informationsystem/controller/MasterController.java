package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.MasterDto;
import com.github.plugatarev.database.informationsystem.service.MasterService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
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
}
