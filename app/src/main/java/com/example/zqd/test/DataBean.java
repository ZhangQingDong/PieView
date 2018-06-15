package com.example.zqd.test;

import android.graphics.Color;

/**
 * <p>Title: com.example.zqd.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 *
 * @author zhangqingdong
 * @date 2018/6/15 10:38
 */
public class DataBean {

    private String name;

    private float value;

    private int color;

    private float angle = 0f;

    public DataBean(String name, float value, int color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
