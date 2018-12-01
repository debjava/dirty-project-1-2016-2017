package com.ddlab.rnd.core1;

import java.util.PriorityQueue;

class Emp {
    private String name;
    private int age;

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Emp> pq = new PriorityQueue<>();
        pq.add( new Emp("Deb",23));
        pq.add( new Emp("John",24));
//        pq.add( new Emp("Vidya",25));

//        System.out.println(pq);
    }
}
