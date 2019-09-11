package com.android.simplemvp.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.simplemvp.repository.dao.UserDao;
import com.android.simplemvp.repository.entity.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase INSTANCE;

    public abstract UserDao getUserDao();

    public static UserDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    UserDatabase.class,
                    "user-details")
                    .build();
        }

        return INSTANCE;

    }
}
