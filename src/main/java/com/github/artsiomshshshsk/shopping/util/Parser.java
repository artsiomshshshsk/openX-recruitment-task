package com.github.artsiomshshshsk.shopping.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Parser {

    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public List<User> parseUsers(String url) {
        try {
            User[] users = mapper.readValue(new URL(url), User[].class);
            return List.of(users);
        }catch (IOException e){
            e.printStackTrace();
        }
        return List.of();
    }

    public List<Cart> parseCarts(String url){
        try {
            Cart[] carts = mapper.readValue(new URL(url), Cart[].class);
            return List.of(carts);
        }catch (IOException e){
            e.printStackTrace();
        }
        return List.of();
    }

    public List<Product> parseProducts(String url){
        try {
            Product[] products = mapper.readValue(new URL(url), Product[].class);
            return List.of(products);
        }catch (IOException e){
            e.printStackTrace();
        }
        return List.of();
    }
}
