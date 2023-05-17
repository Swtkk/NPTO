package org.example;

import java.io.Serializable;

abstract class Figure  {
     String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getDistance(){
        return 0;
    }
}
