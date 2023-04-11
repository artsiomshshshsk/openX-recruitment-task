package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.shopping.TestLoader;
import com.github.artsiomshshshsk.shopping.model.product.Product;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TestLoader testLoader = new TestLoader();
//        List<User> users = testLoader.parseUsers("https://fakestoreapi.com/users");
//        for (User user : users) {
//            System.out.println(user);
//        }
//        List<Cart> carts = testLoader.parseCarts("https://fakestoreapi.com/carts");
//        for (Cart cart : carts) {
//            System.out.println(cart);
//        }

//
//        List<Product> products = testLoader.parseProducts("https://fakestoreapi.com/products");
//        for (Product product : products) {
//            System.out.println(product);
//        }

        testLoader.task1();


    }
}