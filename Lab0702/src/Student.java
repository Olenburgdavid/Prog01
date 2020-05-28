class Student {
    String name;
    double gpa;
    int year;

    public Student(String aName, double aGpa, int aYear) {
        name = aName;
        gpa = aGpa;
        year = aYear;
    }

    @Override
    public String toString() {
        return String.format("Student(%s %.4f %d)", name, gpa, year);
    }
}