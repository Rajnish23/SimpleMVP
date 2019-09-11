package com.android.simplemvp.presentation;

import com.android.simplemvp.view.fragment.home.HomeView;

import java.util.List;

public interface HomePresenter  {

    void getAllUser();

    void setView(HomeView homeView);
}
