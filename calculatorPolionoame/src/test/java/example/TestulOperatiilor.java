package example;
import operatie.Operatii;
import polinom.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestulOperatiilor {

    @Test
    public void addTest()
    {
        Polinom p1=new Polinom("x^3+x^2");
        Polinom p2=new Polinom("-x");

        Operatii operatie=new Operatii();
        String suma=operatie.add(p1, p2);

        Polinom test=new Polinom("x^3+x^2-x");

        assertEquals(test.toString(), suma);

        Polinom p3=new Polinom("4*x^5-3*x^4+x^2-8*x+1");
        Polinom p4=new Polinom("3*x^4-x^3+x^2+2*x-1");

        String suma2=operatie.add(p3, p4);

        Polinom test2=new Polinom("4x^5-x^3+2*x^2-6*x");

        assertEquals(test2.toString(), suma2);
    }

    @Test
    public void subTest()
    {
        Polinom p1=new Polinom("x^3+x^2");
        Polinom p2=new Polinom("-x");

        Operatii operatie=new Operatii();
        Polinom diferenta=operatie.sub(p1, p2);

        Polinom test=new Polinom("x^3+x^2+x");

        assertEquals(test.toString(), diferenta.toString());

        Polinom p3=new Polinom("4*x^5-3*x^4+x^2-8*x+1");
        Polinom p4=new Polinom("3*x^4-x^3+x^2+2*x-1");

        Polinom diferenta2=operatie.sub(p3, p4);

        Polinom test2=new Polinom("4x^5-6*x^4+x^3-10*x+2");

        assertEquals(test2.toString(), diferenta2.toString());
    }

    @Test
    public void mulTest()
    {
        Polinom p1=new Polinom("x^3+x^2");
        Polinom p2=new Polinom("-x");

        Operatii operatie=new Operatii();
        Polinom produs=operatie.mul(p1, p2);

        Polinom test=new Polinom("-x^4-x^3");

        assertEquals(test.toString(), produs.toString());

        Polinom p3=new Polinom("3*x^2-x+1");
        Polinom p4=new Polinom("x-2");

        Polinom produs2=operatie.mul(p3, p4);

        Polinom test2=new Polinom("3*x^3-7*x^2+3*x-2");

        assertEquals(test2.toString(), produs2.toString());
    }

    @Test
    public void divTest()
    {
        Polinom p1=new Polinom("x^3+x^2");
        Polinom p2=new Polinom("-x");

        Operatii operatie=new Operatii();
        String cat=operatie.div(p1, p2);

        String test="-x^2-x ,Rest: 0";

        assertEquals(test, cat);

        Polinom p3=new Polinom("x^3-2*x^2+6*x-5");
        Polinom p4=new Polinom("x^2-1");

        String cat2=operatie.div(p3, p4);

        String test2="x-2.0 ,Rest: 7.0*x-7.0";

        assertEquals(test2, cat2);
    }

    @Test
    public void derivareTest()
    {
        Polinom p1=new Polinom("x^3-2*x^2+6*x-5");

        Operatii operatie=new Operatii();
        String derivare=operatie.derivare(p1);

        Polinom test=new Polinom("3*x^2-4*x+6");

        assertEquals(test.toString(), derivare);

        Polinom p2=new Polinom("x^2+2*x+1");

        String derivare2=operatie.derivare(p2);

        Polinom test2=new Polinom("2*x+2");

        assertEquals(test2.toString(), derivare2);
    }

    @Test
    public void integrareTest()
    {
        Polinom p1=new Polinom("4*x^3-3*x^2+6*x-5");

        Operatii operatie=new Operatii();
        String integrare=operatie.integrare(p1);

        Polinom test=new Polinom("x^4-x^3+3*x^2-5*x");

        assertEquals(test.toString(), integrare);

        Polinom p2=new Polinom("3x^2+2*x+1");

        String integrare2=operatie.integrare(p2);

        Polinom test2=new Polinom("x^3+x^2+x");

        assertEquals(test2.toString(), integrare2);
    }
}
