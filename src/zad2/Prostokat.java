package zad2;
public class Prostokat extends Kwadrat {
    protected double b_;

    public Prostokat(double a, double b)
    {
        super(a);
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
    public boolean isBigger(Prostokat other)
    {
        return other.area()>area();
    }

}
