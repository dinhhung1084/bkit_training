package Datastructures.Sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        insertionSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("It took: " + (endTime - startTime));
    }

    public static void insertionSort(int[] arr) {
        for (var i = 0; i < arr.length; i++) {
            var current = arr[i];
            var j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
