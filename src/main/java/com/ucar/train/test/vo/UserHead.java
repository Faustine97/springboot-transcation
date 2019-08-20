package com.ucar.train.test.vo;

public class UserHead {
    private String userName;
    private String url;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserHead() {
    }

    public UserHead(String userName, String url) {
        this.userName = userName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "UserHead{" +
                "userName='" + userName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
