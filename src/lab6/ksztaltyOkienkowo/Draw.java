package lab6.ksztaltyOkienkowo;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Draw extends JFrame{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public Draw(){
        super("Kszatałty");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
    }

    public static void main(String[] argv){

        MyPanel panel = new MyPanel();
        //g.drawRect(100,100,100,100);
        Kwadrat k=new Kwadrat();
        k.setA(100);
        panel.shapeList.add(k);


        Okrag o = new Okrag("okrag");
        o.setA(100);
        panel.shapeList.add(o);

        panel.shapeList.add(new Trojkat("trojkat"));

        int x[]={10,20,70};
        int y[]={60,20,80};
        panel.shapeList.add(new Trojkat("xx",x,y));


        Draw draw = new Draw();
        Mouse move = new Mouse(panel);
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw.setContentPane(panel);
    }
}