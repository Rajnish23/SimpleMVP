package com.android.simplemvp.repository;


import com.android.simplemvp.repository.entity.User;

import java.util.List;

public interface UserRepository {

    User getUser(int id);

    List<User> getAllUsers();

    void saveUser(User user);

}
