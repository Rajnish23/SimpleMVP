package com.android.simplemvp.view.fragment.user;

public interface UserView {

    String getName();

    String getCity();

    void showShowError(String message);

    void showSuccessMessage();
}
