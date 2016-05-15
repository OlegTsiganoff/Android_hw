package com.example.student.contacts;

import android.os.Environment;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by student on 14.04.2016.
 */
public class Contact {
    String name;
    String lastName;
    HashSet<String> phones;

    public Contact(){ phones = new HashSet<>(); }

    public Contact(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        phones = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addPhone(String phone)
    {
        phones.add(phone);
    }

    public void addPhones(Collection<String> phones)
    {
        this.phones.addAll(phones);
    }

    public String getPhonesAsString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phones.size(); i++) {
            if(i > 0)
                sb.append("\n");
            sb.append(phones.toArray()[i]);
        }
        return sb.toString();
    }

    public Collection<String> getPhones()
    {
        return phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!name.equals(contact.name)) return false;
        if (!lastName.equals(contact.lastName)) return false;
        return phones.equals(contact.phones);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + phones.hashCode();
        return result;
    }
}
