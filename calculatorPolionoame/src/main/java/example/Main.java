package example;

import interfata.Controler;
import interfata.Vedere;
import operatie.Operatii;
import polinom.Polinom;

public class Main
{
    public static void main( String[] args )
    {
        Vedere view=new Vedere("proiect");
        Operatii model=new Operatii();
        Controler controller = new Controler(view, model);

    }
}