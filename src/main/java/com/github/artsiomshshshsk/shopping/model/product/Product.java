package com.github.artsiomshshshsk.shopping.model.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private long id;

    private String title;

    private BigDecimal price;

    private String description;

    private String category;

    private String image;

    private Rating rating;
}
