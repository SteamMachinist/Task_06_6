package ru.vsu.cs.roschupkin_ya_a;

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        double x = readDoubleParameter("variable x");
        int numberOfTerms = readNumberOfTerms();
        double epsilon = Math.abs(readDoubleParameter("epsilon e"));

        double[] results =
                {
                calculateSumOfNTerms(numberOfTerms, x),
                calculateSumOfTermsLargerThanEpsilon(epsilon, x),
                calculateSumOfTermsLargerThanEpsilon(epsilon / 10, x),
                calculateInitialFunction(x)
                };

        printResults(numberOfTerms, epsilon, results);
    }

    static double readDoubleParameter(String parameterName)
    {
        System.out.printf("Input %s: ", parameterName);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    static int readNumberOfTerms()
    {
        System.out.print("Input number of terms n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1)
        {
            System.out.println("Number of terms must be whole number greater than 0");
            readNumberOfTerms();
        }

        return n;
    }

    static void printResults(int numberOfTerms, double epsilon, double[] results)
    {
        System.out.printf("%nSum of %d terms is %f" +
                "%nSum of terms less than epsilon: %f is %f" +
                "%nSum of terms less than epsilon/10: %f is %f" +
                "%nResult of function is %f",
                numberOfTerms, results[0], epsilon, results[1], epsilon / 10, results[2], results[3]);
    }

    static double calculateSumOfNTerms(int numberOfTerms, double x)
    {
        double sum = 0;

        for (int termNumber = 0; termNumber < numberOfTerms; termNumber++)
        {
            sum = sum + calculateSequenceTerm(termNumber, x);
        }
        return sum;
    }

    static double calculateSequenceTerm(int termNumber, double x)
    {
        double dividend = Math.pow(-1, termNumber) * Math.pow(x, termNumber * 2);

        long divider = calculateFactorial(termNumber * 2 + 1);

        return dividend / divider;
    }

    static long calculateFactorial(int number)
    {
        long factorial = 1;

        for (int i = 1; i <= number; i++)
        {
            factorial = factorial * i;
        }
        return factorial;
    }

    static double calculateSumOfTermsLargerThanEpsilon(double epsilon, double x)
    {
        double sum = 0;
        double sequenceTerm = 1;

        for (int termNumber = 1; Math.abs(sequenceTerm) > epsilon; termNumber++)
        {
            sum = sum + sequenceTerm;
            sequenceTerm = calculateSequenceTerm(termNumber, x);
        }

        return sum;
    }

    static double calculateInitialFunction(double x)
    {
        return Math.sin(x) / x;
    }
}
