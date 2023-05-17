package org.example;

import java.io.Serializable;

public class Section extends Figure implements Serializable {

    private Point p1;
    private Point p2;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Section() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.label = "";
    }
    public Section(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }public Section(Point p1, Point p2,String label) {
        this.p1 = p1;
        this.p2 = p2;
        this.label = label;
    }
    public Section(Section other,String label){
        this.p1 = new Point(other.p1);
        this.p2 = new Point(other.p2);
        this.label = label;
    }
    public void move (double dx, double dy){
        this.p1.move(dx,dy);
        this.p2.move(dx,dy);
    }
    public int getArea(){
        return 0;
    }
    @Override
    public String toString() {
         return "Section [" + label + "]:\n  1 - " + p1.toString() + "\n  2 - " + p2.toString();
    }

    @Override
    public double getDistance() {
        double cX=(p1.getX() + p2.getX())/2;
        double cY= (p2.getX()+p2.getY())/2;
        return Math.sqrt(Math.pow(cX,2)+Math.pow(cY,2));
    }
}
