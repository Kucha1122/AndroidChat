package com.example.androidchat.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidchat.Model.User;
import com.example.androidchat.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context _Context;
    private List<User> _Users;

    public UserAdapter(Context _context, List<User> _Users ){
        this._Context = _context;
        this._Users = _Users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(_Context).inflate(R.layout.user_item, parent,false);

        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = _Users.get(position);
        holder.username.setText(user.getUsername());

        if(user.getImageURL().equals("default")) {
            holder.profileImg.setImageResource(R.mipmap.ic_launcher_round);
        } else {
            Glide.with(_Context).load(user.getImageURL()).into(holder.profileImg);
        }
    }

    @Override
    public int getItemCount() {
        return _Users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView profileImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profileImg = itemView.findViewById(R.id.profileImg);
        }
    }


}
