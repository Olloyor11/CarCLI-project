package com.ollayor.main.java.user;

import java.util.UUID;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User[] getAllUser(){
        return userDAO.getUsers();
    }

    public User getUserById(UUID id){
        for (User user : getAllUser()){
            if(user.getId().equals(id)){
                return user;

            }

        }
        return null;
    }



}
