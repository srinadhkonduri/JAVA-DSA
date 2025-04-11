package com.Programs;

public class MyFirstProgram {
    static public void main(String[] args) {
        System.out.println("hi");
        mySecondProgram.main(args);
    }
}

class mySecondProgram{
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
