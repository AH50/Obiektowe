package obiektowe;
public class Prostokąt extends Kwadrat {
    protected double b_;

    public Prostokąt(double a, double b)
    {
        super(a);
        b_ = b;
    }

    public double getB()
    {
        return b_;
    }

    public void setB(double b)
    {
        b_ = b;
    }

    public double area()
    {
        return a_*b_;
    }
    public boolean isBigger(Prostokąt other)
    {
        return other.area()>area();
    }

}
