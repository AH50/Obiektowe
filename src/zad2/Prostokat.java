package zad2;
public class Prostokat extends Kwadrat {
    protected double b_;

    public Prostokat(double a, double b)
    {
        super(a);
        if(b<0)
            System.out.println("Bledne dane");
        this.b_ = b;
    }

    public double getB()
    {
        return this.b_;
    }

    public void setB(double b)
    {
        this.b_ = b;
    }

    public double area()
    {
        return a_*b_;
    }
    public boolean isBigger(Prostokat p1)
    {
        return p1.area()>area();
    }

}
