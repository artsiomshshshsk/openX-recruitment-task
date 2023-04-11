package com.github.artsiomshshshsk.shopping.model.user;

import lombok.Data;

@Data
public class User {

    private Address address;

    private long id;

    private String email;

    private String username;

    private String password;

    private Name name;

    private String phone;

    private int __v;

    public Geolocation getGeolocation() {
        return address.getGeolocation();
    }
}
