package ru.absens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task2 {
    public static Circle circle;
    public static ArrayList<Coordinate> dots;

    public static void main(String[] args) {
        String circlePath = args[0];
        String dotsPath = args[1];

        circle = createCircle(circlePath);
        dots = createDots(dotsPath);

        for (Coordinate dot : dots) {
            float result = (float)(Math.pow(dot.getX() - circle.getCoordinate().getX(), 2) + Math.pow(dot.getY() - circle.getCoordinate().getY(), 2));
            if (result == circle.getR() * circle.getR()) {
                System.out.println(0);
            } else if (result < circle.getR() * circle.getR()) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    public static Circle createCircle(String filePath) {
        Circle circle = new Circle();
        try {
            Coordinate circleCoordinate;
            float circleRadius;
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            String[] strCircleCoordinate = reader.readLine().split(" ");
            circleCoordinate = new Coordinate(Float.parseFloat(strCircleCoordinate[0]), Float.parseFloat(strCircleCoordinate[1]));
            circleRadius = Integer.parseInt(reader.readLine());
            circle = new Circle(circleCoordinate, circleRadius);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return circle;
    }

    public static ArrayList<Coordinate> createDots(String filePath) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinate = line.split(" ");
                coordinates.add(new Coordinate(Float.parseFloat(coordinate[0]), Float.parseFloat(coordinate[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordinates;
    }
}
