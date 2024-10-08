package DSA.Stack;

import java.util.Arrays;

public class LeetCode853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;
        double time = 0;

        for (double[] car : cars) {
            if (car[1] > time) {
                count++;
                time = car[1];
            }
        }
        return count;
    }
}
