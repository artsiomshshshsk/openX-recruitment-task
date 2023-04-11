package com.github.artsiomshshshsk.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.artsiomshshshsk.shopping.model.cart.CartResponse;
import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.Geolocation;
import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.util.Util;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestLoader {

    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public List<User> parseUsers(String url) throws IOException {
        User[] users = mapper.readValue(new URL(url), User[].class);
        return List.of(users);
    }

    public List<Cart> parseCarts(String url) throws IOException {
        Cart[] carts = mapper.readValue(new URL(url), Cart[].class);
        return List.of(carts);
    }

    public List<Product> parseProducts(String url) throws IOException {
        Product[] products = mapper.readValue(new URL(url), Product[].class);
        return List.of(products);
    }

    public Map<String, BigDecimal> productCategoriesTotalValue(List<Product> products) throws IOException {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.reducing(BigDecimal.ZERO,
                        Product::getPrice, BigDecimal::add)));
    }

    public CartResponse findCartWithHighestValue(List<Cart> carts, List<Product> products, List<User> users){
        Map<Cart, BigDecimal> cartToTotalValue = carts.stream()
                .collect(Collectors.toMap(Function.identity(), cart -> cart.getProducts().stream()
                        .map(product -> products.stream()
                                .filter(product1 -> product1.getId() == product.getProductId())
                                .findFirst()
                                .orElseThrow()
                                .getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)));

        Cart maxValueCart = cartToTotalValue.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();

        User user = users.stream()
                .filter(user1 -> user1.getId() == maxValueCart.getUserId())
                .findFirst()
                .orElseThrow();

        return CartResponse.builder()
                .value(cartToTotalValue.get(maxValueCart))
                .id(maxValueCart.getId())
                .ownerName(user.getName())
                .build();
    }



    public List<User> find2UsersWithMaxDistance(List<User> users) throws IOException {
        if(users.size() < 2){
            throw new IllegalArgumentException("List of users should contain at least 2 users");
        }

        double maxDistance = Double.MIN_VALUE;
        User user1 = null;
        User user2 = null;

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                double distance = Util.distance(users.get(i).getGeolocation(),users.get(j).getGeolocation());
                if (distance > maxDistance) {
                    maxDistance = distance;
                    user1 = users.get(i);
                    user2 = users.get(j);
                }
            }
        }
        return List.of(user1, user2);
    }

}
