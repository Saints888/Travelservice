package ru.edu;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFromRadian {
    public static void main(String[] args) {

        String str = "55/45/30";
        double radian = getRadians(str);
        System.out.println("Radian > " + radian);

        String str1 = getStringCoordinate(radian * -1);
        System.out.println("String > " + str1);

        radian = getRadians(str1);
        System.out.println("Radian > " + radian);
    }

    public static String getStringCoordinate(double radian) {

        double digit = 180 / Math.PI * radian;
        String result = "" + (int) (digit);

        for(int i = 0; i < 2; i++) {
            digit = Math.abs((digit - (int) digit) * 60);
            result += "/" + Math.round(digit);
        }
        return result;
    }

    public static double getRadians(String value) {

        List<Integer> list = Stream.of(value.split("/"))
                .map((String s) -> {
                    return Integer.parseInt(s);
                })
                .collect(Collectors.toList());

        int size = list.size();
        double result = list.get(0);
        int sign = (result < 0) ? -1 : 1;

        result += (size == 3) ? ((list.get(1) + list.get(2) / 60.0) / 60) * sign :
                (size == 2) ? (list.get(1) / 60.0) * sign : 0;

        return Math.toRadians(result);
    }
}
