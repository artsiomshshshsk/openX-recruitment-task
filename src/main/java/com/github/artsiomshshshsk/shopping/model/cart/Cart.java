package com.github.artsiomshshshsk.shopping.model.cart;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private long id;

    private long userId;

    private LocalDate date;

    private List<Product> products;

    private int __v;
}
