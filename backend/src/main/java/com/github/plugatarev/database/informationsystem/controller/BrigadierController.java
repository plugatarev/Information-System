package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.BrigadierDto;
import com.github.plugatarev.database.informationsystem.service.BrigadierService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brigadier")
@AllArgsConstructor
public class BrigadierController extends AbstractController<BrigadierDto> {

    private final BrigadierService brigadierService;

    @Override
    protected Service<BrigadierDto> getService() {
        return brigadierService;
    }
}
