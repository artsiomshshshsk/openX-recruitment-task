package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.shopping.TestLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TestLoader testLoader = new TestLoader();
        testLoader.parseUsers("https://fakestoreapi.com/users");
    }
}