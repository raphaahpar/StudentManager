package src;

import java.util.Scanner;

import src.service.StudentManager;
import src.util.InputHelper;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

            int choice = InputHelper.readInt(
                    scanner,
                    "Choose an option: ");

            switch (choice) {

                case 1:
                    addStudent(scanner, manager);
                    break;

                case 2:
                    editStudent(scanner, manager);
                    break;

                case 3:
                    showStudents(scanner, manager);
                    break;

                case 4:
                    deleteStudent(scanner, manager);
                    break;

                case 5:
                    searchStudent(scanner, manager);
                    break;

                case 6:
                    manager.showStatistics();
                    break;

                case 7:
                    manager.save();
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {

        System.out.println("\n=== Student Manager ===");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student");
        System.out.println("3. Show Students");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Statistics");
        System.out.println("7. Exit");
    }

    private static void addStudent(
            Scanner scanner,
            StudentManager manager) {

        String name = InputHelper.readString(
                scanner,
                "Name: ");

        int age = InputHelper.readPositiveAge(
                scanner,
                "Age: ");

        manager.addStudent(name, age);
    }

    private static void editStudent(
            Scanner scanner,
            StudentManager manager) {

        if (manager.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        manager.showStudents();

        int editId = InputHelper.readInt(
                scanner,
                "Student ID: ");

        String newName = InputHelper.readString(
                scanner,
                "New Name: ");

        int newAge = InputHelper.readPositiveAge(
                scanner,
                "New Age: ");

        manager.updateStudent(
                editId,
                newName,
                newAge);
    }

    private static void showStudents(
            Scanner scanner,
            StudentManager manager) {

        manager.showStudents();

        if (manager.isEmpty()) {
            return;
        }

        while (true) {

            System.out.println("\n1. Sort by Name");
            System.out.println("2. Sort by Age");
            System.out.println("3. Back");

            int sortChoice = InputHelper.readInt(
                    scanner,
                    "Choose an option: ");

            switch (sortChoice) {

                case 1:
                    manager.sortByName();
                    manager.showStudents();
                    break;

                case 2:
                    manager.sortByAge();
                    manager.showStudents();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void deleteStudent(
            Scanner scanner,
            StudentManager manager) {

        if (manager.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        manager.showStudents();

        int deleteId = InputHelper.readInt(
                scanner,
                "Student ID to delete: ");

        manager.deleteStudent(deleteId);
    }

    private static void searchStudent(
            Scanner scanner,
            StudentManager manager) {

        String searchText = InputHelper.readString(
                scanner,
                "Search: ");

        manager.searchStudent(searchText);
    }
}