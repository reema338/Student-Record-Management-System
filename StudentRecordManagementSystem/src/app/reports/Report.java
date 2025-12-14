package app.reports;

import java.util.List;
import app.student.Student;

public abstract class Report {
    public abstract void generate(List<Student> students);
}

