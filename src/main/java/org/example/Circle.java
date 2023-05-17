package org.example;

import java.io.Serializable;

public class Circle extends Figure implements Scalable,Fillable, Serializable {

    private double r;
    private Point o;

    public Point getO() {
        return o;
    }

    public Circle(){
        this.r = 0;
        this.o.x = 0;
        this.o.y = 0;
        this.label = "";
    }
    public Circle(Point o, double r){
        this.o = new Point(o);
        this.r = r;
    } public Circle(Point o, double r,String label){
        this.o = new Point(o);
        this.r = r;
        this.label = label;
    }
    public Circle(Circle other){
        this.o = new Point(other.o);
        this.r = other.r;
        this.label = other.label;
    }
    public Circle(Circle other,String label){
        this.o = new Point(other.o);
        this.r = other.r;
        this.label = label;
    }
    public void moveCir(double dx,double dy){
        this.o.move(dx,dy);
    }
    public double getArea(){
        return  Math.PI*r*r;
    }
    @Override
    public String toString() {
        return "Circle [" + label + "]:\n " + o.toString() + "  Promien = " + r+"\n";
    }
    @Override
    public double getDistance(){
        return Math.sqrt(o.getX()*o.getX()+o.getY()*o.getY());
    }

    @Override
    public void ScalePermiter(double k) {
        r*=k;
    }

    @Override
    public void fill(int color) {

    }
}
