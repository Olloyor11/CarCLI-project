package com.ollayor.main.java.user;

import java.io.File;
import java.util.List;

public interface UserDAO {
    List<User> getUsers(File file);
}
