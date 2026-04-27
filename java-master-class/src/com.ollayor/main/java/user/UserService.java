package com.ollayor.main.java.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public List<User> getAllUser() {
        return userArrayDataAccessService.getUsers(new File("java-master-class/src/com.ollayor/main/java/users.csv"));
    }

    public User getUserById(UUID userId) {
        User userById = getAllUser()
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("User not found"));

        return userById;
    }


}




