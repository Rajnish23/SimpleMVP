package com.android.simplemvp.view.fragment.user;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.simplemvp.MvpApplication;
import com.android.simplemvp.R;
import com.android.simplemvp.presentation.UserPresenter;
import com.android.simplemvp.repository.UserRepositoryImpl;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment implements UserView {

    private TextInputEditText nameEditText, cityEditText;
    private Button submitButton;
    @Inject
    UserPresenter userPresenter;


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MvpApplication)getActivity().getApplication()).getAppComponent().inject(this);    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        nameEditText = view.findViewById(R.id.name_edit_text);
        cityEditText = view.findViewById(R.id.city_edit_text);
        submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v -> {
                    userPresenter.saveUser();
                });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        userPresenter.setView(this);
    }

    @Override
    public String getName() {
        return nameEditText.getText().toString();
    }

    @Override
    public String getCity() {
        return cityEditText.getText().toString();
    }

    @Override
    public void showShowError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(getActivity(), "User Saved!", Toast.LENGTH_SHORT).show();
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        supportFragmentManager.popBackStack();

    }
}
