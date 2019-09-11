package com.android.simplemvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.simplemvp.R;
import com.android.simplemvp.view.fragment.home.HomeFragment;
import com.android.simplemvp.view.fragment.user.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,
                        new HomeFragment())
                .commit();

        findViewById(R.id.add_user_button)
                .setOnClickListener(view -> {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,
                                    new UserFragment())
                            .addToBackStack("add_user")
                            .commit();
                });
    }
}
