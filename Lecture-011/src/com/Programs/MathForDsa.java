package com.Programs;

import java.util.Scanner;

public class MathForDsa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  decimal number : ");
        int decimal = sc.nextInt();
        System.out.println("Enter the base value : ");
        int base = sc.nextInt();
        decimalToBinary(decimal,base);
        binaryToDecimal(1111,2);
        findEvenOrOdd(44);
        reverse(123456);
        int res = power(2,2);
        System.out.println("power is "+ res);
        double result = fastExponential(8,3);
        System.out.println("fast exponential is : " + result);
    }
    static void decimalToBinary(int decimalToNum, int base){
        int resNum = 0;
        int power = 0;
        while (decimalToNum > 0){
            int rem = decimalToNum%base;
            decimalToNum = decimalToNum / base;
            resNum = resNum + rem * power(10,power);
            power++;
        }
        System.out.println("result is " + resNum);
    }

    static void binaryToDecimal(int number, int base){
        int resNum = 0;
        int power = 0;
        while (number > 0){
            int rem = number % 10;
            number /= 10;
            resNum = resNum + rem * power(base,power);
            power++;
        }
        System.out.println("result is " + resNum);
    }

    static void findEvenOrOdd(int num){
        if (num % 2 == 0){
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }

    static void reverse(int num){
        int rev = 0;
        while (num != 0){
            int rem = num % 10;
            rev = rev*10 + rem;
            num /= 10;
        }
        System.out.println("reversed num : " + rev);
    }

    static int power(int base, int exp){
        int res = 1;
        for (int i = 0; i < exp; i++) {
            res = res * base;
        }
        return res;
    }

    static double fastExponential(int base, int exp){
    double res = 1;
    while (exp > 0){
        if (exp %2 != 0){
            res = res * base;
        }
        exp = exp / 2;
        base = base * base;
    }
    return res;
    }
}
