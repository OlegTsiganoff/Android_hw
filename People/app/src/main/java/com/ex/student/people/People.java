package com.ex.student.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by student on 25.02.2016.
 */
public class People
{
    private ArrayList<Person> personArrayList;

    public People()
    {
        personArrayList = new ArrayList<Person>();
    }

    public void addPerson(Person person)
    {
        personArrayList.add(person);
    }

    public  Person getPersonAt(int index)
    {
        return personArrayList.get(index);
    }

    public int getCount()
    {
        return personArrayList.size();
    }

    public void sortByName()
    {
        for (int i = 0; i < personArrayList.size(); i++)
        {
            for (int j = 0; j < personArrayList.size() - i - 1; j++)
            {
                if (personArrayList.get(j).getName().compareTo(personArrayList.get(j + 1).getName()) > 0)
                {
                    Person tmp = personArrayList.get(j);
                    personArrayList.set(j, personArrayList.get(j + 1));
                    personArrayList.set(j + 1, tmp);
                }
            }
        }
    }

    public void sortByAge()
    {
        for (int i = 0; i < personArrayList.size(); i++)
        {
            for (int j = 0; j < personArrayList.size() - i - 1; j++)
            {
                if (personArrayList.get(j).getAge() > personArrayList.get(j + 1).getAge())
                {
                    Person tmp = personArrayList.get(j);
                    personArrayList.set(j, personArrayList.get(j + 1));
                    personArrayList.set(j + 1, tmp);
                }
            }
        }

    }

    public void remove(Person person)
    {
        if(personArrayList == null)
            return;
        personArrayList.remove(person);

    }

    public void remove(int position)
    {
        if(personArrayList == null)
            return;
        personArrayList.remove(position);

    }
}
