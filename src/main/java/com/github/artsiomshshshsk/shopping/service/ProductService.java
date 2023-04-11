package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.product.Product;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@AllArgsConstructor
public class ProductService {

    private final List<Product> products;

    /**
     * Returns a map of product categories and their total value
     *
     * @return Map<String, BigDecimal>
     */
    public Map<String, BigDecimal> productCategoriesTotalValue() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.reducing(BigDecimal.ZERO,
                        Product::getPrice, BigDecimal::add)));
    }

    public List<Product> products() {
        return products;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ProductService) obj;
        return Objects.equals(this.products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "ProductService[" +
                "products=" + products + ']';
    }

}
