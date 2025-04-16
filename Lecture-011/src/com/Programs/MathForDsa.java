package com.Programs;


public class MathForDsa {
    public static void main(String[] args) {
        decimalToBinary(45,8);
        binaryToDecimal(1010111001,2);
        findEvenOrOdd(44);
        reverse(123456);
        int res = power(2,3);
        System.out.println(res);
        double result = fastExponential(4,3);
        System.out.println(result);
    }
    static void decimalToBinary(int decimalToNum, int base){
        int resNum = 0;
        int power = 0;
        while (decimalToNum > 0){
            int rem = decimalToNum%base;
            decimalToNum /= base;
            resNum += rem * power(10,power);
            power++;
        }
        System.out.println("result is " + resNum);
    }

    static void binaryToDecimal(int number, int base){
        int resNum = 0;
        int power = 0;
        while (number > 0 ){
            int rem = number % 10;
            number /= 10;
            resNum += rem * power(base,power);
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
