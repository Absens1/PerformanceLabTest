package ru.absens;

public class Circle {
    private Coordinate coordinate;
    private float r;

    public Circle() {
    }

    public Circle(Coordinate coordinate, float r) {
        this.coordinate = coordinate;
        this.r = r;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public float getR() {
        return r;
    }
}
