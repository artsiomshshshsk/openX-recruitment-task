package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.cart.CartResponse;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.util.Parser;
import com.github.artsiomshshshsk.shopping.util.ParserImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record CartService(
        List<Cart> carts,
        ProductService productService,
        UserService userService
) {


    public CartResponse findCartWithHighestValue(){

        Map<Cart, BigDecimal> cartToTotalValue = getCartToTotalValue();
        Cart maxValueCart = getMaxValueCart(cartToTotalValue);
        User user = userService.findUserById(maxValueCart.getUserId());

        return CartResponse.builder()
                .value(cartToTotalValue.get(maxValueCart))
                .id(maxValueCart.getId())
                .ownerName(user.getName())
                .build();
    }

    private Map<Cart, BigDecimal> getCartToTotalValue() {
        return carts.stream()
                .collect(Collectors.toMap(Function.identity(), cart -> cart.getProducts().stream()
                        .map(product -> productService.products().stream()
                                .filter(product1 -> product1.getId() == product.getProductId())
                                .findFirst()
                                .orElseThrow()
                                .getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)));
    }

    private Cart getMaxValueCart(Map<Cart, BigDecimal> cartToTotalValue) {
        return cartToTotalValue.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }
}
