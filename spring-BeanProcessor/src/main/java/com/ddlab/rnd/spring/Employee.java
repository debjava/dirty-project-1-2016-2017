package com.ddlab.rnd.spring;

public class Employee {
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init() method called , Emp object is getting initialized ...");
    }

    public void destroy() {
        System.out.println("destroy() method called , Emp object will be destroyed now ...");
    }
}
