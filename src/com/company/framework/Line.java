package com.company.framework;

import com.company.utils.Point;

import java.util.ArrayList;

public class Line {
    private final Point beginningPoint;
    private final Point endPoint;
    private float k;        //Common equation for every line is:
    private float b;        // y = k*x + b
    private String lineEquation;
    private ArrayList<Point> listOfPoints = new ArrayList<>();

    public Line(){
        this.beginningPoint = new Point(0f,0f);
        this.endPoint = new Point(3f,3f);
    }

    public Line(Point beginningPoint, Point endPoint){
        this.beginningPoint = beginningPoint;
        this.endPoint = endPoint;
        listOfPoints.add(this.beginningPoint);
        listOfPoints.add(this.endPoint);
    }

    public void GetLineEquation(){
        GetLineEquation(this.beginningPoint, this.endPoint);
    }

    public void GetLineEquation(Point point1, Point point2){
        float x1 = point1.xCoordinate;
        float x2 = point2.xCoordinate;
        float y1 = point1.yCoordinate;
        float y2 = point2.yCoordinate;

        this.k = (y1 - y2)/(x1 - x2);
        if (x1 == x2){
            this.lineEquation = String.format("Line equation is: x = %s", x1);
            return;
        }
        this.b = y1 - this.k * x1;
        this.lineEquation = String.format("Line equation is: y = %s*x + %s", this.k, this.b);
    }

    public void PointBelongsToLine(Point point){
        if (PointBelongsLine(point)){
            System.out.printf("Point %s belongs to: \n", point);
        }
        else {
            System.out.printf("Point %s does not belong to: \n", point);
        }
        System.out.println(lineEquation);
    }

    public boolean PointBelongsLine(Point point){
        return  point.yCoordinate == this.k*point.xCoordinate + this.b;
    }

    public void PrintLineInfo(){
        GetLineEquation();
        System.out.printf("\n%s\nBeginningPoint is: %s\nEndPoint is: %s\n", this.lineEquation,this.beginningPoint, this.endPoint);
    }

}
