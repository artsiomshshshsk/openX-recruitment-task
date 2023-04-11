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
public class Geolocation {
    private double lat;

    @JsonProperty("long")
    private double lng;
}
