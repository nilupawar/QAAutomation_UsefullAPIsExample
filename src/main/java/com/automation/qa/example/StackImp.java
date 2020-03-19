package com.automation.qa.example;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StackImp<T> {

    private int top;
    private List<T> stackItems = new ArrayList<>();

    public void put(T item) {
        stackItems.add(top, item);
        top++;
    }

    public T pop() {
        if(top==0){
            return null;
        }
        T item = stackItems.get(top-1);
        stackItems.remove(top-1);
        top--;
        return item;
    }

    public T peek() {
        if(top==0){
            return null;
        }
        return stackItems.get(top-1);
    }

    @Test
    public void stackImplementation() {
        StackImp<String> stringStack = new StackImp<>();
        stringStack.put("Nilesh1");
        stringStack.put("Nilesh2");
        stringStack.put("Nilesh3");
        stringStack.put("Nilesh4");

        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        stringStack.put("Nilesh11");
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.peek());
    }
}
