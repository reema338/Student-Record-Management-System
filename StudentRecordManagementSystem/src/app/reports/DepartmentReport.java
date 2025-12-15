package app.reports;

import java.util.List;
import app.student.Student;

public class DepartmentReport extends Report {

    @Override
    public void generate(List<Student> students) {
        System.out.println("=== Department Report ===");
        students.stream()
                .sorted((s1, s2) -> s1.getDepartment()
                        .compareToIgnoreCase(s2.getDepartment()))
                .forEach(s ->
                        System.out.println(
                                s.getName() + " - " + s.getDepartment()));
    }
}

