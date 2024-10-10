package Datastructures.Sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("It took: " + (endTime - startTime));
    }
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = a;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;

    }
}
