package zad2;
import java.util.*;

public class Test {
    private LinkedList<Prostokat> prostokąty = new LinkedList<Prostokat>();
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner read = new Scanner(System.in);
        Test obj = new Test();
        while(!exit)
        {
            System.out.print(
                    "1.Wczytaj prostokąt \n"+
                    "2.Wyświetl wszytkie prostokąty \n"+
                    "3.Oblicz sumę pól \n"+
                    "4.Koniec \n");
            String opcja = read.nextLine();
            if(opcja.equals("1"))
            {
                System.out.print("Podaj wymiary prostokąta\n");
                Prostokat nowy = new Prostokat(read.nextDouble(),read.nextDouble());
                read.nextLine();
                obj.prostokąty.add(nowy);
            }
            else if (opcja.equals("2"))
            {
                for (Prostokat it: obj.prostokąty)
                {
                    System.out.print("Prostokąt "+it.getA()+" na "+it.getB()+"\n");
                }
            }
            else if(opcja.equals("3"))
            {
                double suma = 0;
                for (Prostokat it: obj.prostokąty)
                {
                    suma=suma+it.area();
                }
                System.out.print("Suma pól: " + suma + "\n");
            }
            else if(opcja.equals("4"))
            {
                exit=true;
            }
        }
    }
}