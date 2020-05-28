import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	 int [] numbers = {4, 1, 9, 2, 4, 6, 8, 1, 0};
        Arrays.sort(numbers);
        for (int number: numbers){
            System.out.print(number + " ");
        }
        System.out.println();

        String [] words = {"C#", "Java", "Kotlin", "C", "Scala", "C++" };
        Arrays.sort(words);
        for (String word : words){
            System.out.print(word + " ");
        }
        System.out.println();
        BigInteger[] bigIntegers = {
                new BigInteger("1"),
                new BigInteger("67"),
                new BigInteger("42"),
                new BigInteger("-10")};

        Arrays.sort(bigIntegers);
        for (BigInteger bigInteger: bigIntegers){
            System.out.print(bigIntegers + " ");

        }
        System.out.println();

        Rational[] rationals = {new Rational(1,2 ), new Rational(1, 3), new Rational(2, 3)};
        Arrays.sort(rationals);

        for (Rational rational: rationals){
            System.out.print(rationals + " ");
        }
        System.out.println();

        Student[] students = {
                new Student("Bob", 2.7f,1991),
                new Student("Alice", 4.0f, 1990),
                new Student("Eve", 3.8f, 1988)};

        Arrays.sort(students, new CompareByName());
        for (Student student: students){
            System.out.print(students + " ");
        }
        System.out.println();
        Arrays.sort(students, new CompareByGPA());

        for (Student student: students){
            System.out.print(students + " ");
        }
        System.out.println();

        Arrays.sort(students, (first, second)->Integer.compare(first.getYear(),second.getYear()));

        for (Student student: students){
            System.out.print(student + " ");
        }
        System.out.println();

    }
}
