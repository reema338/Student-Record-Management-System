
package app.reports;

import java.util.List;
import app.student.Student;

public class GPAReport extends Report {

    @Override
    public void generate(List<Student> students) {
        System.out.println("=== GPA Report ===");
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .forEach(s ->
                        System.out.println(
                                s.getId() + " - " + s.getName() +
                                " | GPA: " + s.getGpa()));
    }
}
