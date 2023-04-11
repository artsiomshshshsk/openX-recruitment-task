package com.github.artsiomshshshsk.shopping.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geolocation {
    private double lat;

    @JsonProperty("long")
    private double lng;
}
