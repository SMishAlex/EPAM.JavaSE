package com.epam.courses.javase.msid.unit02.task1;

import java.awt.*;

/**
 * Created by msid on 24.02.17.
 */
public class Pen {
    private Color color;

    public void write(String s) {
        System.out.print(s);
    }

    public Pen(){
        color = new Color(0,0,0);
    }

    public void writeLine(String s) {
        System.out.println(s);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof Pen) {
            if (this.color.equals(((Pen)obj).color)){
                return true;
            }
        }
        return false;
    }


}
