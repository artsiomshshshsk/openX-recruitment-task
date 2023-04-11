package com.github.artsiomshshshsk.shopping.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;
}
