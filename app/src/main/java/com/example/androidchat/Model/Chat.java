package com.example.androidchat.Model;

import android.widget.ImageView;

public class Chat {

    private String sender;
    private String receiver;
    private String message;
    private ImageView photo;
    private String type;

    public Chat(String sender, String receiver, String message, ImageView photo, String type) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.photo = photo;
        this.type = type;
    }

    public Chat() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
