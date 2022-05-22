package com.wbo112.nowcoder;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int lines = Integer.parseInt(scanner.nextLine());
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }

    }
}
