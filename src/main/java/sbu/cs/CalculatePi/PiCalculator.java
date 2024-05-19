package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PiCalculator {

    public String calculate(int floatingPoint) {
        MathContext mc = new MathContext(floatingPoint + 10, RoundingMode.HALF_UP);
        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(2).sqrt(mc), mc);
        BigDecimal t = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(4), mc);
        BigDecimal p = BigDecimal.valueOf(1);

        for (int i = 0; i < floatingPoint * 10; i++) {
            BigDecimal an = (a.add(b, mc)).divide(BigDecimal.valueOf(2), mc);
            BigDecimal b2 = (a.multiply(b, mc)).sqrt(mc);
            BigDecimal tn = t.subtract(p.multiply(BigDecimal.valueOf((a.subtract(an, mc)).pow(2)), mc), mc);
            BigDecimal pn = p.multiply(BigDecimal.valueOf(2), mc);

            a = an;
            b = b2;
            t = tn;
            p = pn;
        }

        return (a.add(b, mc)).pow(2).divide(t, mc).toString();
    }

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        System.out.println(piCalculator.calculate(2));
        System.out.println(piCalculator.calculate(7));
        System.out.println(piCalculator.calculate(100));
        System.out.println(piCalculator.calculate(1000));
    }
}