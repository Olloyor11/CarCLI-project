package com.ollayor.main.java.user;

import java.io.File;
import java.util.ArrayList;

public interface UserDAO {
    ArrayList<User> getUsers(File file);
}
