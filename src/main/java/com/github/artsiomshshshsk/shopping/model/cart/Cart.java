package com.github.artsiomshshshsk.shopping.model.cart;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Cart {

    private long id;

    private long userId;

    private LocalDate date;

    private List<Product> products;

    private int __v;
}
