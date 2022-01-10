package com.example.startrekbalancerinjectors.Models;

import java.util.ArrayList;
import java.util.List;

public class PlasmaStreamResponse {
    private List<Integer> streams;
    private String operativeTime = "0";
    private int speedLight;
    private String message;

    public PlasmaStreamResponse() {
        streams =  new ArrayList<Integer>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSpeedLight() {
        return speedLight;
    }

    public void setSpeedLight(int speedLight) {
        this.speedLight = speedLight;
    }

    public List<Integer> getStreams() {
        return streams;
    }

    public void setStreams(int item) {
        streams.add(item);
    }

    public String getOperativeTime() {
        return operativeTime;
    }

    public void setOperativeTime(String operativeTime) {
        this.operativeTime = operativeTime;
    }
}
