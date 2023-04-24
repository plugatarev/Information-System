package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryDto;
import com.github.plugatarev.database.informationsystem.service.ProductCategoryService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/productCategory")
@AllArgsConstructor
public class ProductCategoryController extends AbstractController<ProductCategoryDto> {

    private ProductCategoryService productCategoryService;

    @Override
    protected Service<ProductCategoryDto> getService() {
        return productCategoryService;
    }
}
