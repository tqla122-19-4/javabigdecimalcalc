package com.company;
import java.math.BigDecimal;

public class Calculate {
    public static double calcExactValue(double x)
    {
        return  (1/2-Math.PI/4*Math.abs(Math.sin(x)));

    }
    public static double calcApproxValue(double x, int n)
    {
        double Sn = 0;
        for (int i = 1; i<=n; i++)
        {
            Sn +=Math.cos(x*2*i)/(4*Math.pow(i,2)-1);
        }
        return Sn;
    }
    public static double calcApproxValue(double x, double e)
    {
        double Se = 0;
        int i = 1;
        while (Math.abs(Se) <= e)
        {
            Se += Math.cos(x*2*i)/(4*Math.pow(i,2)-1);
        }
        return Se;
    }

    public static BigDecimal calcExactValue(BigDecimal x)
    {
        BigDecimal y = BigDecimal.valueOf(1/2-Math.PI/4*Math.abs(Math.sin(x.doubleValue())));
        return y;
    }

    public static BigDecimal calcApproxValue(BigDecimal x, int n)
    {
        BigDecimal Sn = BigDecimal.valueOf(0);
        for (int i = 1; i<=n; i++)
        {
            Sn = Sn.add(BigDecimal.valueOf(Math.cos(2*x.doubleValue())/(4*Math.pow(i,2)-1)));
        }
        return Sn;
    }

    public static BigDecimal calcApproxValue(BigDecimal x, double e)
    {
        BigDecimal Se = BigDecimal.valueOf(0);
        int i = 1;
        while (Se.abs().signum() <= e)
        {
            Se = Se.add(BigDecimal.valueOf(Math.cos(2*x.doubleValue())/(4*Math.pow(i,2)-1)));
        }
        return Se;
    }
}