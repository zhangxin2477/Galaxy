package com.galaxy.demon.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String school_name;

    public User(){
        super();
    }

    public User(String name,int age,String school_name){
        super();
        this.name=name;
        this.age=age;
        this.school_name=school_name;
    }

    public User(int id,String name,int age,String school_name){
        super();
        this.id=id;
        this.name=name;
        this.age=age;
        this.school_name=school_name;
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

    @Override
    public String toString(){
        return "id:"+id+",name:"+name+",age:"+age+",school:"+school_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
}
