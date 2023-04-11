package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.shopping.TestLoader;
import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.service.UserService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        UserService service = new UserService("https://fakestoreapi.com/users");
        List<User> maxDistUsers = service.find2UsersWithMaxDistance();

        for (User user : maxDistUsers) {
            System.out.println(user);
        }

    }
}