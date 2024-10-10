package Datastructures.Search;

import java.util.Arrays;

public class BinarySearch {
    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        int[] slicedArray = Arrays.copyOfRange(arr, start, end + 1);
        System.out.println(Arrays.toString(slicedArray));
        if (start > end) {
            return false;
        }
        int mid = (int) Math.floor((start + end) / 2.0);

        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1024];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int start = 0;
        int end = arr.length - 1;
        int target = 1024;
        boolean result = binarySearch(arr, start, end, target);
        System.out.println("Found target: " + result);
    }
}


