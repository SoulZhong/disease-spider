/**
 * Lagou.com Llc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.soullleo.medic.spider;

import java.util.List;

import com.google.gson.Gson;

/**
 * @Description: TODO(这里描述这个类的作用) 
 * @Author soul
 * @Date Oct 20, 2014 1:49:20 PM 
 */
public class Disease {

    private static Gson gson = new Gson();
    private String part;
    private String name;
    private String desc;
    private List<String> symptoms;

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

}
