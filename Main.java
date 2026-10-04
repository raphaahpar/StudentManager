import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
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

                    manager.addStudent(name, age);
                    break;

                case 2:
                    manager.showStudents();
                    break;

                case 3:
                    if (manager.isEmpty()) {
                        System.out.println("No students found.");
                        break;
                    }

                    System.out.print("Name of student to delete: ");
                    String studentName = scanner.nextLine();

                    manager.deleteStudent(studentName);
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