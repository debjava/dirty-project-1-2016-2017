package com.ddlab.rnd.obj2json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by PIKU on 11/6/2016.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = new Employee();
        emp.setEmpId(1);
        emp.setFirstName("Deb");
        emp.setLastName("Mishra");
        emp.setDesignation("Technical Architect");
        emp.setProjectName("Complex Processing System");
        emp.setLocation("Bangalore");

        String jsonString = mapper.writeValueAsString(emp);
        System.out.println("Json :::\n"+jsonString);
    }
}
