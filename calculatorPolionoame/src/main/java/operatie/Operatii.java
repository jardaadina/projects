package operatie;

import polinom.Polinom;

import java.util.*;

public class Operatii
{
    public String add(Polinom p1, Polinom p2) {
        Polinom rezultat = p1;

        for (Map.Entry<Integer, Double> entry : p2.getMonoame().entrySet()) {
            if(rezultat.getMonoame().containsKey(entry.getKey())) {
                rezultat.getMonoame().put(entry.getKey(), rezultat.getMonoame().get(entry.getKey()) + entry.getValue());
            }
            else {
                rezultat.getMonoame().put(entry.getKey(), entry.getValue());
            }
        }
        return rezultat.toString();
    }

    public Polinom sub(Polinom p1, Polinom p2) {
        Polinom rezultat = p1;

        for (Map.Entry<Integer, Double> entry : p2.getMonoame().entrySet()) {
            if (rezultat.getMonoame().containsKey(entry.getKey())) {
                if(rezultat.getMonoame().get(entry.getKey())-entry.getValue()==0)
                    rezultat.getMonoame().remove(entry.getKey());

                else rezultat.getMonoame().put(entry.getKey(), rezultat.getMonoame().get(entry.getKey()) - entry.getValue());
            }
            else {
                rezultat.getMonoame().put(entry.getKey(), -entry.getValue());
            }
        }
        return rezultat;
    }

    public Polinom mul(Polinom p1, Polinom p2) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Double> entry1 : p1.getMonoame().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.getMonoame().entrySet()) {

                int gradPolinom1 = entry1.getKey();
                double coeficientPolinom1 = entry1.getValue();

                int gradPolinom2 = entry2.getKey();
                double coeficientPolinom2 = entry2.getValue();

                int gradProdus = gradPolinom1 + gradPolinom2;
                double coeficientProdus = coeficientPolinom1 * coeficientPolinom2;

                rezultat.getMonoame().put(gradProdus, rezultat.getMonoame().getOrDefault(gradProdus, 0.0) + coeficientProdus);
            }
        }
        return rezultat;
    }

    public int getExponentMaxim(Polinom p) {
        int exponentMaxim = Integer.MIN_VALUE;
        for (int exponent : p.getMonoame().keySet()) {
            if (exponent > exponentMaxim) {
                exponentMaxim = exponent;
            }
        }
        return exponentMaxim;
    }

    public String div(Polinom p1, Polinom p2) {
        if(getExponentMaxim(p1)<getExponentMaxim(p2)) {
            return "p1 mai mic decat p2";
        }
        if(p2.getMonoame().get(getExponentMaxim(p2))==0) {
            return "nu se poate imparti la 0";
        }

        Polinom cat=new Polinom();
        Polinom rest;

        while(getExponentMaxim(p1) >= getExponentMaxim(p2)) {
            int gradP1=getExponentMaxim(p1);
            double coeficientP1=p1.getMonoame().get(gradP1);

            int gradP2=getExponentMaxim(p2);
            double coeficientP2=p2.getMonoame().get(gradP2);

            if(coeficientP2!=0) {
                int gradRezultat = gradP1 - gradP2;
                double coeficientRezultat = coeficientP1 / coeficientP2;

                cat.getMonoame().put(gradRezultat, coeficientRezultat);

                Polinom aux = new Polinom();
                aux.getMonoame().put(gradRezultat, coeficientRezultat);
                Polinom produs = mul(p2, aux);
                p1 = sub(p1, produs);
            }
        }
        rest=p1;
        String rezultat = cat.toString() + " ,Rest: " + rest.toString();
        return rezultat;
    }

    public String derivare(Polinom p1) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Double> entry : p1.getMonoame().entrySet()) {
            int grad = entry.getKey();
            double coeficient = entry.getValue();

            if(entry.getKey() > 0) {
                int gradDupaDerivare = grad - 1;
                double coeficientDupaDerivare = coeficient * grad;

                rezultat.getMonoame().put(gradDupaDerivare, coeficientDupaDerivare);
            }
        }
        return rezultat.toString();
    }

    public String integrare(Polinom p1) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Double> entry : p1.getMonoame().entrySet()) {

            int grad= entry.getKey();
            double coeficient = entry.getValue();

            if(grad >= 0) {
                int gradDupaIntegrare=grad+1;
                double coeficientDupaIntegrare = coeficient / gradDupaIntegrare;
                double roundedValue = Math.round(coeficientDupaIntegrare * 100.0) / 100.0;

                rezultat.getMonoame().put(gradDupaIntegrare, roundedValue);
            }
        }
        return rezultat.toString();
    }
}
