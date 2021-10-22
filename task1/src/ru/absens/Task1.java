package ru.absens;

import java.util.LinkedList;

public class Task1 {
    public static LinkedList<Interval> intervals = new LinkedList<>();
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        getIntervals(array, m);
        String result = "";
        for (Interval interval : intervals) {
            result = result.concat(String.valueOf(interval.startValue));
        }
        System.out.println(result);
    }

    public static void getIntervals(int[] array, int m) {
        for (int i = 0; i < array.length; i++) {
            if (intervals.size() == 0 || i == intervals.getLast().endIndex) {
                int endIndex = i + m - 1 < array.length ? i + m - 1 : (i + m - 1) - array.length;
                Interval interval = new Interval(i, endIndex, array[i], array[endIndex]);
                intervals.add(interval);
            }
        }
        if (intervals.getLast().endIndex != intervals.getFirst().startIndex) {
            getIntervals(array, m);
        }
    }
}
