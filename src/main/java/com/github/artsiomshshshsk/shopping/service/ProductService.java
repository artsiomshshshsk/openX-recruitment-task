package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.util.Parser;
import com.github.artsiomshshshsk.shopping.util.ParserImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

    private final List<Product> products;

    private final Parser parser;

    public ProductService(String url) {
        this.parser = new ParserImpl();
        this.products = parser.parseProducts(url);
    }


    public Map<String, BigDecimal> productCategoriesTotalValue(){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.reducing(BigDecimal.ZERO,
                        Product::getPrice, BigDecimal::add)));
    }
}
