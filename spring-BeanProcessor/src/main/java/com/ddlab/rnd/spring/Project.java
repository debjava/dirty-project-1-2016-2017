package com.ddlab.rnd.spring;

public class Project {
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
        System.out.println("init() method called , Project object is getting initialized ...");
    }

    public void destroy() {
        System.out.println("destroy() method called , Project object will be destroyed now ...");
    }
}
