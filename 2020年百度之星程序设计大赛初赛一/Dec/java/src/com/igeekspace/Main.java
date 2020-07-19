package com.igeekspace;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final boolean debug = true;
    private static int[][] isRelativelyPrime = new int[1001][1001];
    private static int[][] relativelyPrime = new int[1001][1001];

    private static boolean calRelativelyPrime(int num1, int num2) {
        if (num1 % num2 == 0 || num2 % num1 == 0) {
            return false;
        }

        int min = Math.min(num1, num2);

        for (int i = 2; i < min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void init() {
        for (int i = 1; i < isRelativelyPrime.length; i++) {
            for (int j = i; j < isRelativelyPrime[i].length; j++) {
                isRelativelyPrime[i][j] = calRelativelyPrime(i, j) ? 1 : 0;
                isRelativelyPrime[j][i] = isRelativelyPrime[i][j];
            }
        }

        for (int i = 1; i < relativelyPrime.length; i++) {
            relativelyPrime[1][i] = i;
            relativelyPrime[i][1] = i;
        }

        for (int i = 2; i < relativelyPrime.length; i++) {
            for (int j = 2; j < relativelyPrime.length; j++) {
                relativelyPrime[i][j] = isRelativelyPrime[i][j] + Math.max(relativelyPrime[i - 1][j], relativelyPrime[i][j - 1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int testCases;
            testCases = (int)in.nval;
            in.nextToken();

            while (testCases > 0) {
                int a = (int)in.nval;
                in.nextToken();
                int b = (int)in.nval;
                in.nextToken();

                out.println(relativelyPrime[a][b]);
                testCases--;
            }
        }
        out.flush();
    }
}
