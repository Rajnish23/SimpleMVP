package com.android.simplemvp.view.fragment.home;

import com.android.simplemvp.presentation.HomePresenter;
import com.android.simplemvp.repository.UserRepository;
import com.android.simplemvp.repository.entity.User;

import java.util.List;

public class HomePresenterImpl implements HomePresenter {

    private UserRepository userRepository;
    private HomeView homeView;
    private List<User> userList = null;

    public HomePresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void getAllUser() {
        new Thread(() ->{
            userList = userRepository.getAllUsers();
            if(userList != null){
                homeView.setAdapter(userList);
            }
        }).start();


    }

    @Override
    public void setView(HomeView homeView) {
        this.homeView = homeView;
    }


}
