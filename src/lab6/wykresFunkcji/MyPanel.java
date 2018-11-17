package lab6.wykresFunkcji;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {
    private static final int W = 500;
    private int from_ = -10;
    private int to_ = 10;
    private JTextField a = new JTextField(3);
    private JTextField b = new JTextField(3);
    private JTextField c = new JTextField(3);
    private JTextField d = new JTextField(3);
    private JTextField from = new JTextField(3);
    private JTextField to = new JTextField(3);
    private int a_=1,b_=1,c_=1,scale=5;

   public MyPanel() {
        setPreferredSize(new Dimension(W, W));
    }

    @Override
    protected void paintComponent(Graphics g) {
        a.setLocation(20, W-50);
        b.setLocation(60, W-50);
        c.setLocation(100, W-50);
        d.setLocation(380, W-50);
        from.setLocation(420, W-50);
        to.setLocation(460, W-50);

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        from.addActionListener(this);
        to.addActionListener(this);
        add(a);
        add(b);
        add(c);
        add(d);
        add(from);
        add(to);
        super.paintComponent(g);
        int y_, w_, w = 0, h = 0;
        int x;
        int y;
            for (x = from_; x <= to_; x++) {
                y_ = h;
                w_ = w;

                y = a_ * x * x + b_ * x + c_;

                g.setColor(new  Color(0, 0, 0) );

                w = (x * scale) + W / 2;
                h = (-y * scale) + W / 2;

                g.drawLine(0, W / 2, W, W / 2);
                g.drawLine(W / 2, 0, W / 2, W);
                if (w_ != 0) {
                    g.drawLine(w, h, w_, y_);
                }
            }
            g.drawString("x", W - 10, W / 2);
            g.drawString("y", W / 2 + 10, 10);
            g.drawString("a", 25, W-55);
            g.drawString("b", 65, W-55);
            g.drawString("c", 105, W-55);
            g.drawString("scale", 380,W-55);
            g.drawString("from", 420,W-55);
            g.drawString("to",460 ,W-55);

    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if(source == a) {
            String s = a.getText();
            a_=Integer.parseInt(s);
            repaint();
        }

        else if(source == b)
        {
            String s = b.getText();
            b_=Integer.parseInt(s);
            repaint();
        }

        else if(source == c)
        {
            String s = c.getText();
            c_=Integer.parseInt(s);
            repaint();
        }
        else if(source == d)
        {
            String s = d.getText();
            scale=Integer.parseInt(s);
            repaint();
        }
        else if(source == from)
        {
            String s = from.getText();
            from_=Integer.parseInt(s);
            repaint();
        }
        else if(source == to)
        {
            String s = to.getText();
            to_=Integer.parseInt(s);
            repaint();
        }
    }
}