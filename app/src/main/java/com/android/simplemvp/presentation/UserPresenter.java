package com.android.simplemvp.presentation;

import com.android.simplemvp.view.fragment.user.UserView;

public interface UserPresenter {

    void setView(UserView view); //sets the view in presenter
    void saveUser();

}
