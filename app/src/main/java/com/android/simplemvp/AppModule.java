package com.android.simplemvp;

import android.content.Context;

import com.android.simplemvp.presentation.HomePresenter;
import com.android.simplemvp.presentation.UserPresenter;
import com.android.simplemvp.repository.UserRepository;
import com.android.simplemvp.repository.UserRepositoryImpl;
import com.android.simplemvp.view.fragment.home.HomePresenterImpl;
import com.android.simplemvp.view.fragment.user.UserPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context applicationContext;

    public AppModule(Context context) {
        applicationContext = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return applicationContext;
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository(Context context){
        return new UserRepositoryImpl(context);
    }

    @Provides
    public UserPresenter provideUserPresenter(UserRepository userRepository){
        return new UserPresenterImpl(userRepository);
    }

    @Provides
    public HomePresenter provideHomePresenter(UserRepository userRepository){
        return new HomePresenterImpl(userRepository);
    }
}
