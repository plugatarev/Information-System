package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductPropertyDto;
import com.github.plugatarev.database.informationsystem.service.ProductPropertyService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/productProperty")
@AllArgsConstructor
public class ProductPropertyController extends AbstractController<ProductPropertyDto>{

    private ProductPropertyService productPropertyService;

    @Override
    protected Service<ProductPropertyDto> getService() {
        return productPropertyService;
    }
}
