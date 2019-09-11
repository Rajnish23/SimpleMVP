package com.android.simplemvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.simplemvp.R;
import com.android.simplemvp.repository.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewholder> {

    private List<User> userList = new ArrayList<>();

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserListViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent,false);
        return new UserListViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewholder holder, int position) {
        User user = userList.get(position);
        holder.nameText.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserListViewholder extends RecyclerView.ViewHolder {
        private TextView nameText;
        public UserListViewholder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name_text);
        }
    }
}
