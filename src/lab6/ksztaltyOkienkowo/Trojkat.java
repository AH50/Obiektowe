package lab6.ksztaltyOkienkowo;

import java.awt.*;

public class Trojkat extends Shape{
    private int x[] = {200,280,300};
    private int y[] = {180,200,150};
    private Polygon triangle;
    Trojkat(String name){
        super(name);
        triangle = new Polygon(x,y,3);
    }
    Trojkat(String name_,int x_[],int y_[])
    {
        name=name_;
        x=x_;
        y =y_;
    }

    @Override
    public void getX(int xp) {
        for(int i=0; i<3; i++) {
            x[i] += xp;
        }
    }
    @Override
    public void getY(int yp) {
        for(int i=0; i<3; i++) {
            y[i] += yp;
        }
    }

    @Override
    public void setA(int z) {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0, 255, 0));
        g.fillPolygon(new Polygon(x, y, 3));
    }


    @Override
    public boolean In(int xp, int yp){
        return new Polygon(this.x,this.y,3).contains(xp,yp);
    }

}