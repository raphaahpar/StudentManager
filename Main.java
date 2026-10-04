import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Raphael", 22));
        students.add(new Student("Anna", 20));
        students.add(new Student("Max", 24));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}