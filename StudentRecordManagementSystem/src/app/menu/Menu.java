package app.menu;

import java.util.Scanner;
import app.student.*;
import app.reports.*;

public class Menu {

    private final StudentManager manager;
    private final Scanner scanner;

    public Menu(StudentManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            printMenu();
            choice = getIntInput("Choose option: ");

            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        findStudent();
                        break;
                    case 4:
                        showGPAReport();
                        break;
                    case 5:
                        showDepartmentReport();
                        break;
                    case 6:
                        saveToFile();
                        break;
                    case 7:
                        loadFromFile();
                        break;
                    case 0:
                        System.out.println("Exiting system...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\n=== Student Record Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Find Student");
        System.out.println("4. Generate GPA Report");
        System.out.println("5. Generate Department Report");
        System.out.println("6. Save to File");
        System.out.println("7. Load from File");
        System.out.println("0. Exit");
    }

    private void addStudent() {
        System.out.print("ID: ");
        String id = scanner.next();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Department: ");
        String dept = scanner.next();

        double gpa = getDoubleInput("GPA: ");

        manager.addStudent(new Student(id, name, dept, gpa));
        System.out.println("Student added successfully.");
    }

    private void removeStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        manager.removeStudent(id);
        System.out.println("Student removed (if existed).");
    }

    private void findStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        Student s = manager.findStudent(id);

        if (s == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(
                    s.getId() + " - " +
                    s.getName() + " - " +
                    s.getDepartment() + " - GPA: " +
                    s.getGpa());
        }
    }

    private void showGPAReport() {
        Report report = new GPAReport();
        report.generate(manager.getStudents());
    }

    private void showDepartmentReport() {
        Report report = new DepartmentReport();
        report.generate(manager.getStudents());
    }

    private void saveToFile() throws Exception {
        System.out.print("File name: ");
        String file = scanner.next();
        manager.saveToFile(file);
        System.out.println("Data saved successfully.");
    }

    private void loadFromFile() throws Exception {
        System.out.print("File name: ");
        String file = scanner.next();
        manager.loadFromFile(file);
        System.out.println("Data loaded successfully.");
    }

    private int getIntInput(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }

    private double getDoubleInput(String msg) {
        System.out.print(msg);
        return scanner.nextDouble();
    }
}
