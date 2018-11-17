package lab6.ksztaltyOkienkowo;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends JPanel {
    LinkedList<Shape> shapeList;

    MyPanel(){
        shapeList = new LinkedList<>();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, Draw.WIDTH, Draw.HEIGHT);
        for(Shape i: shapeList) {
            i.draw(g);
        }
    }
}