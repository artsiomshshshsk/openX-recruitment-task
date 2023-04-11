package com.github.artsiomshshshsk.shopping.util;

import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.User;

import java.util.List;

public interface Parser {

    List<User> parseUsers(String url);

    List<Cart> parseCarts(String url);

    List<Product> parseProducts(String url);
}
