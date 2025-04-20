package com.Programs;

import java.util.Arrays;

public class MathsForDsaPart2 {
    public static void main(String[] args) {
        countDigits(3435442);
        countDigitsViaLog(0);
        armStrongNumber(153);
        reverse(121);
        printAllDivisor(36);
        sieveAlgorithm(40);
        GCD(24,36);
        euclideanGcd(24,36);
        int res = efficientEuclideanGcd(24,36);
        System.out.println(res);
        lcm(24,36);
        factorial(5);
        findTrailingZerosInFactorial(50);
    }

    // method for creating the number of digits in the given number
    public static void countDigits(long n){
        if (n == 0){
            System.out.println("numbers are 1");
            return;
        }
        long count = 0;
        while (n > 0){
            n = n/10;
            count++;
        }
        System.out.println("the number of digits are : " + count);
    }

    // counting digits via log
    public static void countDigitsViaLog(int n){
        if (n == 0){
            System.out.println("digits are 1");
            return;
        }

        int count = (int)((Math.log(n)/Math.log(10)+1));
        System.out.println("digits are : " + count);
    }

    // armStrong number
    public static void armStrongNumber(int num){
        int sum = 0;
        int copy = num;
        while (num > 0){
            int rem = num % 10;
            sum = sum + (int)Math.pow(rem,3);
            num /= 10;
        }
        if (sum == copy){
            System.out.println("armstrong");
        }
        else
            System.out.println("not armstrong");
    }

    // reverse
    public static void reverse(int num){
        int rev = 0;
        int copy = num;
        while (num > 0){
            int rem = num % 10;
            rev = rev*10 + rem;
            num /= 10;
        }
        if (rev == copy){
            System.out.println("reverse");
        }
        else
            System.out.println("not reverse");
    }

    // printing all divisors ⭐
    public static void printAllDivisor(int num){
        int counter = 1;
        int sqroot = (int)Math.sqrt(num);
        while (counter <= sqroot){
            if (num % counter == 0){
                System.out.println(counter + " is a divisor of " + num);
                int otherNumber = num/counter;
                if (otherNumber != counter)
                    System.out.println(otherNumber + " is a divisor of" + num);
            }
            counter++;
        }
    }

    // prime or not
    public static boolean isPrime(int n){
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void sieveAlgorithm(int num){
        boolean[] arr = new boolean[num+1];
        Arrays.fill(arr, true);
        int counter = 2;
        while (counter<=num){
            if(arr[counter]){
                for(int factor = counter+counter; factor<=num; factor+=counter){
                    arr[factor] = false;
                }
            }
            counter++;
        }

        for(int i=2;i<=num;i++){
            System.out.println(i +" : "+ arr[i]);
        }
    }

    // finding the root with newton raphson method

    public static double newtonRaphsonAlgo(int num){
        double tol = 0.0001;
        double root;
        double x = num;
        while (true){
            root = 0.5 * (x + (num/x));
            double ans = x - root;
            if (ans < tol){
                break;
            }
            x = root;
        }
        return root;
    }

//    ⭐
    public static void GCD(int num1,int num2){
        int min = Math.min(num1, num2);
        while (min > 0){
            if (num1 % min == 0 && num2 % min == 0){
                System.out.println("GCD is : " + min);
                return;
            }
            min--;
        }
        int max = Math.max(num1, num2);
        System.out.println("GCD is : " + max);
    }

    public static void euclideanGcd(int num1, int num2){
        while (num1!=0 && num2!=0){
            if(num1>num2){
                num1 -=num2;
            }
            else {
                num2 -= num1;
            }
        }
        int res = num1;
        if(num1 == 0){
            res = num2;
        }
        System.out.println("GCD is "+ res);
    }

    // ⭐
    public static int efficientEuclideanGcd(int num1, int num2){
        while (num1!=0 && num2!=0){
            if(num1>num2){
                num1 %=num2;
            }
            else {
                num2 %= num1;
            }
        }
        int res = num1;
        if(num1 == 0){
            res = num2;
        }
//        System.out.println("GCD is "+ res);
        return res;
    }

//    ⭐
    public static void lcm(int num1, int num2){
        int res = (num1*num2)/efficientEuclideanGcd(num1,num2);
        System.out.println("Lcm is :"+ res);
    }

    static void factorial(int num){
        double res = 1;
        while (num>1){
            res *= num;
            num--;
        }
        System.out.println(res);
    }

//    ⭐
    static void findTrailingZerosInFactorial(int num){
        double res = 0;
        for(int i = 5;i<=num;i=i*i){
            res = res + (double) (num / i);
        }
        System.out.println(res);
    }
}
