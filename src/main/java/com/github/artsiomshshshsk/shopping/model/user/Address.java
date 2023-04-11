package com.github.artsiomshshshsk.shopping.model.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;

    @JsonProperty("zipcode")
    private String zipCode;
}
