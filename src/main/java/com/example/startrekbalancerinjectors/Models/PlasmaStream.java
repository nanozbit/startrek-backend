package com.example.startrekbalancerinjectors.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class PlasmaStream {

    private List<Integer> DamageList;
    private int lightSpeed;

    public PlasmaStream(List damageList, int lightSpeed) {
        DamageList = damageList;
        this.lightSpeed = lightSpeed;
    }

    public List<Integer> getDamageList() {
        return DamageList;
    }

    public void setDamageList(List<Integer> damage) {
        DamageList = damage;
    }

    public int getLightSpeed() {
        return lightSpeed;
    }

    public void setLightSpeed(int lightSpeed) {
        this.lightSpeed = lightSpeed;
    }
}
