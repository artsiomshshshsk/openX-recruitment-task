package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.service.CartService;
import com.github.artsiomshshshsk.shopping.service.ProductService;
import com.github.artsiomshshshsk.shopping.service.UserService;
import com.github.artsiomshshshsk.shopping.util.Parser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("_______________FURTHEST USERS_______________");

        Parser parser = new Parser();
        List<User> users = parser.parseUsers("https://fakestoreapi.com/users");

        UserService userService = new UserService(users);
        List<User> maxDistUsers = userService.find2UsersWithMaxDistance();

        for (User user : maxDistUsers) {
            System.out.println(user);
        }


        System.out.println("_______________PRODUCTS BY CATEGORIES WITH TOTAL VALUE FOR EACH CATEGORY_______________");

        List<Product> products = parser.parseProducts("https://fakestoreapi.com/products");
        ProductService productService = new ProductService(products);
        productService.productCategoriesTotalValue().forEach((k, v) -> System.out.println(k + " : " + v));


        System.out.println("_______________CART WITH HIGHEST VALUE_______________");

        List<Cart> carts = parser.parseCarts("https://fakestoreapi.com/carts");

        CartService cartService = new CartService(carts,productService, userService);
        System.out.println(cartService.findCartWithHighestValue());


    }
}