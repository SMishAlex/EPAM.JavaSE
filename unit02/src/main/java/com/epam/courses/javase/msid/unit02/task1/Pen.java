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

    public void writeLine(String s) {
        System.out.println(s);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
