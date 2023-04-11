package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.util.Parser;
import com.github.artsiomshshshsk.shopping.util.ParserImpl;
import com.github.artsiomshshshsk.shopping.util.Util;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final List<User> users;

    private final Parser parser;

    public UserService(String url){
        parser = new ParserImpl();
        users = parser.parseUsers(url);
    }

    public Optional<User> findUserById(long id){
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }


    public List<User> find2UsersWithMaxDistance() {
        if(users.size() < 2){
            throw new IllegalArgumentException("List of users should contain at least 2 users");
        }

        double maxDistance = Double.MIN_VALUE;
        User user1 = null;
        User user2 = null;

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                double distance = Util.distance(users.get(i).getGeolocation(),users.get(j).getGeolocation());
                if (distance > maxDistance) {
                    maxDistance = distance;
                    user1 = users.get(i);
                    user2 = users.get(j);
                }
            }
        }
        return List.of(user1, user2);
    }
}
