package org.example;

import java.util.Comparator;


public class OriginDistanceComparator implements Comparator<Figure> {
        @Override
        public int compare(Figure f1, Figure f2){
            if(f1.getDistance()<f2.getDistance()){
                return -1;
            } else if (f1.getDistance() > f2.getDistance()) {
                return 1;
            }
            else return 0;
        }
    }

