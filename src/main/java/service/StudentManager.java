package src.main.java.service;

import java.util.ArrayList;
import java.util.Comparator;

import src.main.java.model.Student;
import src.main.java.util.FileManager;

public class StudentManager {

    private ArrayList<Student> students;
    private int nextId;

    public StudentManager() {

        students = FileManager.loadStudents();

        nextId = 1;

        for (Student student : students) {

            if (student.getId() >= nextId) {
                nextId = student.getId() + 1;
            }
        }
    }

    public void save() {
        FileManager.saveStudents(students);
    }

    public void addStudent(String name, int age) {

        if (nameExists(name)) {
            System.out.println("Student name already exists.");
            return;
        }

        students.add(new Student(nextId++, name, age));

        System.out.println("Student added successfully.");
    }

    public void showStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudents:");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void updateStudent(int id, String newName, int newAge) {

        Student student = findById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if (newAge < 0) {
            System.out.println("Age cannot be negative.");
            return;
        }

        for (Student otherStudent : students) {

            if (otherStudent.getId() != id
                    && otherStudent.getName().equalsIgnoreCase(newName)) {

                System.out.println("Student name already exists.");
                return;
            }
        }

        student.setName(newName);
        student.setAge(newAge);

        System.out.println("Student updated successfully.");
    }

    public void searchStudent(String searchText) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName()
                    .toLowerCase()
                    .contains(searchText.toLowerCase())) {

                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching students found.");
        }
    }

    public void sortByName() {

        students.sort(
                Comparator.comparing(
                        Student::getName,
                        String.CASE_INSENSITIVE_ORDER));

        System.out.println("Students sorted by name.");
    }

    public void sortByAge() {

        students.sort(
                Comparator.comparingInt(Student::getAge));

        System.out.println("Students sorted by age.");
    }

    public void showStatistics() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        int totalAge = 0;

        Student youngest = students.get(0);
        Student oldest = students.get(0);

        for (Student student : students) {

            totalAge += student.getAge();

            if (student.getAge() < youngest.getAge()) {
                youngest = student;
            }

            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }

        double averageAge = (double) totalAge / students.size();

        System.out.println("\n=== Statistics ===");
        System.out.println("Total students: " + students.size());
        System.out.printf("Average age: %.2f%n", averageAge);

        System.out.println("Youngest student: "
                + youngest.getName()
                + " (" + youngest.getAge() + ")");

        System.out.println("Oldest student: "
                + oldest.getName()
                + " (" + oldest.getAge() + ")");
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    private Student findById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    private boolean nameExists(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }
}