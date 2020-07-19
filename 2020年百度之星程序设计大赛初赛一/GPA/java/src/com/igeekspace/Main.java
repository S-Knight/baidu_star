package com.igeekspace;

import java.util.Scanner;

public class Main {
    private static final boolean debug = false;

    static int[] minPoints = new int[]{95, 90, 85, 80, 75, 70, 67, 65, 62, 60};
    static double[] points = new double[]{4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.0};
    static double[] maxPoints = new double[401];

    private static double getMaxPoint(int x) {
        double point = 0;
        for (int i = 0; i < minPoints.length; i++) {
            if (x >= minPoints[i]) {
                point = Math.max(point, points[i] + maxPoints[x - minPoints[i]]);
            }
        }

        return point;
    }

    private static void init() {
        for (int i = 0; i < 60; i++) {
            maxPoints[i] = 0;
        }

        for (int i = 60; i < 401; i++) {
            maxPoints[i] = getMaxPoint(i);
        }
    }

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int testCases;
            testCases = scanner.nextInt();

            while (testCases > 0) {
                int x = scanner.nextInt();

                System.out.println(String.format("%.1f", maxPoints[x]));

                testCases--;
            }
        }
    }
}
