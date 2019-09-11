package com.android.simplemvp;

import android.text.TextUtils;

import com.android.simplemvp.presentation.HomePresenter;
import com.android.simplemvp.presentation.UserPresenter;
import com.android.simplemvp.presentation.ViewNotFoundException;
import com.android.simplemvp.repository.UserRepository;
import com.android.simplemvp.repository.entity.User;
import com.android.simplemvp.view.fragment.home.HomePresenterImpl;
import com.android.simplemvp.view.fragment.home.HomeView;
import com.android.simplemvp.view.fragment.user.UserPresenterImpl;
import com.android.simplemvp.view.fragment.user.UserView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterTest {

    private UserRepository mockUserRepository;
    private UserView mockUserView;
    private UserPresenter presenter;
    private HomeView mockHomeView;
    private HomePresenter mockHomePresenter;
    private User user;
    private List<User> userList = new ArrayList<>();

    @Before
    public void setup(){

        mockUserRepository = mock(UserRepository.class);

        user = new User();
        user.setId(1L);
        user.setName("Demo");
        user.setCity("Dasman");
        userList.add(user);

        when(mockUserRepository.getUser(anyInt())).thenReturn(user);

        mockUserView = mock(UserView.class);

        mockHomeView = mock(HomeView.class);

        presenter = new UserPresenterImpl(mockUserRepository);
        mockHomePresenter = new HomePresenterImpl(mockUserRepository);

        mockHomePresenter.setView(mockHomeView);

        presenter.setView(mockUserView);
    }

    @Test
    public void interactionWithHomeScreen(){
        mockHomePresenter.getAllUser();

    }


    @Test
    public void interactionWithSaveUserButton(){

        when(mockUserView.getName()).thenReturn("");
        when(mockUserView.getCity()).thenReturn("");
        presenter.saveUser();
        verify(mockUserView, times(1)).showShowError("Name Required");

        when(mockUserView.getName()).thenReturn("Demo");
        when(mockUserView.getCity()).thenReturn("");
        presenter.saveUser();
        verify(mockUserView, times(1)).showShowError("City Required");

        when(mockUserView.getName()).thenReturn("Demo");
        when(mockUserView.getCity()).thenReturn("DemoCity");
        presenter.saveUser();

        verify(mockUserView, times(1)).showSuccessMessage();
    }

    @Test(expected = ViewNotFoundException.class)
    public void throwNullPointerExceptionOnNullView(){
        presenter.setView(null);

        presenter.saveUser();
    }

}
