package com.company.framework;

public class Point {
    public float xCoordinate;
    public float yCoordinate;

    public Point(){
        this.xCoordinate = 0f;
        this.yCoordinate = 0f;
    }

    public Point(float x, float y){
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    @Override
    public String toString() {
        return "Point(" +
                 + xCoordinate +
                ", " + yCoordinate +
                ')';
    }
}
