package lab6.ksztaltyOkienkowo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener, MouseListener {
    private int xMousesPos,yMousePos;
    private MyPanel panel;
    private Shape shape;

    public Mouse(MyPanel panel) {
        this.panel=panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        shape =null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xMousesPos = e.getX();
        yMousePos = e.getY();
        for(Shape shape: panel.shapeList){
            if(shape.In(xMousesPos,yMousePos)){
                this.shape =shape;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(shape != null){
            shape.getX(e.getX()-xMousesPos);
            shape.getY(e.getY()-yMousePos);
            xMousesPos=e.getX();
            yMousePos=e.getY();
            panel.repaint();
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}