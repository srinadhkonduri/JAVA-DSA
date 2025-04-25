package com.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {2,3,6,4,8,7,4,4};
        linearSearch(array,4,false); // finding first occurrence
        linearSearch(array,4,true); // finding last occurrence
        linearSearchMultiple(array,4);
        findMaxAndMin(array);

        int[][] arr = {
                {2,5,7,9}, // 23
                {3,4,5,2}, // 14
                {8,5,6,3}, // 22
                {5,-1,4,6}  // 15
        };
        linearSearch2D(arr,5,true);
        multipleLinearSearch2D(arr,5);
        maxSumSubArrayIn2DArray(arr);
        findMaxAndMinElement(arr);
    }

    // -----------------------------------------------------------
    // CREATING A METHOD TO SEARCH ELEMENTS IN THE ARRAY

    /**
     * This method performs a linear search on the given integer array to find either
     * the first or the last occurrence of a specified target element.
     *
     * @param arr       The input array to search within.
     * @param target    The value to search for in the array.
     * @param findLast  A boolean flag that determines whether to find:
     *                  - the first occurrence (if false)
     *                  - the last occurrence (if true)

     * Logic:
     * - Initialize `ans` to -1, which represents "not found".
     * - Loop through the array from start to end:
     *     - If the current element matches the target:
     *         - Assign its index to `ans`.
     *         - If `findLast` is false (i.e., we want the first occurrence), break the loop.
     *         - If `findLast` is true, continue scanning to potentially update `ans` with a later index.
     * - After the loop ends:
     *     - If `ans` is still -1, it means the target was not found, so print a message indicating that.
     *     - Otherwise, print the index where the target was found (first or last, depending on the flag).
     */
    public static void linearSearch(int[] arr, int target, boolean findLast) {
        int ans = -1; // Initially assume the element is not found
        for (int i = 0; i < arr.length; i++) { // Traverse through the array
            if (arr[i] == target) { // Check if current element matches the target
                ans = i; // Store the index where target is found
                if (!findLast) { // If we only want the first occurrence
                    break; // Exit the loop early
                }
                // Else, continue to find the last occurrence
            }
        }

        // After traversing, check if the element was found
        if (ans == -1) {
            System.out.println("element is not present in the index");
        } else {
            System.out.println("element found at the index : " + ans);
        }
    }


    // creating a method to find all occurrences of the elements
    /**
     * This method performs a linear search on an integer array to find all occurrences of a target element.
     * If the target is found in the array, it prints all the indices where the target appears.
     * If the target is not found, it prints "element not found".
     *
     * @param arr    The array to search in.
     * @param target The value to search for.
     * Logic:
     * - Create a result array `ans` to store indices where the target is found.
     * - Use a counter `k` to track the number of matches.
     * - Loop through the input array and check if each element equals the target.
     * - If a match is found, store the index in `ans[k]` and increment `k`.
     * - After the loop, check:
     *    - If `k == 0`, print "element not found".
     *    - Otherwise, print all stored indices where the target was found.
     */
    public static void linearSearchMultiple(int[] arr, int target) {
        int[] ans = new int[arr.length]; // Array to store indices of found elements
        int k = 0; // Counter for number of matches
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                ans[k] = i; // Store index of match
                k++;
            }
        }
        if (k == 0) {
            System.out.println("element not found");
        } else {
            for (int i = 0; i < k; i++) {
                System.out.println("element found at : " + ans[i]);
            }
        }
    }

    // CREATING A METHOD TO FIND THE MAX ELEMENT IN THE GIVEN ARRAY
    /**
     * This method finds the maximum and minimum elements in an integer array.
     *
     * @param arr The input array of integers.

     * Logic:
     * - Initialize `max` to the smallest possible integer value (`Integer.MIN_VALUE`)
     *   so that any element in the array will be larger.
     * - Initialize `min` to the largest possible integer value (`Integer.MAX_VALUE`)
     *   so that any element in the array will be smaller.
     * - Traverse the array:
     *     - If the current element is greater than `max`, update `max`.
     *     - If the current element is less than `min`, update `min`.
     * - After the loop ends, print the values of `max` and `min`, which now hold
     *   the maximum and minimum values from the array respectively.
     */
    public static void findMaxAndMin(int[] arr) {
        int max = Integer.MIN_VALUE; // Initialize to smallest integer value
        int min = Integer.MAX_VALUE; // Initialize to largest integer value

        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            if (j > max) {
                max = j; // Update max if current element is greater
            }
            if (j < min) {
                min = j; // Update min if current element is smaller
            }
        }

        System.out.println("maximum element is : " + max);
        System.out.println("minimum element is : " + min);
    }



    //    ----------------------------
    // CREATING A METHOD TO SEARCH IN 2D ARRAY
    /**
     * This method performs a linear search on a 2D integer array (matrix) to find a target value.
     * It can either find the first occurrence or the last occurrence of the target, based on the `findLast` flag.
     *
     * @param arr       The 2D array (matrix) in which the search is to be performed.
     * @param target    The target integer value to search for in the matrix.
     * @param findLast  A boolean flag that controls the behavior of the search:
     *                  - If false: the method finds the **first occurrence** of the target and stops.
     *                  - If true: the method continues searching to find the **last occurrence** of the target.
     *
     * Logic:
     * - Initialize `outerIndex` and `innerIndex` to -1 to represent "not found".
     * - Traverse the matrix using two nested loops:
     *     - Outer loop (`i`) iterates through rows.
     *     - Inner loop (`j`) iterates through columns of each row.
     *     - If the element at position `[i][j]` matches the target:
     *         - Store the current indices (`i`, `j`) in `outerIndex` and `innerIndex`.
     *         - If `findLast` is false (looking for first occurrence), set `found = true` and break out of the inner loop.
     * - If the `found` flag is set to true, break out of the outer loop as well.
     * - After traversing:
     *     - If `outerIndex` is still -1, the element was not found, print "not found".
     *     - Otherwise, print the coordinates where the element was found.
     */
    public static void linearSearch2D(int[][] arr, int target, boolean findLast) {
        int outerIndex = -1; // To store row index of found element
        int innerIndex = -1; // To store column index of found element

        for (int i = 0; i < arr.length; i++) { // Traverse each row
            boolean found = false; // Track if first occurrence is found
            for (int j = 0; j < arr[0].length; j++) { // Traverse each column
                if (arr[i][j] == target) {
                    outerIndex = i;
                    innerIndex = j;
                    if (!findLast) { // If only the first occurrence is needed
                        found = true;
                        break; // Break inner loop
                    }
                    // If looking for last occurrence, keep updating the indices
                }
            }
            if (found) { // If first occurrence is found, break outer loop
                break;
            }
        }

        if (outerIndex == -1) {
            System.out.println("not found");
        } else {
            System.out.println("found at : " + outerIndex + "," + innerIndex);
        }
    }


    // CREATING A METHOD TO FIND MULTIPLE OCCURRENCES IN THE 2D ARRAY
    /**
     * This method performs a **linear search in a 2D array** (matrix) to find **all occurrences** of a target value.
     * It prints all the positions (row, column) where the target is found.
     * Works correctly even for **jagged arrays** (i.e., rows with different lengths).
     *
     * @param arr    The 2D integer array in which to search for the target.
     * @param target The integer value to search for in the 2D array.
     *
     * Logic Overview:
     * 1. Calculate total number of elements across all rows to allocate enough space for results.
     * 2. Create a result array `ans[][]` to store the positions (row, col) where target is found.
     * 3. Traverse each element of the 2D array using nested loops.
     *    - If an element matches the target, store its row and column index in `ans[k]`.
     *    - Increment `k` to move to the next slot for result.
     * 4. After the loop:
     *    - If `k == 0`, no match was found → print "not found".
     *    - Otherwise, loop over results and print each matched position as "found at: row,col".
     */
    public static void multipleLinearSearch2D(int[][] arr, int target) {
        // Step 1: Calculate the total number of elements in the 2D array
        //         This ensures we allocate enough space in result array (for worst-case where all elements match)
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            size += arr[i].length; // Sum of lengths of all rows (handles jagged arrays too)
        }

        // Step 2: Create a result array to store matching positions (each as row-col pair)
        //         Each match is stored as [row][column]
        int[][] ans = new int[size][2]; // Initialize large enough array
        int k = 0; // Counter for how many matches found

        // Step 3: Traverse the 2D array using nested loops
        for (int i = 0; i < arr.length; i++) { // Outer loop → rows
            for (int j = 0; j < arr[i].length; j++) { // Inner loop → columns (use arr[i].length for jagged arrays)
                if (arr[i][j] == target) { // Check if current element matches the target
                    ans[k][0] = i; // Store row index of match
                    ans[k][1] = j; // Store column index of match
                    k++; // Move to next result slot
                }
            }
        }

        // Step 4: Output the result
        if (k == 0) {
            // If no matches found, inform the user
            System.out.println("not found");
        } else {
            // Otherwise, print all the positions where the target was found
            for (int i = 0; i < k; i++) {
                System.out.println("found at: " + ans[i][0] + "," + ans[i][1]);
            }
        }
    }


    // CREATING A METHOD TO FIND THE MAX NUMBER IN THE 2D ARRAY
    /**
     * This method finds the row (1D sub-array) in a 2D integer array (matrix)
     * that has the **maximum sum** of its elements and prints that maximum sum
     * along with the index of that row.
     *
     * @param arr The input 2D integer array (matrix).
     *
     * 💡 Goal:
     * Find the row (sub-array) with the highest total sum of its elements.
     *
     * 🔍 Logic Overview:
     * 1. Initialize `max` with the smallest possible integer value (Integer.MIN_VALUE).
     *    - This is used to track the highest row sum found so far.
     * 2. Initialize `resIndex` to -1.
     *    - This stores the index (row number) of the row with the maximum sum.
     * 3. Traverse each row in the 2D array:
     *    - For each row, calculate the sum of its elements.
     *    - If the current row's sum is greater than the `max` so far:
     *         - Update `max` with this sum.
     *         - Update `resIndex` with the current row index.
     * 4. After processing all rows, print the maximum sum and the row index where it occurs.
     */
    public static void maxSumSubArrayIn2DArray(int[][] arr) {
        int max = Integer.MIN_VALUE; // Step 1: To track maximum sum found so far
        int resIndex = -1; // Step 2: To track row index where max sum is found

        // Step 3: Traverse each row
        for (int i = 0; i < arr.length; i++) {
            int sum = 0; // Reset sum for current row

            // Loop through each element of the current row
            for (int j = 0; j < arr[0].length; j++) {
                sum = sum + arr[i][j]; // Add each element to sum
            }

            // Check if current row's sum is greater than max so far
            if (sum > max) {
                max = sum; // Update max
                resIndex = i; // Update index of row with max sum
            }
        }

        // Step 4: Output the result
        System.out.println("maximum sum sub array is : " + max + ", " + resIndex);
        // Output format: max sum value and corresponding row index
    }
    // CREATING A METHOD TO FIND THE MAX ELEMENT IN THE 2D ARRAY
    /**
     * This method finds and prints the maximum and minimum elements
     * from a given 2D array (matrix).
     *
     * @param arr The input 2D array of integers.
     *
     * 💡 Purpose:
     * To determine the largest and smallest values in a 2D array by
     * checking each element.
     *
     * 🧠 Steps:
     * 1. Initialize `max` with the smallest possible integer.
     * 2. Initialize `min` with the largest possible integer.
     * 3. Traverse each element of the 2D array using nested loops.
     * 4. For each element, update `max` if it is greater than current `max`.
     * 5. Similarly, update `min` if it is smaller than current `min`.
     * 6. Print the final values of `max` and `min`.
     */
    public static void findMaxAndMinElement(int[][] arr) {

        // Step 1: Initialize max to the smallest integer value
        int max = Integer.MIN_VALUE;

        // Step 2: Initialize min to the largest integer value
        int min = Integer.MAX_VALUE;

        // Step 3: Loop through each row of the 2D array
        for (int i = 0; i < arr.length; i++) {

            // Step 4: Loop through each element (column) of the current row
            for (int j = 0; j < arr[i].length; j++) {

                // Step 5: If current element is greater than max, update max
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }

                // Step 6: If current element is smaller than min, update min
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }

        // Step 7: Print the maximum and minimum values found in the 2D array
        System.out.println("The max element in the given 2D array is : " + max);
        System.out.println("The minimum element in the given 2D array is : " + min);
    }
}
