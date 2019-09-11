package com.android.simplemvp.view.fragment.home;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.simplemvp.MvpApplication;
import com.android.simplemvp.R;
import com.android.simplemvp.adapter.UserListAdapter;
import com.android.simplemvp.presentation.HomePresenter;
import com.android.simplemvp.repository.UserRepositoryImpl;
import com.android.simplemvp.repository.entity.User;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeView {

    private static final String TAG = "HomeFragment";

    private RecyclerView recyclerView;

    @Inject
    HomePresenter homePresenter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MvpApplication)getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.user_recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        homePresenter.setView(this);
        homePresenter.getAllUser();

    }

    @Override
    public void setAdapter(List<User> users) {
        UserListAdapter adapter = new UserListAdapter();
        adapter.setUserList(users);
        recyclerView.setAdapter(adapter);
    }
}
