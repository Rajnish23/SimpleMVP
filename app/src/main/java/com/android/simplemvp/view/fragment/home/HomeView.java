package com.android.simplemvp.view.fragment.home;

import com.android.simplemvp.repository.entity.User;

import java.util.List;

public interface HomeView {

    void setAdapter(List<User> users);
}
