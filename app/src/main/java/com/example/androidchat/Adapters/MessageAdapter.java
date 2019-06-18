package com.example.androidchat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidchat.MessageActivity;
import com.example.androidchat.Model.Chat;
import com.example.androidchat.Model.User;
import com.example.androidchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;
    public static final int MSG_TYPE_LEFT_PHOTO = 2;
    public static final int MSG_TYPE_RIGHT_PHOTO = 3;

    private Context _Context;
    private List<Chat> _Chat;
    private String imgUrl;

    FirebaseUser _user;

    public MessageAdapter(Context _context, List<Chat> _Chat,String imgUrl ){
        this._Context = _context;
        this._Chat = _Chat;
        this.imgUrl = imgUrl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == MSG_TYPE_RIGHT) {
            View view = LayoutInflater.from(_Context).inflate(R.layout.chat_item_right, parent,false);
            return new MessageAdapter.ViewHolder(view);
        } else if(viewType == MSG_TYPE_LEFT){
            View view = LayoutInflater.from(_Context).inflate(R.layout.chat_item_left, parent,false);
            return new MessageAdapter.ViewHolder(view);
        } else if(viewType == MSG_TYPE_RIGHT_PHOTO){
            View view = LayoutInflater.from(_Context).inflate(R.layout.chat_item_right_photo, parent,false);
            return new MessageAdapter.ViewHolder(view);
        } else {
            View view = LayoutInflater.from(_Context).inflate(R.layout.chat_item_left_photo, parent,false);
            return new MessageAdapter.ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Chat chat = _Chat.get(position);

        holder.show_message.setText(chat.getMessage());

        String fromMessageType = chat.getType();

        if(imgUrl.equals("default")){
            holder.profileImg.setImageResource(R.mipmap.ic_launcher_round);
        } else {
            Glide.with(_Context).load(imgUrl).into(holder.profileImg);
        }
    }

    @Override
    public int getItemCount() {
        return _Chat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView show_message;
        public ImageView profileImg;
        public ImageView messagePicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            show_message = itemView.findViewById(R.id.show_message);
            profileImg = itemView.findViewById(R.id.profileImg);
            messagePicture = itemView.findViewById(R.id.show_photo);
        }
    }

    @Override
    public int getItemViewType(int position) {
        _user = FirebaseAuth.getInstance().getCurrentUser();
        if(_Chat.get(position).getSender().equals(_user.getUid())){
            return MSG_TYPE_RIGHT;
        } else {
            return  MSG_TYPE_LEFT;
        }
    }
}
