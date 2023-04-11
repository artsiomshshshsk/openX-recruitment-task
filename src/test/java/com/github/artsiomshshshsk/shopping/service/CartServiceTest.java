package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.cart.Cart;
import com.github.artsiomshshshsk.shopping.model.cart.CartResponse;
import com.github.artsiomshshshsk.shopping.model.product.Product;
import com.github.artsiomshshshsk.shopping.model.user.Name;
import com.github.artsiomshshshsk.shopping.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CartServiceTest {

    private CartService cartService;

    private UserService userServiceMock;
    private ProductService productServiceMock;

    @BeforeEach
    void setUp() {
        userServiceMock = Mockito.mock(UserService.class);
        when(userServiceMock.getUsers()).thenReturn(getUserList());
        productServiceMock = Mockito.mock(ProductService.class);
        when(productServiceMock.getProducts()).thenReturn(getProductList());
        cartService = new CartService(
                getCartList(),
                productServiceMock,
                userServiceMock
        );
    }

    @Test
    void findCartWithHighestValue(){
        //given
        //when
        when(userServiceMock.findUserById(1)).thenReturn(getUserList().get(0));
        when(userServiceMock.findUserById(2)).thenReturn(getUserList().get(1));
        CartResponse result = cartService.findCartWithHighestValue();
        //then
        assertEquals(2, result.id());
        assertEquals(BigDecimal.valueOf(100), result.value());
        assertEquals(new Name("Name 2", "Surname 2"), result.ownerName());
    }


    private List<Cart> getCartList(){
        return List.of(
                Cart.builder()
                        .id(1)
                        .userId(1)
                        .products(
                                List.of(com.github.artsiomshshshsk.shopping.model.cart.Product.builder()
                                        .productId(1)
                                        .quantity(5)
                                        .build()
                                )
                        )
                        .build(),
                Cart.builder()
                        .id(2)
                        .userId(2)
                        .products(
                                List.of(com.github.artsiomshshshsk.shopping.model.cart.Product.builder()
                                        .productId(1)
                                        .quantity(10)
                                        .build()
                                )
                        )
                        .build()
        );
    }

    private List<User> getUserList(){
        return List.of(
                User.builder()
                        .id(1)
                        .name(new Name("Name 1", "Surname 1"))
                        .build(),
                User.builder()
                        .id(2)
                        .name(new Name("Name 2", "Surname 2"))
                        .build()
        );
    }

    private List<Product> getProductList(){
        return List.of(
                Product.builder()
                        .id(1)
                        .price(BigDecimal.TEN)
                        .build()
        );
    }


}