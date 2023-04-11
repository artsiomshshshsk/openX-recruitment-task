package com.github.artsiomshshshsk.shopping.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String title;

    private BigDecimal price;

    private String description;

    private String category;

    private String image;

    private Rating rating;
}
