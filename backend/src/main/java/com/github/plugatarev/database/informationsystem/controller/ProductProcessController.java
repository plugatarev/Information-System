package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductProcessDto;
import com.github.plugatarev.database.informationsystem.service.ProductProcessService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/productProcess")
@AllArgsConstructor
public class ProductProcessController extends AbstractController<ProductProcessDto> {

    private final ProductProcessService productProcessService;
    @Override
    protected Service<ProductProcessDto> getService() {
        return productProcessService;
    }

    @GetMapping("/products/{productId}")
    public Page<ProductProcessDto> getProductProcessByProduct(@PathVariable("productId") Long productId, Pageable pageable) {
        return productProcessService.getProductProcessByProduct(productId, pageable);
    }
}
