package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.TesterDto;
import com.github.plugatarev.database.informationsystem.service.Service;
import com.github.plugatarev.database.informationsystem.service.TesterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tester")
@AllArgsConstructor
public class TesterController extends AbstractController<TesterDto> {

    private final TesterService testerService;

    @Override
    protected Service<TesterDto> getService() {
        return testerService;
    }
}
