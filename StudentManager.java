import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int age) {
        students.add(new Student(name, age));
        System.out.println("Student added successfully.");
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudents:");

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public void deleteStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void updateStudent(int studentIndex, int newAge) {

        if (studentIndex < 1 || studentIndex > students.size()) {
            System.out.println("Student not found.");
            return;
        }

        if (newAge < 0) {
            System.out.println("Age cannot be negative.");
            return;
        }

        students.get(studentIndex - 1).setAge(newAge);
        System.out.println("Student updated successfully.");
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }
}