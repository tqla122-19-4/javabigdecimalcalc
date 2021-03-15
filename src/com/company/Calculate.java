package com.company;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate {
    public static double calcExactValue(double x)
    {
        return  Math.cos(x);

    }
    public static double calcApproxValue(double x, int n)
    {
        double Sn = 0;
        for (int i = 1; i<=n; i++)
        {
            Sn += Math.pow(-1, i) * (Math.pow(x,2*i)/2*i);
        }
        return Sn;
    }
    public static double calcApproxValue(double x, double e)
    {

        double Se = 0;
        int i = 1;
        while (Math.abs(Se) <= e)
        {
            Se += Math.pow(-1, i) * (Math.pow(x,2*i)/2*i);
        }
        return Se;
    }

    public static BigDecimal calcExactValue(BigDecimal x)
    {
        BigDecimal y = BigDecimal.valueOf(Math.cos(x.doubleValue()));
        return y;
    }

    public static BigDecimal calcApproxValue(BigDecimal x, int n)
    {
        BigDecimal Sn = BigDecimal.valueOf(0);
        for (int i = 1; i<=n; i++)
        {
            BigDecimal pow_1 = BigDecimal.valueOf(-1);
            pow_1 = pow_1.pow(i);
            Sn = Sn.add(x.pow(2*i).divide(BigDecimal.valueOf(2*i), 100, RoundingMode.CEILING).multiply(pow_1));
        }
        return Sn;
    }

    public static BigDecimal calcApproxValue(BigDecimal x, double e)
    {
        BigDecimal Se = BigDecimal.valueOf(0);
        int i = 1;
        while (Se.abs().signum() <= e)
        {
            BigDecimal pow_1 = BigDecimal.valueOf(-1);
            pow_1 = pow_1.pow(i);
            Se = Se.add(x.pow(2*i).divide(BigDecimal.valueOf(2*i), 100, RoundingMode.CEILING).multiply(pow_1));
        }
        return Se;
    }
}
