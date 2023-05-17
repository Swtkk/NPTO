package org.example;

import javax.swing.text.Element;
import java.io.Serializable;
import java.util.*;


public class Picture implements Serializable {

    ArrayList<Figure> objects = new ArrayList<>();
    public void fillObjects(int color){
        for(Figure figure:objects){
            if(figure instanceof Circle){
                ((Circle) figure).fill(color);
            }
        }
    }
    public void scaleObjetcs(double k){
        for(Figure fig: objects){
            if(fig instanceof Circle){
                ((Circle) fig).ScalePermiter(k);
            }
        }
    }
    public String toStringSortedByDistanceFromOrigin(){
    ArrayList<Figure> figures = new ArrayList<>(objects);
    Collections.sort(figures, new OriginDistanceComparator());
    return figures.toString().replaceAll(",", "");
    }
    public String toStringSortedByClassName(ArrayList obj){
        StringBuilder sb = new StringBuilder();
        objects.sort(new Comparator<Object>() {
            @Override
            public  int compare(Object f1, Object f2){
                return Integer.compare(f1.getClass().toString().length(),f2.getClass().toString().length());
            }
        });
        for(Object f: obj){
            sb.append(f.toString()).append("\n");
        }
        return sb.toString();
    }
   public String toStringSortedByLabel(ArrayList figure){
       StringBuilder sb = new StringBuilder();
       objects.sort(new Comparator<Object>() {
           @Override
           public  int compare(Object f1, Object f2){
               return Integer.compare(((Figure)f2).getLabel().length(),((Figure)f1).getLabel().length());
           }
       });
       for(Object f: figure){
           sb.append(f.toString()).append("\n");
       }
       return sb.toString();
   }

    public boolean add(Figure fig){
        if(fig instanceof Point){
            addPoint((Point) fig);
            return true;
        }
        if(fig instanceof Section){
            addSection((Section) fig);
            return true;
        }
        if(fig instanceof Circle){
            addCircle((Circle) fig);
            return true;
        }
        return false;
    }
    public void addPoint (Point pkt){
        objects.add(pkt);
    }
    public void addSection(Section line){
        objects.add(line);
    }
    public void addCircle(Circle cir){
        objects.add(cir);
    }
    public double getArea() {
        double area = 0;

        for(Object object: objects){
            if(object instanceof Circle){
                area += ((Circle) object).getArea();
            }
        }
        return area;
    }
    public void movePic(double dx,double dy){
    for(Object move: objects){
        if(move instanceof Point){
            ((Point) move).move(dx,dy);
        }if(move instanceof Section){
            ((Section) move).move(dx,dy);
        }if(move instanceof Circle){
            ((Circle) move).moveCir(dx,dy);
        }
    }
    }
    @Override
    public String toString() {
        StringBuilder name = new StringBuilder();

        for(Object string : objects) {
            if (string instanceof Point)
                name.append(string).append("\n");
        }

        for(Object string : objects) {
            if (string instanceof Section)
                name.append(string).append("\n");
        }

        for(Object string : objects) {
            if (string instanceof Circle)
                name.append(string).append("\n");
        }
        return name.toString();
    }
}
