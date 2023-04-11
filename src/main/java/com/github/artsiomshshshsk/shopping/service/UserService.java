package com.github.artsiomshshshsk.shopping.service;

import com.github.artsiomshshshsk.shopping.model.user.User;
import com.github.artsiomshshshsk.shopping.util.Util;

import java.util.List;

public record UserService(
        List<User> users
) {

    /**
     * Find user by id
     * @param id user id
     * @return user
     */
    public User findUserById(long id){
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(
                        ()-> new IllegalArgumentException("User with id " + id + " not found")
                );
    }

    /**
     * Find 2 users with max distance between them
     * @return list of 2 users
     */
    public List<User> find2UsersWithMaxDistance() {
        if(users.size() < 2){
            throw new IllegalArgumentException("List of users should contain at least 2 users");
        }

        double maxDistance = Double.MIN_VALUE;
        User user1 = null;
        User user2 = null;

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                User checkUser1 = users.get(i);
                User checkUser2 = users.get(j);
                double distance = Util.distance(checkUser1.getGeolocation(),checkUser2.getGeolocation());
                if (distance > maxDistance) {
                    maxDistance = distance;
                    user1 = checkUser1;
                    user2 = checkUser2;
                }
            }
        }
        return List.of(user1, user2);
    }
}
