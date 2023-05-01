package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.ProductDto;
import com.github.plugatarev.database.informationsystem.filter.ProductFilter;
import com.github.plugatarev.database.informationsystem.service.ProductService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController extends AbstractController<ProductDto> {

    private final ProductService productService;

    @Override
    protected Service<ProductDto> getService() {
        return productService;
    }

    @GetMapping("/departmentRegion/{departmentRegionId}/products")
    public Page<ProductDto> getDepartmentRegionProducts(@PathVariable("departmentRegionId") Long departmentRegionId, Pageable pageable) {
        return productService.getDepartmentRegionProducts(departmentRegionId, pageable);
    }

    @GetMapping("/department/{departmentId}/products")
    public Page<ProductDto> getDepartmentProducts(@PathVariable("departmentId") Long departmentId, Pageable pageable) {
        return productService.getDepartmentProducts(departmentId, pageable);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<ProductDto>> search(@RequestBody ProductFilter filter, Pageable pageable) {
        return ResponseEntity.ok(productService.searchByFilter(filter, pageable));
    }
}
