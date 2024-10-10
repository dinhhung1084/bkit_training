package Datastructures.Sorting;

import java.util.Arrays;
import java.util.Random;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        selectionSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("It took: " + (endTime - startTime));
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
