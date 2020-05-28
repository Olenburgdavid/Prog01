import java.util.Comparator;

class CompareByName implements Comparator<Student>{
    public int compare(Student first, Student second){
        return first.getName().compareTo(second.getName());
    }
}
class CompareByGPA implements Comparator<Student>{
    public int compare(Student first, Student second){
        return Float.compare(first.getGpa(),second.getGpa());
    }
}

public class Student {
    private String name;
    private float gpa;
    private int year;

    public Student(String name, float gpa, int year){
        this.name = name;
        this.gpa = gpa;
        this.year = year;

    }

    public String getName() {
        return name;
    }


    public float getGpa() {
        return gpa;
    }

    public int getYear() {
        return year;
    }
    public String toString(){
        return String.format("Student(%s, %1f, %d", name, gpa, year);
    }
}
