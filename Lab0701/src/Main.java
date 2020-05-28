import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        int[] a = {5, 1, 8, 6, 3, 9, 2};

        Arrays.sort(a);

        for (int e: a) {
            System.out.print(" " + e);
        }
        System.out.println();

        String[] a2 = {"Java", "C", "Scala", "Kotlin", "C++", "C#"};

        Arrays.sort(a2);

        for (String e: a2) {
            System.out.print(" " + e);
        }
        System.out.println();

        BigInteger[] a3 = {
                new BigInteger("32"),
                new BigInteger("24"),
                new BigInteger("50")
        };

        Arrays.sort(a3);

        for (BigInteger e: a3) {
            System.out.print(" " + e);
        }
        System.out.println();

        Rational[] a4 = {
                Rational.parse("1/2"),
                Rational.parse("1/3"),
                Rational.parse("7/2"),
                Rational.parse("5/7"),
                Rational.parse("2/3")
        };

        Arrays.sort(a4);

        for (Rational e: a4) {
            System.out.print(" " + e);
        }
        System.out.println();
    }
}