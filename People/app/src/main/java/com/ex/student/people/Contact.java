package com.ex.student.people;

/**
 * Created by student on 25.02.2016.
 */
public class Contact {

    private String name;
    private long phoneNumber;

    public Contact(){}

    public Contact(String inName, long inNumber)
    {
        name = inName;
        phoneNumber = inNumber;
    }

    public String getName() { return name; }
    public long getPhoneNumber() { return phoneNumber; }

    public void setName(String inName) { name = inName; }
    public void setPhoneNumber(long inNumber) { phoneNumber = inNumber; }
}
