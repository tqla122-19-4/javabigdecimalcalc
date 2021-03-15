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
        System.out.println("Хотите использовать следующие данны?");
        System.out.println(" Нижняя граница а = 0,1 \n Верхня граница b = 1 \n Количество шагов k = 10 \n Количество элементов ряда n = 10 \n Допустимая погрешность e = 0,0001");
        System.out.println("Ввести с клавиатуры новые? \ny/n");
        String input = scanner.nextLine();
        if (input.equals('y'))
        {
            System.out.println("Введите нижнюю границу");
            a = scanner.nextDouble();
            System.out.println("Введите верхнюю границу");
            b = scanner.nextDouble();
            System.out.println("Введите количество шагов");
            k = scanner.nextDouble();
            System.out.println("Введите количество элементов ряда n");
            n = scanner.nextInt();
            System.out.println("Введите допустимую погрешность");
            e = scanner.nextDouble();
        }
        else
        {
            a = 0.1;
            b = 1;
            k = 10;
            n = 10;
            e = 0.0001;
        }
        BigDecimal DecimalX, DecimalK, DecimalA, DecimalB, DecimalY, DecimalE, DecimalApprox;
        DecimalA = BigDecimal.valueOf(a);
        DecimalB = BigDecimal.valueOf(b);
        DecimalK = BigDecimal.valueOf(k);
        BigDecimal DecimalStep = DecimalB.subtract(DecimalA).divide(DecimalK,100,   RoundingMode.CEILING);
        double step = (b - a) / k;
        System.out.println("Тип данных double:");
        for (x = a; x <= b; x += step) {
            System.out.println("x = " + x);
            y = Calculate.calcExactValue(x);
            System.out.println("y = " + y);
            ApproxValue = Calculate.calcApproxValue(x, n);
            System.out.println("Sn = " + ApproxValue);
            E = (y - ApproxValue) / y;
            System.out.println("Относительная погрешность = " + E);
            ApproxValue = Calculate.calcApproxValue(x, e);
            System.out.println("Se = " + ApproxValue);
            E = (y - ApproxValue) / y;
            System.out.println("Относительная погрешность = " + E);
        }
        System.out.println("Тип данных BigDecimal:");
        for (DecimalX=DecimalA; DecimalX.compareTo(DecimalB) != 0; DecimalX = DecimalX.add(DecimalStep))
        {
            System.out.println("x = " + DecimalX);
            DecimalY = Calculate.calcExactValue(DecimalX);
            System.out.println("y = " + DecimalY);
            DecimalApprox = Calculate.calcApproxValue(DecimalX, n);
            System.out.println("Sn = " + DecimalApprox);
            DecimalE = DecimalY.subtract(DecimalApprox).divide(DecimalY, 100, RoundingMode.CEILING);
            System.out.println("Относительная погрешность = " + DecimalE);
            DecimalApprox = Calculate.calcApproxValue(DecimalX, e);
            System.out.println("Se = " + DecimalApprox);
            DecimalE = DecimalY.subtract(DecimalApprox).divide(DecimalY, 100,  RoundingMode.CEILING);
            System.out.println("Относительная погрешность = " + DecimalE);
        }
    }
}