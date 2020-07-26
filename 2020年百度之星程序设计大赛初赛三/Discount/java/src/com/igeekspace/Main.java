package com.igeekspace;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {
            int n = scanner.nextInt();

            BigDecimal max = new BigDecimal("0.0");
            while (n-- > 0) {
                int b = scanner.nextInt();
                BigDecimal c = scanner.nextBigDecimal();
                BigDecimal discount = new BigDecimal("1.0").subtract(c);
                BigDecimal rate = discount.divide(discount.add(new BigDecimal(b)), 5, BigDecimal.ROUND_HALF_UP);

                if (rate.compareTo(max) > 0) {
                    max = rate;
                }
            }

            System.out.println(max);
        }
    }
}
