package com.igeekspace;

import java.util.Scanner;

public class Main {
    private static long getMaxCount(long n, long m) {
        if (n == 1 || m == 0) {
            return 0;
        }

        if (m >= n / 2) {
            return (n) * (n - 1) / 2;
        }

        return 2 * n * m - (m * 3 + m * (m - 1) * 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println(getMaxCount(n, m));
        }
    }
}
