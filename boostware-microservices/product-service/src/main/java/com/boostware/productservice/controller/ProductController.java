package com.boostware.productservice.controller;

import com.boostware.productservice.dto.ProductRequest;
import com.boostware.productservice.dto.ProductResponse;
import com.boostware.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        List<String> test = new ArrayList<>();
        return productService.getAllProducts();
    }
}
