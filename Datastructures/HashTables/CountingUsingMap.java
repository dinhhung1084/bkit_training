package Datastructures.HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingUsingMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }

        int q = scanner.nextInt();
        while (q-- > 0) {
            int number = scanner.nextInt();
            System.out.println(mpp.getOrDefault(number, 0));
        }

        scanner.close();
    }
}

