package com.github.artsiomshshshsk.shopping.model;


import lombok.Data;

@Data
public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipCode;
}
