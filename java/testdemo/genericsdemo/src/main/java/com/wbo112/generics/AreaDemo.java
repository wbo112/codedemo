package com.wbo112.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AreaDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> sa = Arrays.stream(s.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String line;
        List<Integer> lastPoints = new ArrayList<>();
        lastPoints.add(0);
        lastPoints.add(0);
        long areaSum = 0;
        for (int i = 0; i < sa.get(0); i++) {
            line = scanner.nextLine();
            List<Integer> points = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            areaSum += calcArea(lastPoints, points);
        }
    }

    private static long calcArea(List<Integer> lastPoints, List<Integer> points) {
        long rectangleArea;
        long triangleArea;
        long tempTriangleArea;
        //同方向
        if (lastPoints.get(1) * points.get(1) >= 0) {
            rectangleArea = (points.get(0) - lastPoints.get(0)) * Math.min(points.get(1), lastPoints.get(1));
            triangleArea = (points.get(0) - lastPoints.get(0)) * Math.abs(points.get(1) - lastPoints.get(1)) / 2l;
            return rectangleArea + triangleArea;
        } else {
            tempTriangleArea = (points.get(0) - lastPoints.get(0)) * (Math.abs(points.get(1)) + Math.abs(lastPoints.get(1))) / 2;
            return (long) (Math.pow(Math.abs(lastPoints.get(1)) / (Math.abs(points.get(1)) + Math.abs(lastPoints.get(1))), 2) * tempTriangleArea + Math.pow(Math.abs(points.get(1)) / (Math.abs(points.get(1)) + Math.abs(lastPoints.get(1))), 2) * tempTriangleArea);
        }

    }
}
