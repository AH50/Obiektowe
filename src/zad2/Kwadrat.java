package zad2;
public class Kwadrat {
    protected double a_;
    public Kwadrat(double a)
    {
        a_ =a;
    }
    public double getA()
    {
        return a_;
    }
    public void setA(double a)
    {
        a_=a;
    }
    public double area()
    {
        return a_*a_;
    }
    public boolean isBigger(Kwadrat other)
    {
        return other.a_>a_;
    }
}