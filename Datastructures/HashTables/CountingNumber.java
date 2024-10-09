package Datastructures.HashTables;

import java.util.Scanner;

public class CountingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("n["+i+"]:");
            arr[i] = scanner.nextInt();
        }

        int[] hash = new int[100000000];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        System.out.println("Number to query:");
        int q = scanner.nextInt();
        while (q-- > 0) {
            System.out.println("Count: ");
            int number = scanner.nextInt();
            System.out.println(hash[number]);
        }
        scanner.close();

    }
}

