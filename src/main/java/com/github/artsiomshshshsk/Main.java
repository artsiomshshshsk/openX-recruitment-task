package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.shopping.TestLoader;
import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.service.ProductService;
import com.github.artsiomshshshsk.shopping.service.UserService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("_______________FURTHEST USERS_______________");
        UserService service = new UserService("https://fakestoreapi.com/users");
        List<User> maxDistUsers = service.find2UsersWithMaxDistance();

        for (User user : maxDistUsers) {
            System.out.println(user);
        }


        System.out.println("_______________PRODUCTS BY CATEGORIES WITH TOTAL VALUE FOR EACH CATEGORY_______________");


        ProductService productService = new ProductService("https://fakestoreapi.com/products");
        productService.productCategoriesTotalValue().forEach((k, v) -> System.out.println(k + " : " + v));


    }
}