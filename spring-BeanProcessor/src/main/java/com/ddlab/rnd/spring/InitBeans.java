package com.ddlab.rnd.spring;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitBeans implements BeanPostProcessor {
 
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("BeforeInitialization : " + beanName);
      if( bean instanceof Employee ) {
         Employee emp = (Employee) bean;
         emp.setId(1);
      }

      if( bean instanceof Project ) {
         Project project = (Project) bean;
         project.setId(1);
      }

      return bean;  // you can return any other object as well
   }

   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("AfterInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

}