package src.main.java.util;

import java.util.Scanner;

public class InputHelper {

    public static int readInt(
            Scanner scanner,
            String prompt) {

        while (true) {

            System.out.print(prompt);

            if (!scanner.hasNextInt()) {

                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int number = scanner.nextInt();
            scanner.nextLine();

            return number;
        }
    }

    public static int readPositiveAge(
            Scanner scanner,
            String prompt) {

        while (true) {

            System.out.print(prompt);

            if (!scanner.hasNextInt()) {

                System.out.println("Age must be a number.");
                scanner.nextLine();
                continue;
            }

            int age = scanner.nextInt();
            scanner.nextLine();

            if (age < 0) {

                System.out.println("Age cannot be negative.");
                continue;
            }

            return age;
        }
    }

    public static String readString(
            Scanner scanner,
            String prompt) {

        System.out.print(prompt);
        return scanner.nextLine();
    }
}