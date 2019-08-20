package com.ucar.train.test.vo;

public class Role {
    private String ROLE_NAME;
    private String ROLE_INFO;

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getROLE_INFO() {
        return ROLE_INFO;
    }

    public void setROLE_INFO(String ROLE_INFO) {
        this.ROLE_INFO = ROLE_INFO;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ROLE_NAME='" + ROLE_NAME + '\'' +
                ", ROLE_INFO='" + ROLE_INFO + '\'' +
                '}';
    }
}
