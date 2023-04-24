package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductStatusDto;
import com.github.plugatarev.database.informationsystem.service.ProductStatusService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/productStatus")
@AllArgsConstructor
public class ProductStatusController extends AbstractController<ProductStatusDto> {

    private ProductStatusService productStatusService;

    @Override
    protected Service<ProductStatusDto> getService() {
        return productStatusService;
    }
}
