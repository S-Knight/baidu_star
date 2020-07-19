package com.igeekspace;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int testCases;
            testCases = scanner.nextInt();

            while (testCases > 0) {
                int n, m;
                n = scanner.nextInt();
                m = scanner.nextInt();

                int calorie = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    int x, y;

                    x = scanner.nextInt();
                    y = scanner.nextInt();

                    if (m % x == 0) {
                        calorie = Math.min(calorie, y * m / x);
                    } else {
                        calorie = Math.min(calorie, y * (m / x + 1));
                    }
                }

                System.out.println(calorie);

                testCases--;
            }
        }
    }
}
