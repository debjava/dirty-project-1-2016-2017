package com.ddlab.rnd.core.spring1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by PIKU on 11/8/2016.
 */
public class Animal implements BeanFactoryAware {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean Factory :::"+beanFactory);
    }
}
