package com.ollayor.main.java.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID userId;
    private String name;

    public User(UUID userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }
}
