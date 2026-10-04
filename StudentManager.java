import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    private int nextId;

    public StudentManager() {
        students = new ArrayList<>();
        nextId = 1;
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

    public boolean isEmpty() {
        return students.isEmpty();
    }

    private boolean nameExists(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    private Student findById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void saveStudents() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {

            for (Student student : students) {

                writer.write(
                        student.getId()
                                + ";"
                                + student.getName()
                                + ";"
                                + student.getAge());

                writer.newLine();
            }

            System.out.println("Students saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving students.");
        }
    }

    public void loadStudents() {

        students.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {

            String line;
            int highestId = 0;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);

                students.add(new Student(id, name, age));

                if (id > highestId) {
                    highestId = id;
                }
            }

            nextId = highestId + 1;

            System.out.println("Students loaded successfully.");

        } catch (IOException e) {
            System.out.println("No save file found.");
        }
    }
}