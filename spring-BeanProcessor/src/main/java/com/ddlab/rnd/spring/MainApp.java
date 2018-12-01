package com.ddlab.rnd.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {

      AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

      Employee obj = (Employee) context.getBean("emp");
      System.out.println(obj.getName());
      System.out.println(obj.getId());
      context.registerShutdownHook();
   }
}