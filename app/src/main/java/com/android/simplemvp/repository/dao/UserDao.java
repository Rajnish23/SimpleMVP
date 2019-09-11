package com.android.simplemvp.repository.dao;

import androidx.room.Insert;
import androidx.room.Query;

import com.android.simplemvp.repository.entity.User;

import java.util.List;

@androidx.room.Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM USER")
    List<User> getAllUser();

}
