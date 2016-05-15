package com.ex.student.people;

/**
 * Created by student on 25.02.2016.
 */
public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String inName, int inAge)
    {
        name = inName;
        age = inAge;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String inName) { name = inName; }
    public void setAge(int inAge) { age = inAge; }

}
