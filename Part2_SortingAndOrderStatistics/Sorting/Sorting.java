package Part2_SortingAndOrderStatistics.Sorting;
import java.util.*;

class Sorting {
    public static void swap(int[] arr, int i, int j) {
        /*
         * Basic swap pattern
         */
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void SelectionSort(int[] arr) {
        // Time Complexity: Omega(n^2) - Theta(n^2) - O(n^2)
        // Space complexity: O(1)
        // Idea: Keep finding the next smallest element and put it in the right place, starting from the front.
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            int min_val = arr[i];
            int min_idx = i;

            // find the next smallest value
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min_val) {
                    min_val = arr[j];
                    min_idx = j;
                }
            }

            // swap the found smallest value with the current value;
            swap(arr, min_idx, i);
        }
    }

    public static void BubbleSortv1(int[] arr) {
        // Time Complexity: Omega(n) - Theta(n^2) - O(n^2)
        // Space complexity: O(1)
        // Keep looping through each consecutive pair of element and put the smaller element before.
        boolean any_swapped = true;
        while (any_swapped == true) {
            any_swapped = false; // if it is false by the end of the following for loop, that means we have
                                 // sorted every thing
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i, i + 1);
                    any_swapped = true;
                }

            }
        }
    }

    public static void BubbleSortv2(int[] arr) {
        // Time Complexity: Omega(n) - Theta(n^2) - O(n^2)
        // Space complexity: O(1)
        // i is the number of excluded tail elements
        // j is the index looper
        // In every i-loop iteration, the largest element will pushed to the back
        int i, j;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void MergeSort(int[] arr) {
        // Time Complexity: Omega(n * logn) - Theta(n * logn) - O(n*logn)
        // Space Complexity: O(n)
        // Idea: Recursively break the array into half. Keep putting the smaller in front of the larger element.
        MergeSort_helper(arr, 0, arr.length - 1);
    }

    public static void MergeSort_helper(int[] arr, int start, int end) {
        if (start >= end)
            return;

        // find middle index
        int mid = start + (end - start) / 2;

        // MergeSort_helper for each half
        MergeSort_helper(arr, start, mid);
        MergeSort_helper(arr, mid + 1, end);

        // Use two-pointer to sort these two half
        int[] temp_arr = new int[end - start + 1];
        int temp_idx = 0;
        int i = start; // start <= i <= mid
        int j = mid + 1; // mid < j <= end;
        while (i <= mid || j <= end) {
            if (i > mid) {
                temp_arr[temp_idx++] = arr[j++];
            } else if (j > end) {
                temp_arr[temp_idx++] = arr[i++];
            } else {
                if (arr[i] > arr[j]) {
                    temp_arr[temp_idx++] = arr[j++];
                } else {
                    temp_arr[temp_idx++] = arr[i++];
                }
            }
        }

        // copy temp arr to the relevant part of the main-arr
        int main_idx = start;
        int copy_idx = 0;
        while (main_idx <= end)
            arr[main_idx++] = temp_arr[copy_idx++];

    }

    public static void QuickSort(int[] arr){
        // Time Complexity: Omega(n*logn) - Theta(n*logn) - O(n^2)
        // Space complexity: O(logn)
        // Idea: Recursively breaking the array into half. 
        // Pick a pivot (conventionally the last element)
        // Put smaller number before the pivot, and larger number after the pivot
        QuickSort_helper(arr, 0, arr.length - 1);
    }
    public static void QuickSort_helper(int[] arr, int start, int end){
        if(end > start){
            int pi = QuickSort_partition(arr, start, end);

            QuickSort_helper(arr, start, pi - 1);
            QuickSort_helper(arr, pi + 1, end);
        }
    }

    public static int QuickSort_partition(int[] arr, int start, int end){
        int pivot = arr[end];
        
        // Put all of the values smaller than pivot to the front of the array
        int i = start - 1;
        for(int j = 0; j <= end - 1; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }

        // Put the pivot value to the right of all of its smaller elements
        swap(arr, i + 1, end);
        return i + 1;
    }

    public static void InsertionSort(int[] arr, int start, int end){
        // Time Complexity: Omega(n) - Theta(n^2) - O(n^2)
        // Space complexity: O(1)
        // Idea: Loop through each element in the array
        // While the current element is smaller than ANY value before it, keep pushing it to the left.

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 12, 11, 13, 5, 6, 7 };
        // SelectionSort(arr);
        // BubbleSortv1(arr);
        // BubbleSortv2(arr);
        // MergeSort(arr);
        QuickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Hello world");
    }
}