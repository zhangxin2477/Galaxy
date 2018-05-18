package com.zhangxin.demon.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private int org_id;
    private String name;
    private int age;

    public User() {
        super();
    }

    public User(int org_id, String name, int age) {
        super();
        this.org_id = org_id;
        this.name = name;
        this.age = age;
    }

    public User(int id, int org_id, String name, int age) {
        super();
        this.id = id;
        this.org_id = org_id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        String str= "";
        try {
            str = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
