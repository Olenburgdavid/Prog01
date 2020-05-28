import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("StudentC", 3.5, 2000),
                new Student("StudentA", 4.0, 2001),
                new Student("StudentD", 2.5, 1998),
                new Student("StudentB", 3.0, 2001)
        };

        CmpByName cmpByName = new CmpByName();
        Arrays.sort(students, cmpByName);

        for (Student e: students) {
            System.out.println(e);
        }

        System.out.println("---");

        Arrays.sort(students, new CmpByGpa());

        for (Student e: students) {
            System.out.println(e);
        }

        System.out.println("---");

        Arrays.sort(students,
                (o1, o2) -> Integer.compare(o1.year, o2.year));

        for (Student e: students) {
            System.out.println(e);
        }

    }
}

class CmpByName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class CmpByGpa implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.gpa, s2.gpa);
    }
}