package com.ollayor.main.java.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO{

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