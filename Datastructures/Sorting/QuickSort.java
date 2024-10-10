package Datastructures.Sorting;

import javax.swing.text.Highlighter;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
        long startTime = System.currentTimeMillis();
        quickSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("It took: " + (endTime - startTime));
    }

    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length - 1);
    }
    public static void quickSort(int[] arr,int lowIndex,int highIndex){
        if (lowIndex >= highIndex){
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(arr,leftPointer,rightPointer);
        }
        swap(arr,leftPointer,highIndex);

        quickSort(arr,lowIndex,leftPointer - 1);
        quickSort(arr,leftPointer + 1,highIndex);
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
