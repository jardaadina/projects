package polinom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolinomTest {

    @Test
    void testToString()
    {
        Polinom p1=new Polinom("2*x^5+2*x^3-6*x+5");
        assertEquals("2.0*x^5+2.0*x^3-6.0*x+5.0", p1.toString());

        Polinom p2=new Polinom("3*x^4+2*x^5-4*x^2+5*x");
        assertEquals("2.0*x^5+3.0*x^4-4.0*x^2+5.0*x", p2.toString());

    }
}