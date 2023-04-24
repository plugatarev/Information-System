package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryOrderDto;
import com.github.plugatarev.database.informationsystem.service.LaboratoryOrderService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/laboratoryOrder")
@AllArgsConstructor
public class LaboratoryOrderController extends AbstractController<LaboratoryOrderDto> {

    private final LaboratoryOrderService laboratoryOrderService;

    @Override
    protected Service<LaboratoryOrderDto> getService() {
        return laboratoryOrderService;
    }
}
