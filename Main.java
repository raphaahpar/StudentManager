import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        manager.loadStudents();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Student Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Show Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Save Students");
            System.out.println("6. Load Students");
            System.out.println("7. Exit");
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

                    if (manager.isEmpty()) {
                        System.out.println("No students found.");
                        break;
                    }

                    manager.showStudents();

                    System.out.print("Student ID: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Must be a number.");
                        scanner.nextLine();
                        continue;
                    }

                    int editId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();

                    int newAge;

                    while (true) {

                        System.out.print("New Age: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Age must be a number.");
                            scanner.nextLine();
                            continue;
                        }

                        newAge = scanner.nextInt();
                        scanner.nextLine();

                        if (newAge < 0) {
                            System.out.println("Age cannot be negative.");
                            continue;
                        }

                        break;
                    }

                    manager.updateStudent(editId, newName, newAge);
                    break;

                case 3:

                    manager.showStudents();
                    break;

                case 4:

                    if (manager.isEmpty()) {
                        System.out.println("No students found.");
                        break;
                    }

                    manager.showStudents();

                    System.out.print("Student ID to delete: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Must be a number.");
                        scanner.nextLine();
                        continue;
                    }

                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteStudent(deleteId);
                    break;

                case 5:

                    manager.saveStudents();
                    break;

                case 6:

                    manager.loadStudents();
                    break;

                case 7:

                    manager.saveStudents();

                    System.out.println("Goodbye.");
                    scanner.close();
                    return;
                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}