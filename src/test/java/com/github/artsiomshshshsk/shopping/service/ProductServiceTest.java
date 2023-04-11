package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(getProducts());
    }



    @Test
    void productCategoriesTotalValue_returnMapOfProductCategoriesAndTheirTotalValue(){
        //given
        //when
        var result = productService.productCategoriesTotalValue();
        //then
        assertEquals(3, result.size());
        assertEquals(BigDecimal.valueOf(30), result.get("Category 1"));
        assertEquals(BigDecimal.valueOf(30), result.get("Category 2"));
        assertEquals(BigDecimal.valueOf(40), result.get("Category 3"));
    }

    private List<Product> getProducts(){
        return List.of(
                Product.builder()
                        .id(1)
                        .category("Category 1")
                        .price(BigDecimal.valueOf(10))
                        .build(),
                Product.builder()
                        .id(2)
                        .category("Category 1")
                        .price(BigDecimal.valueOf(20))
                        .build(),
                Product.builder()
                        .id(3)
                        .category("Category 2")
                        .price(BigDecimal.valueOf(30))
                        .build(),
                Product.builder()
                        .id(4)
                        .category("Category 3")
                        .price(BigDecimal.valueOf(40))
                        .build()
        );
    }
}