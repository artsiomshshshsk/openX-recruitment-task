package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.user.Address;
import com.github.artsiomshshshsk.shopping.model.user.Geolocation;
import com.github.artsiomshshshsk.shopping.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


class UserServiceTest {

    private UserService userService;



    @BeforeEach
    void setUp() {
        userService = new UserService(getUsersList());
    }

    @Test
    void findUserById_userExists_returnUser(){
        //given
        long id = 1;
        //when
        User user = userService.findUserById(id);
        //then
        assertEquals(id, user.getId());
    }

    @Test
    void findUserById_userNotExists_throwException(){
        //given
        long id = 4;
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> userService.findUserById(id));
    }


    @Test
    void find2UsersWithMaxDistance_listOfUsersContains2Users_return2Users(){
        //given
        //when
        List<User> users = userService.find2UsersWithMaxDistance();
        //then
        assertEquals(2, users.size());
        assertEquals(1, users.get(0).getId());
        assertEquals(3, users.get(1).getId());
    }

    @Test
    void find2UsersWithMaxDistance_listOfUsersContainsLessThan2Users_throwException(){
        //given
        userService = new UserService(List.of(getUsersList().get(0)));
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> userService.find2UsersWithMaxDistance());
    }

    private List<User> getUsersList(){
        return List.of(
            User.builder()
                    .id(1)
                    .address(
                            Address.builder()
                                    .geolocation(
                                            Geolocation.builder()
                                                    .lat(-37.3159)
                                                    .lng(81.1496)
                                                    .build()
                                    )
                                    .build()
                    )
                    .build(),
            User.builder()
                    .id(2)
                    .address(
                            Address.builder()
                                    .geolocation(
                                            Geolocation.builder()
                                                    .lat(-37.3159)
                                                    .lng(81.1496)
                                                    .build()
                                    )
                                    .build()
                    )
                    .build(),
            User.builder()
                    .id(3)
                    .address(
                            Address.builder()
                                    .geolocation(
                                            Geolocation.builder()
                                                    .lat(40.3467)
                                                    .lng(-30.1310)
                                                    .build()
                                    )
                                    .build()
                    )
                    .build()
        );
    }



}