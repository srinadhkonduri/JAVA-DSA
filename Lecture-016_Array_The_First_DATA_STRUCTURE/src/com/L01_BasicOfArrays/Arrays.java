package com.L01_BasicOfArrays;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {

//        taking input from the user for 1d Array
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter the elements in the array : ");
        int[] arr = new int[size+1]; // creating an extra space for insertion
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter " + i + " Element ");
            arr[i] = sc.nextInt();
        }
        printArray(arr);
        insert(arr, 1, 34);
        System.out.println();
        printArray(arr);
        delete(arr, 2);
        System.out.println();
        printArray(arr);
        updateArray(arr,2,99);
        printArray(arr);


        System.out.println();

//        CREATING 2D ARRAY
        int[][] my2dArray = new int[3][2];
        for (int i=0;i<my2dArray.length;i++)
        {
            for (int j=0; j < my2dArray[i].length;j++){
                System.out.println("Enter " + "["+ i + "]"+ "[" + j + "]" + " element: ");
                int element = sc.nextInt();
                my2dArray[i][j] = element;
            }
        }
        print2dArray(my2dArray);
        insert2DArray(my2dArray,0,0,45);
        print2dArray(my2dArray);
        delete2Darray(my2dArray,1,1);
        print2dArray(my2dArray);

    }


//    ----------------------------------------------------------
//    traversing the array
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            System.out.print(num + " ");
        }
    }

//    PRINTING 2D ARRAY
    public static void print2dArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
    }
//    -------------------------------------------------------

//    CREATING A METHOD TO UPDATE THE ARRAY
    public static void updateArray(int[] arr, int pos, int ele){
        int size = arr.length;
        if (pos<0 || pos>size-1){
            System.out.println("wrong position");
            return;
        }
        arr[pos] = ele;
    }
//    CREATING A METHOD TO UPDATE THE 2D ARRAY
    public static void update2DArray(int[][] arr, int pos1, int pos2,int element){
        int size1 = arr.length;
        if (pos1<0 || pos1>size1-1){
            System.out.println("wrong position");
            return;
        }
        int size2 = arr[pos1].length;
        if (pos2<0 || pos2 > size2-1){
            System.out.println("wrong position");
            return;
        }
        arr[pos1][pos2] = element;
    }
//    ----------------------------------------------------------

//    INSERTING AN ELEMENT IN THE ARRAY
    public static void insert(int[] arr, int pos, int element){
        int size = arr.length;
        if (pos < 0 || pos > size-1){
            System.out.println("wrong position");
            return;
        }
        // shifting towards the end
        for (int i = size-2; i >= pos; i--) {
            arr[i+1] = arr[i];
        }
        arr[pos] = element;
    }
//    INSERTING INTO 2D ARRAY
    public static void insert2DArray(int[][] arr, int pos1, int pos2, int element){
        insert(arr[pos1],pos2,element);
    }

//    ---------------------------------------------------------------

    // DELETING THE ELEMENT IN THE ARRAY
    public static void delete(int[] arr, int pos){
        for (int i = pos; i <= arr.length-2; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;
    }

//    DELETING THE ELEMENT IN THE 2D ARRAY
    public static void delete2Darray(int[][] arr , int pos1, int pos2){
        delete(arr[pos1],pos2);
    }
}
//-------------------------------------------------------------
