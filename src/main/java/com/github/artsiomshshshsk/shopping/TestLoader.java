package com.github.artsiomshshshsk.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class TestLoader {

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

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
}
