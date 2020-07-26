package com.igeekspace;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {
            BigDecimal p = scanner.nextBigDecimal();

            if (p.compareTo(new BigDecimal("1.0")) <= 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
