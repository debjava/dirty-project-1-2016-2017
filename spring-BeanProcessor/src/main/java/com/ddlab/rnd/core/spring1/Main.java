package com.ddlab.rnd.core.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by PIKU on 11/8/2016.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
        Vehicle v = (Vehicle) ctx.getBean("bmwVehicle");
        System.out.println(v.getName());
        Animal a = (Animal) ctx.getBean("animal");
        System.out.println(a.getName());
    }
}
