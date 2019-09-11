package com.android.simplemvp.view.fragment.user;

import android.text.TextUtils;

import com.android.simplemvp.presentation.UserPresenter;
import com.android.simplemvp.presentation.ViewNotFoundException;
import com.android.simplemvp.repository.UserRepository;
import com.android.simplemvp.repository.entity.User;

public class UserPresenterImpl implements UserPresenter {

    private UserView userView;
    private UserRepository userRepository;

    public UserPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void setView(UserView view) {
        this.userView = view;
    }

    @Override
    public void saveUser() {
        if(userView != null) {
            if (userView.getName().trim().equalsIgnoreCase("")) {
                userView.showShowError("Name Required");
            } else if (userView.getCity().trim().equalsIgnoreCase("")) {
                userView.showShowError("City Required");
            } else {
                User user = new User();
                user.setName(userView.getName());
                user.setCity(userView.getCity());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        userRepository.saveUser(user);
                    }
                }).start();

                userView.showSuccessMessage();
            }
        }
        else{
            throw new ViewNotFoundException();
        }
    }

}
