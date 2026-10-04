package src.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.model.Student;

public class FileManager {

    public static void saveStudents(ArrayList<Student> students) {

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

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);

                students.add(new Student(id, name, age));
            }

        } catch (IOException e) {
            System.out.println("No save file found.");
        }

        return students;
    }
}