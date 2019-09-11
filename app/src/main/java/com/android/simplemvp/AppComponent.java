package com.android.simplemvp;

import com.android.simplemvp.view.fragment.home.HomeFragment;
import com.android.simplemvp.view.fragment.user.UserFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(UserFragment target);

    void inject(HomeFragment target);
}
