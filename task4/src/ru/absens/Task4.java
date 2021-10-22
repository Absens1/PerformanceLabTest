package ru.absens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Task4 {
    public static void main(String[] args) {
        double result = 0;
        String arrayPath = args[0];
        ArrayList<Integer> array = createArrayFromFile(arrayPath);
        Collections.sort(array);
        double median = findMedian(array);
        for (int j : array) {
            result += Math.abs(j - median);
        }
        System.out.println((int)result);
    }

    public static ArrayList<Integer> createArrayFromFile(String filePath) {
        ArrayList<Integer> array = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                int i = Integer.parseInt(line);
                array.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static double findMedian(ArrayList<Integer> sortedArray) {
        double median;
        if (sortedArray.size() % 2 == 0) {
            median = ((double) sortedArray.get(sortedArray.size() / 2) + (double) sortedArray.get(sortedArray.size() / 2 - 1))/2;
        }
        else {
            median = sortedArray.get(sortedArray.size() / 2);
        }
        return median;
    }
}
