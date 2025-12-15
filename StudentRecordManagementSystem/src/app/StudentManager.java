package app.student;

import java.util.*;
import java.io.*;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

   
    public void addStudent(Student student) {
        students.add(student);
    }

  
    public void removeStudent(String id) {
        students.removeIf(s -> s.getId().equals(id));
    }

   
    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

   
    public List<Student> getStudents() {
        return students;
    }

  
    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        }
    }

   
    public void loadFromFile(String fileName) throws IOException {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                );
                students.add(s);
            }
        }
    }
}
