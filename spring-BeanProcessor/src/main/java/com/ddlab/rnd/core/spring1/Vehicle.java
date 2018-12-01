package com.ddlab.rnd.core.spring1;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by PIKU on 11/8/2016.
 */
public class Vehicle implements BeanNameAware {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeanName(String beanName) {
        System.out.println("Bean Name : "+beanName);
    }
}
