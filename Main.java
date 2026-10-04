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
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    int age;

                    while (true) {
                        System.out.print("Age: ");

                        if (scanner.hasNextInt()) {
                            age = scanner.nextInt();
                            scanner.nextLine();

                            if (age >= 0) {
                                break;
                            }

                            System.out.println("Age cannot be negative.");
                        } else {
                            System.out.println("Age must be a number.");
                            scanner.nextLine();
                        }
                    }

                    students.add(new Student(name, age));
                    System.out.println("Student added.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nStudents:");

                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}