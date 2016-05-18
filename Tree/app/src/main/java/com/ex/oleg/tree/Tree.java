package com.ex.oleg.tree;

/**
 * Created by User on 18.05.2016.
 */
public class Tree<T extends Comparable<T>> {
   Node<T> root;

    public Tree(){}

    public Tree(T val)
    {
        root = new Node<>(val);
    }

    public void insert(T value)
    {
        if(root == null)
            root = new Node<>(value);
        root.insertValue(value);
    }

    public void remove(T value)
    {
        if(root.getValue().equals(value))
        {
            root = null;
            return;
        }

        root.removeSubValue(value);
    }

    public boolean contains(T value)
    {
        return root.contains(value);
    }


}
