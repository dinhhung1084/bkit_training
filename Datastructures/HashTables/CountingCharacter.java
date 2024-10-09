package Datastructures.HashTables;

import java.util.Scanner;

public class CountingCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("string:");
        String s = scanner.next();

        int[] hash = new int[256];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        System.out.println("Counting time:");
        int q = scanner.nextInt();
        while (q-- > 0) {

            System.out.println("Counting Character:");
            char c = scanner.next().charAt(0);
            System.out.println(hash[c - 'a']);
        }

        scanner.close();
    }
}

