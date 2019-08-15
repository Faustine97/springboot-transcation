package com.ucar.train.test.vo;

import java.sql.Timestamp;

public class SysLog {
    private int user_id;
    private String user_name;
    private String operation;
    private Timestamp start;
    private Timestamp end;
    private Long diff_time;
    private String result;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Long getDiff_time() {
        return diff_time;
    }

    public void setDiff_time(Long diff_time) {
        this.diff_time = diff_time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public SysLog() {
    }

    public SysLog(int user_id, String user_name, String operation, Timestamp start, Timestamp end, Long diff_time, String result) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.operation = operation;
        this.start = start;
        this.end = end;
        this.diff_time = diff_time;
        this.result = result;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", operation='" + operation + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", diff_time=" + diff_time +
                ", result='" + result + '\'' +
                '}';
    }
}
