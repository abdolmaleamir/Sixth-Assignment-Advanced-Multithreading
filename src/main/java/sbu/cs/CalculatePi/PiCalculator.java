package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class PiCalculator {

    // FieldCalculator class calculates the contribution of a single term to the summation
    // that is used to approximate Pi.
    public static class FieldCalculator implements Runnable {
        BigDecimal x;
        int n;
        MathContext y;

        public FieldCalculator(int n) {
            y = new MathContext(1001);
            this.n = n;
        }

        public void run() {
            x = new BigDecimal("0.0625");
            x = x.pow(n, y);

            // Calculate the value of aSum using the formula for the nth term of the
            // Leibniz formula for Pi.
            BigDecimal eightK = new BigDecimal(n * 8);
            BigDecimal a1 = new BigDecimal("4");
            a1 = a1.divide(eightK.add(new BigDecimal("1")), y);
            BigDecimal a2 = new BigDecimal("-2");
            a2 = a2.divide(eightK.add(new BigDecimal("4")), y);
            BigDecimal a3 = new BigDecimal("-1");
            a3 = a3.divide(eightK.add(new BigDecimal("5")), y);
            BigDecimal a4 = new BigDecimal("-1");
            a4 = a4.divide(eightK.add(new BigDecimal("6")), y);
            BigDecimal aSum = a1.add(a2, y).add(a3, y).add(a4, y);
            x = x.multiply(aSum, y);

            // Add the calculated value to the running total.
            addTouSum(x);
        }

    }

    // Add the calculated value to the running total.
    public static synchronized void addTouSum(BigDecimal value) {
        sigma = sigma.add(value);
    }

    public String calculate(int floatingPoint) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        sigma = new BigDecimal(0);
        for (int i = 0; i < 1000; i++) {
            FieldCalculator task = new FieldCalculator(i);
            threadPool.execute(task);
        }

        threadPool.shutdown();

        System.out.println(sigma);

        try {
            threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sigma.toString().substring(0, 2 + floatingPoint);
    }

    public static BigDecimal sigma;

    public static void main(String[] args) {

    }
}