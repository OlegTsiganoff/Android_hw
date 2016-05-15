package com.ex.student.people;

import java.util.ArrayList;

/**
 * Created by student on 25.02.2016.
 */
public class PhoneBook {

    private ArrayList<Contact> contacts;

    public PhoneBook() { contacts = new ArrayList<Contact>(); }

    public void addContact(Contact contact)
    {
        contacts.add(contact);
    }

    public  Contact getContactAt(int index)
    {
        return contacts.get(index);
    }

    public int getCount()
    {
        return contacts.size();
    }

    public void sortByName()
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            for (int j = 0; j < contacts.size() - i - 1; j++)
            {
                if (contacts.get(j).getName().compareTo(contacts.get(j + 1).getName()) > 0)
                {
                    Contact tmp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, tmp);
                }
            }
        }
    }

    public void sortByPhoneNumber()
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            for (int j = 0; j < contacts.size() - i - 1; j++)
            {
                if (contacts.get(j).getPhoneNumber() > contacts.get(j + 1).getPhoneNumber())
                {
                    Contact tmp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, tmp);
                }
            }
        }

    }

    public void remove(Contact contact)
    {
        if(contacts == null)
            return;
        contacts.remove(contact);

    }

    public void remove(int position)
    {
        if(contacts == null)
            return;
        contacts.remove(position);

    }

}
