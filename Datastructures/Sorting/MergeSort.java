package Datastructures.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static int[] merge(int[] leftArr,int[] rightArr){
        List<Integer> resultArr = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length){
            if (leftArr[leftIndex] < rightArr[rightIndex]){
                resultArr.add(leftArr[leftIndex]);
                leftIndex += 1;
            }else {
                resultArr.add(rightArr[rightIndex]);
                rightIndex += 1;
            }
        }

        while (leftIndex < leftArr.length) {
            resultArr.add(leftArr[leftIndex]);
            leftIndex++;
        }


        while (rightIndex < rightArr.length) {
            resultArr.add(rightArr[rightIndex]);
            rightIndex++;
        }

        return resultArr.stream().mapToInt(Integer::intValue).toArray();
    }
    public static int[] mergeSort(int[] arr){
        if (arr.length <2){
            return arr;
        }

        int middleIndex = (int) Math.floor(arr.length /2);
        int[] leftArr = Arrays.copyOfRange(arr, 0, middleIndex);
        int[] rightArr = Arrays.copyOfRange(arr, middleIndex,arr.length);

        return merge(mergeSort(leftArr),mergeSort(rightArr));
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] sortedArr = mergeSort(arr);

        // In mảng đã sắp xếp
        System.out.println(Arrays.toString(sortedArr));
    }

}
