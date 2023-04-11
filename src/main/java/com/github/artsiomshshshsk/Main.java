package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.shopping.TestLoader;
import com.github.artsiomshshshsk.shopping.model.user.User;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TestLoader testLoader = new TestLoader();
        List<User> users = testLoader.parseUsers("https://fakestoreapi.com/users");
        for (User user : users) {
            System.out.println(user);
        }
    }
}