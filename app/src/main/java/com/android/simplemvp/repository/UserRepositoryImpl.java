package com.android.simplemvp.repository;


import android.content.Context;

import com.android.simplemvp.repository.entity.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private UserDatabase userDatabase;

    public UserRepositoryImpl(Context context) {
        userDatabase = UserDatabase.getInstance(context);
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDatabase.getUserDao().getAllUser();
    }

    @Override
    public void saveUser(User user) {
        userDatabase.getUserDao().addUser(user);
    }
}
