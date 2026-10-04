import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Student Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    int age;
                    while (true) {
                        System.out.print("Age: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Age must be a number.");
                            scanner.nextLine();
                            continue;
                        }

                        age = scanner.nextInt();
                        scanner.nextLine();

                        if (age < 0) {
                            System.out.println("Age cannot be negative.");
                            continue;
                        }

                        break;
                    }

                    students.add(new Student(name, age));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nStudents:");

                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                        break;
                    }

                    System.out.print("Name of student to delete: ");
                    String nameToDelete = scanner.nextLine();

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getName().equalsIgnoreCase(nameToDelete)) {
                            students.remove(i);
                            deleted = true;
                            break;
                        }
                    }

                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}