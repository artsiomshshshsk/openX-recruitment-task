package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.cart.CartResponse;
import com.github.artsiomshshshsk.shopping.model.user.User;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CartService {

    private final List<Cart> carts;
    private final ProductService productService;
    private final UserService userService;

    /**
     * Returns a cart with the highest value
     *
     * @return CartResponse
     */
    public CartResponse findCartWithHighestValue() {

        Map<Cart, BigDecimal> cartToTotalValue = getCartToTotalValue();
        Cart maxValueCart = getMaxValueCart(cartToTotalValue);
        User user = userService.findUserById(maxValueCart.getUserId());

        return CartResponse.builder()
                .value(cartToTotalValue.get(maxValueCart))
                .id(maxValueCart.getId())
                .ownerName(user.getName())
                .build();
    }


    /**
     * Returns a map of carts and their total value
     *
     * @return Map<Cart, BigDecimal>
     */
    private Map<Cart, BigDecimal> getCartToTotalValue() {
        return carts.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        cart -> cart.getProducts().stream()
                            .map(product -> productService.products().stream()
                                    .filter(product1 -> product1.getId() == product.getProductId())
                                    .findFirst()
                                    .orElseThrow()
                                    .getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                            .reduce(BigDecimal.ZERO, BigDecimal::add))
                );
    }

    /**
     * @param cartToTotalValue Returns a cart with the highest value
     * @return Cart
     */
    private Cart getMaxValueCart(Map<Cart, BigDecimal> cartToTotalValue) {
        return cartToTotalValue.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public List<Cart> carts() {
        return carts;
    }

    public ProductService productService() {
        return productService;
    }

    public UserService userService() {
        return userService;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CartService) obj;
        return Objects.equals(this.carts, that.carts) &&
                Objects.equals(this.productService, that.productService) &&
                Objects.equals(this.userService, that.userService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carts, productService, userService);
    }

    @Override
    public String toString() {
        return "CartService[" +
                "carts=" + carts + ", " +
                "productService=" + productService + ", " +
                "userService=" + userService + ']';
    }

}
