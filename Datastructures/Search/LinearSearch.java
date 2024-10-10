package Datastructures.Search;

import java.util.Random;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[1024];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1024);
        }
        int index = linearSearch(arr, 338);
        if (index != -1){
            System.out.println(index);
        }else{
            System.out.println("Error");
        }
    }
    public static int linearSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
