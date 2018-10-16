package zad2;
public class Kwadrat {
    protected double a_;
    public Kwadrat(double a)
    {
        this.a_ =a;
    }
    public double getA ()
    {
        return this.a_;
    }
    public void setA (double a)
    {
        this.a_=a;
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