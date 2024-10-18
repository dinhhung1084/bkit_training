package Serialization;

import java.io.Serializable;

class Address {
    String city, state, country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID=1L;
    transient int id;
    String name;
    static String company="SSS IT Pvt Ltd";//it won't be serialized
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Student2 implements java.io.Serializable {
    int id;
    String name;
    Address address;

    public Student2(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

