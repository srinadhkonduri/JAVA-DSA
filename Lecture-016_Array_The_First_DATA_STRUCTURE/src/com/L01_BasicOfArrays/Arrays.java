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
    /**
     * This method prints all the elements of a 1D array to the console.
     * It iterates over each element in the array and prints them one by one,
     * separated by a space.
     *
     * @param arr The input 1D array whose elements need to be printed.
     *
     * 💡 Purpose:
     * To display all elements of a 1D array in a readable format (separated by spaces).
     *
     * 🧠 Steps:
     * 1. Loop through each element in the array.
     * 2. Print each element, followed by a space, on the same line.
     */
    public static void printArray(int[] arr) {
        // Step 1: Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];  // Access the current element in the array
            // Step 2: Print the current element followed by a space
            System.out.print(num + " ");
        }
    }


    //    PRINTING 2D ARRAY
    /**
     * This method prints all the elements of a 2D array (matrix) to the console.
     * It iterates over each row and within each row, it iterates over the columns
     * to print the elements, all separated by spaces.
     *
     * @param arr The input 2D array (matrix) whose elements need to be printed.
     *
     * 💡 Purpose:
     * To display all elements of a 2D array in a readable format, row by row.
     * Each element within a row will be printed on the same line, separated by spaces.
     *
     * 🧠 Steps:
     * 1. Loop through each row of the 2D array (using the outer loop).
     * 2. For each row, loop through each column (using the inner loop).
     * 3. Print each element, followed by a space, on the same line for each row.
     * 4. After printing a row, print a newline to start the next row on a new line.
     */
    public static void print2dArray(int arr[][]) {
        // Step 1: Loop through each row of the 2D array
        for (int i = 0; i < arr.length; i++) {
            // Step 2: Loop through each column within the current row
            for (int j = 0; j < arr[i].length; j++) {
                // Step 3: Print the current element followed by a space
                System.out.print(arr[i][j] + " ");
            }
            // Step 4: After printing all elements of a row, print a new line
            System.out.println();
        }
    }

//    -------------------------------------------------------

//    CREATING A METHOD TO UPDATE THE ARRAY
    /**
     * This method updates a specific element in a 1D array at a given index (position).
     * It first checks if the given position is valid (within array bounds),
     * and if valid, it replaces the element at that position with the new value.
     *
     * @param arr The array in which an element needs to be updated.
     * @param pos The position (index) in the array where the element should be updated.
     * @param ele The new element to place at the specified position.
     *
     * 💡 Purpose:
     * To safely update an element in an array without causing `ArrayIndexOutOfBoundsException`.
     *
     * 🔍 Logic Overview:
     * 1. Get the length of the array and store in `size`.
     * 2. Check if the given position is valid (i.e., between 0 and size - 1).
     *    - If invalid: print "wrong position" and exit the method using `return`.
     * 3. If valid, update the element at the specified position with the new value.
     */
    public static void updateArray(int[] arr, int pos, int ele) {
        int size = arr.length; // Step 1: Store the total number of elements in the array

        // Step 2: Validate the position
        if (pos < 0 || pos > size - 1) {
            // If the given index is outside the valid range, print error message and exit
            System.out.println("wrong position");
            return;
        }

        // Step 3: Update the value at the given index
        arr[pos] = ele; // Replace the old value with the new one
    }

    //    CREATING A METHOD TO UPDATE THE 2D ARRAY
    /**
     * This method updates a specific element in a 2D array (matrix) at a given row and column position.
     * It first checks if the given row and column positions are valid (i.e., within array bounds),
     * and if valid, it updates the element at that position with the new value.
     *
     * @param arr     The 2D array in which an element needs to be updated.
     * @param pos1    The row index of the element to be updated.
     * @param pos2    The column index of the element to be updated.
     * @param element The new element/value to be placed at the specified position.
     *
     * 💡 Purpose:
     * To safely update an element in a 2D array while handling invalid positions (avoiding exceptions).
     *
     * 🔍 Logic Overview:
     * 1. Check if the given row index (`pos1`) is valid.
     *    - If not valid (less than 0 or beyond number of rows), print error and exit.
     * 2. If valid, get the number of columns in that specific row using `arr[pos1].length`.
     *    - Then check if the column index (`pos2`) is valid.
     *    - If invalid, print error and exit.
     * 3. If both indices are valid, update the element at `arr[pos1][pos2]` with the new value.
     */
    public static void update2DArray(int[][] arr, int pos1, int pos2, int element) {
        // Step 1: Get the number of rows in the 2D array
        int size1 = arr.length;

        // Step 2: Validate the row index (pos1)
        if (pos1 < 0 || pos1 > size1 - 1) {
            // If row index is invalid, print error and exit method
            System.out.println("wrong position");
            return;
        }

        // Step 3: Get the number of columns in the specified row
        int size2 = arr[pos1].length;

        // Step 4: Validate the column index (pos2)
        if (pos2 < 0 || pos2 > size2 - 1) {
            // If column index is invalid, print error and exit method
            System.out.println("wrong position");
            return;
        }

        // Step 5: Both indices are valid → update the element
        arr[pos1][pos2] = element; // Replace the old value with the new one
    }

//    ----------------------------------------------------------

//    INSERTING AN ELEMENT IN THE ARRAY
    /**
     * This method inserts an element at a specified position in a 1D array by shifting
     * the existing elements to the right. It assumes that the array has one extra space
     * at the end to allow insertion without overflow.
     *
     * @param arr     The input array where the element is to be inserted.
     * @param pos     The index (position) at which the new element is to be inserted.
     * @param element The value to be inserted into the array.
     *
     * 💡 Purpose:
     * To insert a new value into a specified index in an array by shifting elements rightward.
     *
     * 🔍 Assumption:
     * The array has one empty slot at the end (i.e., size n but contains only n-1 filled elements),
     * so insertion won’t cause data loss or out-of-bounds error.
     *
     * 🧠 Steps:
     * 1. Get the size (length) of the array.
     * 2. Validate the position. If invalid (i.e., < 0 or >= size), print an error and return.
     * 3. Starting from the second last index, shift elements one step to the right until the target position.
     * 4. Insert the new element at the specified position.
     */
    public static void insert(int[] arr, int pos, int element) {
        // Step 1: Get the size of the array
        int size = arr.length;

        // Step 2: Check for valid position
        if (pos < 0 || pos > size - 1) {
            System.out.println("wrong position"); // If out of bounds, print error
            return; // Exit the method early
        }

        // Step 3: Shift elements to the right to create space for the new element
        // Note: Start from second last element (size - 2) because last index (size - 1) is free
        for (int i = size - 2; i >= pos; i--) {
            arr[i + 1] = arr[i]; // Move element at index i to i+1
        }

        // Step 4: Insert the new element at the specified position
        arr[pos] = element; // Place the new value at the desired position
    }

    //    INSERTING INTO 2D ARRAY
    /**
     * This method inserts an element into a 2D array (matrix) by calling the
     * existing 1D `insert` method on a specific row.
     *
     * It assumes that the specific row (1D array) already has extra space at the end
     * to accommodate the new element and avoid overflow.
     *
     * @param arr     The 2D array (matrix) where the insertion should take place.
     * @param pos1    The row index (which 1D array inside the 2D array to target).
     * @param pos2    The column index (position in the row) where the new element is to be inserted.
     * @param element The value to insert at the specified position in the specified row.
     *
     * 💡 Purpose:
     * To perform an insertion operation in a specific row of a 2D array by reusing
     * the logic from the 1D `insert()` method.
     *
     * 🔍 Assumption:
     * - The row (arr[pos1]) should be a 1D array with at least one free slot at the end.
     * - The `insert()` method being used handles boundary checks and shifting logic.
     *
     * 🧠 Steps:
     * 1. Use the row index `pos1` to select the correct 1D array inside the 2D array.
     * 2. Call the already-defined `insert()` method on that row, passing:
     *    - The 1D row array
     *    - The column index `pos2` where insertion should happen
     *    - The new element to be inserted
     */
    public static void insert2DArray(int[][] arr, int pos1, int pos2, int element) {
        // Step 1: Perform insertion in the specified row using the existing 1D insert method
        insert(arr[pos1], pos2, element);
    }

//    ---------------------------------------------------------------

    // DELETING THE ELEMENT IN THE ARRAY
    /**
     * This method deletes an element from a specific position in a 1D array.
     * It shifts all subsequent elements one position to the left and sets the last element to 0.
     *
     * @param arr The input array from which the element needs to be deleted.
     * @param pos The index (position) in the array where the element should be deleted.
     *
     * 💡 Purpose:
     * To remove an element at a specific index by shifting all elements after it to the left.
     * The last element is set to 0 to maintain array integrity and avoid leftover values.
     *
     * 🧠 Steps:
     * 1. Start at the given position `pos`.
     * 2. Shift each element after `pos` one position to the left (i.e., `arr[i] = arr[i+1]`).
     * 3. Set the last element in the array to 0 (since we effectively removed one element).
     */
    public static void delete(int[] arr, int pos) {
        // Step 1: Shift elements starting from the given position `pos` to the left
        // We loop until the second-to-last element in the array (arr.length - 2)
        for (int i = pos; i <= arr.length - 2; i++) {
            arr[i] = arr[i + 1]; // Shift element to the left
        }

        // Step 2: Set the last element of the array to 0 (since it is now redundant)
        arr[arr.length - 1] = 0; // Remove last element (set to 0)
    }


    //    DELETING THE ELEMENT IN THE 2D ARRAY
    /**
     * This method deletes an element from a specific position in a 2D array (matrix) by calling the
     * `delete` method on the specific row (1D array).
     * It assumes that the row (arr[pos1]) has space available at the end, and the `delete` method works
     * on 1D arrays.
     *
     * @param arr     The 2D array (matrix) where the deletion will happen.
     * @param pos1    The row index in the 2D array (which 1D array to target).
     * @param pos2    The column index (position in the row) of the element to be deleted.
     *
     * 💡 Purpose:
     * To delete an element in a 2D array at a specific row and column by reusing the existing `delete` method
     * for 1D arrays.
     *
     * 🔍 Assumption:
     * - The row specified by `pos1` is a 1D array, and the `delete` method is defined for 1D arrays.
     * - The column index `pos2` is valid in the specified row.
     *
     * 🧠 Steps:
     * 1. Access the 1D row array at `arr[pos1]`.
     * 2. Call the `delete()` method to remove the element from that row at position `pos2`.
     * 3. The `delete()` method handles shifting elements and setting the last element to 0.
     */
    public static void delete2Darray(int[][] arr, int pos1, int pos2) {
        // Step 1: Delete element from the specific row (1D array)
        delete(arr[pos1], pos2); // Call the existing delete method on the specific row
    }
}
