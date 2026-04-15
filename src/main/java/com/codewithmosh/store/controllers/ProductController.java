package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.ProductDto;

import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.mappers.ProductMapper;
import com.codewithmosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(
            @RequestParam(required = false) Byte categoryId
    ) {

        Iterable<Product> products;
        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else{
            products = productRepository.findAll();
        }

        return StreamSupport
                .stream(products.spliterator(), false)
                .map(productMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {

        var product =  productRepository.findById(id).orElse(null);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(productMapper.toDto(product));
    }


}
