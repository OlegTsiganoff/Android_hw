package com.example.student.contacts;

import java.util.LinkedList;

/**
 * Created by student on 14.04.2016.
 */
public class PhoneBook {
    LinkedList<Contact> contacts;

    public PhoneBook()
    {
        contacts = new LinkedList<>();
    }

    public void addContact(Contact contact)
    {
        int index = indexOf(contact);
        if(index > -1)
        {
            contacts.get(index).addPhones(contact.getPhones());
        }
        else
        {
            contacts.add(contact);
        }
    }

    int indexOf(Contact contact)
    {
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).name.equals(contact.name) && contacts.get(i).lastName.equals(contact.lastName))
            {
                return i;
            }
        }
        return -1;
    }
}
