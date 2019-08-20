package com.ucar.train.test.vo;

public class Account {
    private  int userId;
    private  float money;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Account() {
    }

    public Account(int userId, float money) {
        this.userId = userId;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", money=" + money +
                '}';
    }
}
