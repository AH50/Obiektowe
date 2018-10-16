package obiektowe;

import java.util.*;

public class Test {
    private LinkedList<Prostokąt> prostokąty = new LinkedList<Prostokąt>();
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner read = new Scanner(System.in);
        Test text = new Test();
        while(!exit)
        {
            System.out.print("1. Wczytaj prostokąt \n"+
                    "2. Wyświetl prostokąty \n"+
                    "3. Oblicz sumę pól \n"+
                    "4. Wyjście \n");
            String option = read.nextLine();
            if(option.equals("4")) exit = true;
            else if (option.equals("1"))
            {
                System.out.print("Podaj wymiary prostokąta\n");
                Prostokąt nowy = new Prostokąt(read.nextDouble(),read.nextDouble());
                read.nextLine();
                text.prostokąty.add(nowy);
            }
            else if (option.equals("2"))
            {
                for (Prostokąt p: text.prostokąty)
                {
                    System.out.print("Prostokąt o wymiarach "+p.getA()+" na "+p.getB()+"\n");
                }
            }
            else if(option.equals("3"))
            {
                double suma = 0;
                for (Prostokąt p: text.prostokąty)
                {
                    suma+=p.area();
                }
                System.out.print("Suma pól: " + suma + "\n");
            }
        }
    }
}