package com.ollayor.main.java.user;

import java.util.UUID;

public class UserDAO {

    private static final User[] users;

    static {
        users = new User[]{
                new User(UUID.fromString(
                        "8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                        "James"),

                new User(UUID.fromString(
                        "b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                        "Jamila"),

                new User(UUID.fromString(
                        "5e96022e-c378-4c44-a040-4f980de5e14a"),
                        "Yulia"),

                new User(UUID.fromString(
                        "8114ba88-1c2f-4328-82e1-0ec6a6c35d77"),
                        "John"),

        };
    }

    public User[] getUsers() {
        return users;
    }


}