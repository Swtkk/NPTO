package org.example;

import java.io.Serializable;

public class Point extends Figure implements Serializable {


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    protected double x;
    protected double y;
    public Point() {
        this.x=0;
        this.y=0;
    }
    public Point(double x, double y) {
        this.x =x;
        this.y = y;
    }public Point(double x, double y,String label) {
        this.x =x;
        this.y = y;
        this.label = label;
    }

    public Point(Point pkt){
        this.x = pkt.x;
        this.y = pkt.y;

    }public Point(Point pkt,String label){
        this.x = pkt.x;
        this.y = pkt.y;
        this.label = label;
    }
    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }
    public int getArea(){
        return 0;
    }
    @Override
    public String toString() {
        return "Point["+label+"]" +
                "(x=" + x +
                ", y=" + y +
                ')'+"\n";
    }
    @Override
    public double getDistance(){
        return Math.sqrt(x*x+y*y);
    }
}
