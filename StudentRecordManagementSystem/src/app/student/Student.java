package app.student;

public class Student {

    private String id;
    private String name;
    private String department;
    private double gpa;

    public Student(String id, String name, String department, double gpa) {
        if (gpa < 0 || gpa > 5) {
            throw new IllegalArgumentException("GPA must be between 0 and 5");
        }
        this.id = id;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 5) {
            throw new IllegalArgumentException("Invalid GPA");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + gpa;
    }
}