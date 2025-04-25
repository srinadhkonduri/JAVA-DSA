package com.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2,5,7,9,11,13,15,17};
        binary_Search(array,15);
        int[] array1 = {23,22,20,18,16,13,11};
        binary_Search_Desc(array1,18);
        orderAgnosticBinarySearch(array,9);
        orderAgnosticBinarySearch(array1,22);
    }

    // NORMAL BINARY SEARCH INCREASING ORDER SORTED ARRAY
    /**
     * This method performs Binary Search on a sorted 1D array to find the index of a given target element.
     * If the target is found, its index is printed. Otherwise, a "not found" message is printed.
     *
     * @param arr A sorted array of integers (in ascending order).
     * @param target The value to be searched for in the array.
     *
     * 💡 NOTE: Binary Search only works correctly on a **sorted** array.
     *
     * 🧠 Steps:
     * 1. Initialize `start` to 0 and `end` to the last index of the array.
     * 2. Repeat while `start` is less than or equal to `end`:
     *      - Calculate the middle index `mid` = start + (end - start) / 2.
     *      - If arr[mid] == target, store the index in `ans` and exit the loop.
     *      - If target is greater, search the right half (start = mid + 1).
     *      - If target is smaller, search the left half (end = mid - 1).
     * 3. If `ans` remains -1, the element is not present in the array.
     * 4. Print the result.
     */
    public static void binary_Search(int[] arr, int target) {

        // Step 1: Initialize answer as -1 to indicate "not found" by default
        int ans = -1;

        // Step 2: Define the search space from index 0 to array length - 1
        int start = 0;
        int end = arr.length - 1;

        // Step 3: Repeat the loop while search space is valid
        while (start <= end) {

            // Step 4: Calculate the mid-index to avoid integer overflow
            int mid = start + (end - start) / 2;

            // Step 5: Check if the middle element is the target
            if (arr[mid] == target) {
                ans = mid; // Store the index where target is found
                break;     // Exit the loop since we found the target
            }

            // Step 6: If target is greater than mid-element, search right half
            else if (arr[mid] < target) {
                start = mid + 1;
            }

            // Step 7: If target is smaller than mid-element, search left half
            else {
                end = mid - 1;
            }
        }

        // Step 8: After loop, check if target was found and print result
        if (ans == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("The target " + target + " found at index : " + ans);
        }
    }


    // DECREASING ORDER BINARY SEARCH
    /**
     * Performs Binary Search on a **descending sorted array** to find the target element.
     *
     * @param arr    A sorted array in descending order (e.g., [20, 15, 10, 5, 1]).
     * @param target The element we want to search for in the array.
     *
     * ❗Important: This version is only for arrays sorted in **descending order**.
     *
     * Steps:
     * 1. Initialize the search range with `start` and `end`.
     * 2. Calculate mid-index.
     * 3. Check if mid is the target.
     *    - If yes, store index and exit loop.
     *    - If target is greater, search the **left half** (end = mid - 1).
     *    - If target is smaller, search the **right half** (start = mid + 1).
     * 4. Print result based on whether target is found.
     */
    public static void binary_Search_Desc(int[] arr, int target) {

        // Step 1: Initialize answer as -1 to track if element is found
        int ans = -1;

        // Define the initial search space from 0 to array length - 1
        int start = 0;
        int end = arr.length - 1;

        // Step 2: Continue loop until the search space is valid
        while (start <= end) {

            // Step 3: Compute the middle index to avoid overflow
            int mid = start + (end - start) / 2;

            // Step 4: Check if the middle element is the target
            if (arr[mid] == target) {
                ans = mid;  // Target found at mid
                break;      // Exit the loop
            }

            // Step 5: Since array is in descending order,
            // if target is greater than arr[mid], search left side
            else if (arr[mid] < target) {
                end = mid - 1;
            }

            // Step 6: If target is smaller than arr[mid], search right side
            else {
                start = mid + 1;
            }
        }

        // Step 7: After the loop, check if we found the target and print result
        if (ans == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("The target " + target + " found at index : " + ans);
        }
    }


    // CREATING A METHOD FOR ORDER AGNOSTIC BINARY SEARCH

    /**
     * Performs Binary Search on a sorted array **without knowing whether it's ascending or descending**.

     * This is called an "Order-Agnostic Binary Search" because it works regardless of the array’s order.
     * It determines the sorting order by checking the first and last elements.
     *
     * @param arr    The input array which is sorted (in either ascending or descending order).
     * @param target The value to search for in the array.
     */
    public static void orderAgnosticBinarySearch(int[] arr, int target) {

        // Step 1: Define initial search space
        int start = 0;
        int end = arr.length - 1;

        // Step 2: Check the order of the array by comparing first and last elements
        // If the first element is less than or equal to the last, it’s sorted in ascending order
        if (arr[start] <= arr[end]) {
            // Step 3a: Call the binary search method for ascending order
            binary_Search(arr, target);
        }
        else {
            // Step 3b: Call the binary search method for descending order
            binary_Search_Desc(arr, target);
        }
    }
}
