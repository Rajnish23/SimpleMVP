package com.android.simplemvp;

import com.android.simplemvp.view.fragment.user.UserFragment;

public interface AppComponent {

    void inject(UserFragment target);
}
