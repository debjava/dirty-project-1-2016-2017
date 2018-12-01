package com.ddlab.rnd.job;

class Address {
    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "location='" + location + '\'' +
                '}';
    }
}

class Employee implements Cloneable {

    private Address adrs;
    private String name;

    public Employee() {
        super();
    }

    public Employee(Employee emp) {
        this.name = emp.getName();
        Address address = new Address();
        address.setLocation(emp.getAdrs().getLocation());
        this.adrs = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdrs(Address adrs) {
        this.adrs = adrs;
    }

    public Address getAdrs() {
        return adrs;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "adrs=" + adrs +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Test1 {

    public static void main(String[] args) throws Exception {
        Address address = new Address();
        address.setLocation("Bangalore");
        Employee emp = new Employee();
        emp.setName("Deb");
        emp.setAdrs(address);

//        Employee clonedEmp = (Employee) emp.clone();

        Employee clonedEmp = new Employee(emp);

        System.out.println("Cloned Emp ->"+clonedEmp);
        clonedEmp.getAdrs().setLocation("Pune");
        System.out.println("After modification Cloned Emp ->"+clonedEmp);
        System.out.println("After modification Original Emp ->"+emp);

        emp.getAdrs().setLocation("New York");
        System.out.println("Cloned Emp ->"+clonedEmp);
    }
}
