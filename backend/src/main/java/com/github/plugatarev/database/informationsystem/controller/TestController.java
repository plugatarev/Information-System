package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.TestDto;
import com.github.plugatarev.database.informationsystem.service.Service;
import com.github.plugatarev.database.informationsystem.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@AllArgsConstructor
public class TestController extends AbstractController<TestDto> {

    private final TestService testService;

    @Override
    protected Service<TestDto> getService() {
        return testService;
    }
}
