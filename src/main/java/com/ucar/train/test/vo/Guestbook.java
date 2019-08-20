package com.ucar.train.test.vo;

import java.sql.Timestamp;

public class Guestbook {
    private int message_id;
    private String message_title;
    private String message_content;
    private Timestamp message_create_time;
    private Timestamp message_edit_time;
    private int user_id;
    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Timestamp getMessage_create_time() {
        return message_create_time;
    }

    public void setMessage_create_time(Timestamp message_create_time) {
        this.message_create_time = message_create_time;
    }

    public Timestamp getMessage_edit_time() {
        return message_edit_time;
    }

    public void setMessage_edit_time(Timestamp message_edit_time) {
        this.message_edit_time = message_edit_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Guestbook() {
    }

    public Guestbook(String message_title, String message_content, Timestamp message_create_time, Timestamp message_edit_time, int user_id) {
        this.message_title = message_title;
        this.message_content = message_content;
        this.message_create_time = message_create_time;
        this.message_edit_time = message_edit_time;
        this.user_id = user_id;
    }

    public Guestbook(int message_id, String message_title, String message_content, Timestamp message_create_time, Timestamp message_edit_time, int user_id) {
        this.message_id = message_id;
        this.message_title = message_title;
        this.message_content = message_content;
        this.message_create_time = message_create_time;
        this.message_edit_time = message_edit_time;
        this.user_id = user_id;
    }

    public Guestbook(int message_id, String message_title, String message_content, Timestamp message_create_time, Timestamp message_edit_time, int user_id, String group) {
        this.message_id = message_id;
        this.message_title = message_title;
        this.message_content = message_content;
        this.message_create_time = message_create_time;
        this.message_edit_time = message_edit_time;
        this.user_id = user_id;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Guestbook{" +
                "message_id=" + message_id +
                ", message_title='" + message_title + '\'' +
                ", message_content='" + message_content + '\'' +
                ", message_create_time=" + message_create_time +
                ", message_edit_time=" + message_edit_time +
                ", user_id=" + user_id +
                ", group='" + group + '\'' +
                '}';
    }
}