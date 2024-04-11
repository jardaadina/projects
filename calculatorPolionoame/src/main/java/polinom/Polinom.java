package polinom;

import javax.management.StringValueExp;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom
{
    private Map<Integer, Double> monoame;

    public Polinom() {
        this.monoame = new HashMap<>();
    }

    public Polinom(String polinomString)
    {
        this.monoame = new HashMap<>();
        construirePolinom(polinomString);
    }

    private void construirePolinom(String polinomString) {
        Pattern pattern = Pattern.compile("([+-]?\\d*)\\*?(x)?\\^?(\\d*)");
        Matcher matcher = pattern.matcher(polinomString);

        while (matcher.find()){
            String coeficient = matcher.group(1);
            String x = matcher.group(2);
            String exponent = matcher.group(3);

            if (coeficient.isEmpty() && x == null && exponent.isEmpty())
                break;

            if (x != null && exponent.isEmpty())
                exponent = "1";

            if (x == null && exponent.isEmpty())
                exponent = "0";

            if (coeficient.isEmpty() || coeficient.equals("+"))
                coeficient = "1";

            if (coeficient.equals("-"))
                coeficient = "-1";

            this.addMonomInMap(Integer.parseInt(exponent), Double.parseDouble(coeficient));
        }
    }

    private void addMonomInMap(int exponent, double coefficient) {
        if (exponent == 0)
        {
            monoame.put(0, coefficient);
        }
        else
        {
            monoame.merge(exponent, coefficient, Double::sum);
        }
    }
    public Map<Integer, Double> getMonoame()
    {
        return monoame;
    }

    @Override
    public String toString() {
        StringBuilder polinomCreat = new StringBuilder();
        TreeMap<Integer, Double> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(monoame);
        if(monoame.isEmpty())
        {
            polinomCreat= new StringBuilder(String.valueOf(0));
        }
        else {
            boolean termenDeGrad0Adaugat = false;

            for (Map.Entry<Integer, Double> entry : treeMap.entrySet()){
                int exponent = entry.getKey();
                double coeficient = entry.getValue();

                if (coeficient != 0)
                {
                    if ((!polinomCreat.isEmpty()) && coeficient > 0)
                        polinomCreat.append("+");

                    if (exponent == 0)
                    {
                        polinomCreat.append(coeficient);
                        termenDeGrad0Adaugat = true;
                    } else {
                        if (coeficient == -1) {
                            polinomCreat.append("-x");
                        } else if (coeficient != 1) {
                            polinomCreat.append(coeficient).append("*x");
                        } else {
                            polinomCreat.append("x");
                        }
                        if (exponent != 1) {
                            polinomCreat.append("^").append(exponent);
                        }
                    }
                }
            }
            if (!termenDeGrad0Adaugat) {
                Double coeficientGrad0 = treeMap.get(0);
                if (coeficientGrad0 != null && coeficientGrad0 != 0) {
                    if (!polinomCreat.isEmpty()) {
                        polinomCreat.append("+");
                    }
                    polinomCreat.append(coeficientGrad0);
                }
            }}
        return polinomCreat.toString();
    }
}

