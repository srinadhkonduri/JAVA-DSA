package com.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {2,3,6,4,8,7,4,4};
//        linearSearch(array,4,false); // finding first occurrence
//        linearSearch(array,4,true); // finding last occurrence
//        linearSearchMultiple(array,4);
//        findMax(array);

        int[][] arr = {
                {2,5,7,9}, // 23
                {3,4,5,2}, // 14
                {8,5,6,3}, // 22
                {5,0,4,6}  // 15
        };
//        linearSearch2D(arr,5,true);
//        multipleLinearSearch2D(arr,5);
        maxSumSubArrayIn2DArray(arr);
    }

    // -----------------------------------------------------------

    public static void linearSearch(int[] arr, int target, boolean findLast){
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                ans = i;
                if (findLast == false){
                    break;
                }
            }
        }
        if (ans == -1){
            System.out.println("element is not present in the index");
        }
        else {
            System.out.println("element found at the index : " + ans);
        }
    }


    // creating a method to find all occurrences of the elements
    public static void linearSearchMultiple(int[] arr, int target){
        int[] ans = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                ans[k] = i;
                k++;
            }
        }
        if (k == 0){
            System.out.println("element not found");
        } else {
            for (int i = 0; i < k; i++) {
                System.out.println("element found at : " + ans[i]);
            }
        }
    }

    // CREATING A METHOD TO FIND THE MAX ELEMENT IN THE GIVEN ARRAY
    public static void findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("maximum element is : " + max);
        System.out.println("minimum element is : " + min);
    }


//    ----------------------------
    // CREATING A METHOD TO SEARCH IN 2D ARRAY
    public static void linearSearch2D(int[][] arr, int target, boolean findLast){
        int outerIndex = -1;
        int innerIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target){
                    outerIndex = i;
                    innerIndex = j;
                    if (findLast == false){
                        found = true;
                        break;
                    }
                }
            }
            if (found == true){
                break;
            }
        }
        if (outerIndex == -1){
            System.out.println("not found");
        }
        else {
            System.out.println("found at : " + outerIndex + "," + innerIndex);
        }
    }

    // CREATING A METHOD TO FIND MULTIPLE OCCURRENCES IN THE 2D ARRAY
    public static void multipleLinearSearch2D(int[][] arr, int target){
        // Calculate total size for result storage
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            size += arr[i].length;
        }

        // Array to store positions of all occurrences
        int[][] ans = new int[size][2];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) { // Fix: arr[i].length for jagged array
                if (arr[i][j] == target) {
                    ans[k][0] = i;
                    ans[k][1] = j;
                    k++;
                }
            }
        }

        // Output result
        if (k == 0) {
            System.out.println("not found");
        } else {
            for (int i = 0; i < k; i++) {
                System.out.println("found at: " + ans[i][0] + "," + ans[i][1]);
            }
        }
    }

    // CREATING A METHOD TO FIND THE MAX NUMBER IN THE 2D ARRAY
    public static void maxSumSubArrayIn2DArray(int[][] arr){
        int max = Integer.MIN_VALUE;
        int resIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum = sum+arr[i][j];
            }
            if (sum > max){
                max = sum;
                resIndex = i;
            }
        }
        System.out.println("maximum sum sub array is : " + max + ", " + resIndex);
    }
}
