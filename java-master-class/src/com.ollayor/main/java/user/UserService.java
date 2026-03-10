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

    public ArrayList<User> getAllUser() {
        return userArrayDataAccessService.getUsers(new File("java-master-class/src/com.ollayor/main/java/users.csv"));
    }

    public User getUserById(UUID userId) {
        for (User user : getAllUser()) {
            if (user.getUserId().equals(userId)) {
                return user;

            }

        }
        throw new IllegalStateException("No such User!");
    }

}




