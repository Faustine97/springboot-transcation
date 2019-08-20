package com.ucar.train.test.vo;

import java.sql.Timestamp;

public class ConsumingRecord {
    private int userId;
    private String type;
    private float money;
    private Timestamp time;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public ConsumingRecord() {
    }

    public ConsumingRecord(int userId, String type, float money, Timestamp time) {
        this.userId = userId;
        this.type = type;
        this.money = money;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ConsumingRecord{" +
                "userId=" + userId +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", time=" + time +
                '}';
    }
}
