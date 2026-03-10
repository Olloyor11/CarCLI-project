package com.ollayor.main.java.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO{

    @Override
    public ArrayList<User> getUsers(File file) {
        try {
            ArrayList<User> user = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                User user1 = new User(UUID.fromString(parts[0]), parts[1]);
                user.add(user1);
            }
           return user;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

    }






}