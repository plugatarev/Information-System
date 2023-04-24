package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductTypeAttributeDto;
import com.github.plugatarev.database.informationsystem.service.ProductTypeAttributeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/productTypeAttribute")
@AllArgsConstructor
public class ProductTypeAttributeController extends AbstractController<ProductTypeAttributeDto> {

    private final ProductTypeAttributeService productTypeAttributeService;

    @Override
    protected Service<ProductTypeAttributeDto> getService() {
        return productTypeAttributeService;
    }
}
