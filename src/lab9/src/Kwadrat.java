package lab6.ksztaltyOkienkowo;

import java.awt.*;

public class Kwadrat extends Shape {
    private int x;
    private int y;
    private int a;
    private Polygon kwadrat;

    public Kwadrat(String name_,int x_, int y_, int a_) {
        super();
        name=name_;
        x=x_;
        y =y_;
        a=a_;

    }
    public Kwadrat(){
        //basic
        name="kwadrat";
        x=10;
        y=10;
        a=10;
    }
    public void setA(int a){
        this.a=a;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 255));
        g.fillRect(getX() + x, getY() + y, a, a);
    }

    @Override
    public void getX(int x_) {
        this.x += x_;
    }
    @Override
    public void getY(int y) {
        this.y += y;
    }

    @Override
    public boolean In(int xp, int yp) {
        return (xp <= x + a && xp >= x && yp <= y+a && yp >= y);
    }
}