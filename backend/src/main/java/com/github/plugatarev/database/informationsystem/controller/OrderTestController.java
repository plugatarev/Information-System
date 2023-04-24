package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.OrderTestDto;
import com.github.plugatarev.database.informationsystem.service.OrderTestService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orderTest")
@AllArgsConstructor
public class OrderTestController extends AbstractController<OrderTestDto> {

    private final OrderTestService orderTestService;

    @Override
    protected Service<OrderTestDto> getService() {
        return orderTestService;
    }
}
