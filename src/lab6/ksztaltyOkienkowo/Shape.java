package lab6.ksztaltyOkienkowo;

import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JPanel {
    public String name;

    public Shape() {

    }

    public abstract void draw(Graphics g);
    Shape(String name){
        this.name = name;
    }
    public abstract void getX(int x);
    public abstract void getY(int y);
    public abstract void setA(int a);
    public abstract boolean In(int x, int y);
}