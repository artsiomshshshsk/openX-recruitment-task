package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record ProductService(
        List<Product> products
) {


    /**
     * Returns a map of product categories and their total value
     * @return Map<String, BigDecimal>
     */
    public Map<String, BigDecimal> productCategoriesTotalValue() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.reducing(BigDecimal.ZERO,
                        Product::getPrice, BigDecimal::add)));
    }
}
