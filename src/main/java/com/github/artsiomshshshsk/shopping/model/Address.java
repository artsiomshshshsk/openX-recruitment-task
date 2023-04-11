package com.github.artsiomshshshsk.shopping.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;

    @JsonProperty("zipcode")
    private String zipCode;
}
