package com.company;
import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main
{

    public static void main(String[] args)
    {
        double x, k, a, b, y, e, E, ApproxValue;
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to use standard data?\n1 - enter new data from the keyboard\n2 - to use this data:\nBottom bound а = 0,1 \nUpper bound b = 0.8\nNumber of steps k = 10\nNumber of elements in a row n = 50\nAllowable error e = 0,0001 ");
        int choice = scanner.nextInt();
        if (choice==1)
        {
            System.out.println("Enter the Bottom bound:");
            a = scanner.nextDouble();
            System.out.println("Enter the Upper bound:");
            b = scanner.nextDouble();
            System.out.println("Enter the Number of steps:");
            k = scanner.nextDouble();
            System.out.println("Enter the Number of elements in a row:");
            n = scanner.nextInt();
            System.out.println("Enter the Allowable error:");
            e = scanner.nextDouble();


        }
        else
        {
            a = 0.1;
            b = 0.8;
            k = 10;
            n = 50;
            e = 0.0001;
        }
        BigDecimal DecimalX, DecimalK, DecimalA, DecimalB, DecimalY, DecimalE, DecimalApprox;
        DecimalA = BigDecimal.valueOf(a);
        DecimalB = BigDecimal.valueOf(b);
        DecimalK = BigDecimal.valueOf(k);
        BigDecimal DecimalStep = DecimalB.subtract(DecimalA).divide(DecimalK,100,   RoundingMode.CEILING);
        double step = (b - a) / k;
        System.out.println("double:");
        for (x = a; x <= b; x += step) {
            System.out.println("x = " + x);
            y = Calculate.calcExactValue(x);
            System.out.println("y = " + y);
            ApproxValue = Calculate.calcApproxValue(x, n);
            System.out.println("Sn = " + ApproxValue);
            E = (y - ApproxValue) / y;
            System.out.println("Allowable error = " + E);
            ApproxValue = Calculate.calcApproxValue(x, e);
            System.out.println("Se = " + ApproxValue);
            E = (y - ApproxValue) / y;
            System.out.println("Allowable error = " + E);
        }
        System.out.println("BigDecimal:");
        for (DecimalX=DecimalA; DecimalX.compareTo(DecimalB) != 0; DecimalX = DecimalX.add(DecimalStep))
        {
            System.out.println("x = " + DecimalX);
            DecimalY = Calculate.calcExactValue(DecimalX);
            System.out.println("y = " + DecimalY);
            DecimalApprox = Calculate.calcApproxValue(DecimalX, n);
            System.out.println("Sn = " + DecimalApprox);
            DecimalE = DecimalY.subtract(DecimalApprox).divide(DecimalY, 100, RoundingMode.CEILING);
            System.out.println("Allowable error = " + DecimalE);
            DecimalApprox = Calculate.calcApproxValue(DecimalX, e);
            System.out.println("Se = " + DecimalApprox);
            DecimalE = DecimalY.subtract(DecimalApprox).divide(DecimalY, 100,  RoundingMode.CEILING);
            System.out.println("Allowable error = " + DecimalE);
        }
    }
}