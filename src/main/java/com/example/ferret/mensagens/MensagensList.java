package com.example.ferret.mensagens;

public class MensagensList {

    private final String profilePic;
    private String name, mobile, lastMessage;
    private int unseenMessages;

    public MensagensList(String name, String mobile, String lastMessage, String profilePic ,int unseenMessages) {
        this.name = name;
        this.mobile = mobile;
        this.lastMessage = lastMessage;
        this.profilePic = profilePic;
        this.unseenMessages = unseenMessages;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {

        return mobile;
    }

    public String getLastMessage() {

        return lastMessage;
    }

    public String getProfilePic(){

        return profilePic;

    }

    public int getUnseenMessages() {

        return unseenMessages;
    }
}

