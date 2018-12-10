package lab6.ksztaltyOkienkowo;

import java.awt.*;

public class Okrag extends Shape{
    private int x = 10;
    private int y = 200;
    private int r = 100;
    Okrag(String name){
        super(name);
    }

    @Override
    public void getX(int x) {
        this.x+=x;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0,0,255));
        g.fillOval(getX()+x,getY()+y,r,r);
    }
    @Override
    public void getY(int y) {
        this.y += y;
    }

    @Override
    public void setA(int r) {
        this.r=r;
    }

    @Override
    public boolean In(int x, int y){
        return (x-this.x)*(x-this.x)+(y-this.y)*(y-this.y)<=this.r*this.r;
    }
}