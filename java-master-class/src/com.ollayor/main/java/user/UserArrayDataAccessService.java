package com.ollayor.main.java.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO{

//    private static final User[] users;
//
//    static {
//        users = new User[]{
//                new User(UUID.fromString(
//                        "8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
//                        "James"),
//
//                new User(UUID.fromString(
//                        "b10d126a-3608-4980-9f9c-aa179f5cebc3"),
//                        "Jamila"),
//
//                new User(UUID.fromString(
//                        "5e96022e-c378-4c44-a040-4f980de5e14a"),
//                        "Yulia"),
//
//                new User(UUID.fromString(
//                        "8114ba88-1c2f-4328-82e1-0ec6a6c35d77"),
//                        "John"),
//
//        };
//    }

    @Override
    public User[] getUsers(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()){
                scanner.nextLine();
                count++;
            }
            Scanner scanner1 = new Scanner(file);
            User[] user = new User[count];


           for (int i = 0; i < count; i++){
               String line = scanner1.nextLine();
               String[] parts = line.split(", ");
               User user1 = new User(UUID.fromString(parts[0]), parts[1]);
               user[i] = user1;
           }
           return user;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return new User[0];
        }

    }
}