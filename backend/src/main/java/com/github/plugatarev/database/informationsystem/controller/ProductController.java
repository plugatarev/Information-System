package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductDto;
import com.github.plugatarev.database.informationsystem.service.ProductService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController extends AbstractController<ProductDto> {

    private final ProductService productService;

    @Override
    protected Service<ProductDto> getService() {
        return productService;
    }
}
