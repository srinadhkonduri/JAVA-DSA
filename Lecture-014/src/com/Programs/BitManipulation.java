package com.Programs;


public class BitManipulation {
    public static void main(String[] args) {
        EvenOrOdd(23);
        printBits(35);
        boolean res = isSetBit(32,1);
        System.out.println(res);
        int res1 = setIthBit(32,4);
        printBits(res1);
        int res2 = toggleIthBit(32,4);
        printBits(res2);
        int res3 = unSetIthBit(32,5);
        printBits(res3);
        isPowerOfTwo(33);
    }
    // finding a number is even or odd.
    public static void EvenOrOdd(int num){
        if ((num & 1) == 0){
            System.out.println(num + " is even.");
        }
        else {
            System.out.println(num  + " is odd.");
        }
    }

    // print bits of the number Ex : decimal to binary like
    public static void printBits(int num){
        for (int i = 7; i >= 0; i--) {
            System.out.print((num>>i) & 1);
        }
        System.out.println();
    }

    public static boolean isSetBit(int num, int bit){
        int res = num & (1<<bit);
        return (res == 0)?false:true;
    }

    public static int setIthBit(int num, int bit){
        return num | (1 << bit);
    }

    public static int toggleIthBit(int num, int bit){
        return num ^ (1<<bit);
    }

    public static int unSetIthBit(int num, int bit){
        return num & ~(1<<bit);
    }

    public static void isPowerOfTwo(int num){
        if ((num & num-1) == 0){
            System.out.println("num is power of two");
        }
        else {
            System.out.println("number is not power of two");
        }
    }
}

