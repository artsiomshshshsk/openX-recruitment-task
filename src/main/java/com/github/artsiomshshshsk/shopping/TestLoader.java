package com.github.artsiomshshshsk.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.artsiomshshshsk.shopping.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class TestLoader {


    public List<User> parseUsers(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User[] users = mapper.readValue(new URL(url), User[].class);
        return List.of(users);
    }
}
