package com.ex.oleg.tree;

/**
 * Created by User on 18.05.2016.
 */
public class Node<T extends Comparable<T>> {
    Node<T> left;
    Node<T> right;
    T value;

    public Node(T val)
    {
        value = val;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void insertValue(T val)
    {
        int res = value.compareTo(val);
        if(res == 0)
            return;

        if(res > 0)
        {
            if(left == null)
                left = new Node<>(val);
            left.insertValue(val);
        }

        if(res < 0)
        {
            if(right == null)
                right = new Node<>(val);
            right.insertValue(val);
        }
    }

    public void removeSubValue(T val)
    {
        int res = value.compareTo(val);

        if(res > 0 && left != null)
        {
            if(left.getValue().equals(val))
                left = null;
            else
                left.removeSubValue(val);
        }

        if(res < 0 && right != null)
        {
            if(right.getValue().equals(val))
                right = null;
            else
                right.removeSubValue(val);
        }
    }

    public boolean contains(T val)
    {
        int res = value.compareTo(val);
        if(res == 0)
            return true;

        if(res > 0)
        {
            return left != null && left.contains(val);
        }

        if(res < 0) {
            return right != null && right.contains(val);
        }

        return false;
    }
}
