package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryTypeDto;
import com.github.plugatarev.database.informationsystem.service.ProductCategoryTypeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/productCategoryType")
@AllArgsConstructor
public class ProductCategoryTypeController extends AbstractController<ProductCategoryTypeDto> {

    private final ProductCategoryTypeService productCategoryTypeService;

    @Override
    protected Service<ProductCategoryTypeDto> getService() {
        return productCategoryTypeService;
    }
}
