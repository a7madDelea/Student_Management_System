import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // Static object.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Students array
        ArrayList<Student> students = new ArrayList<>();

        // Run System
        System.out.println("--- Student Management System ---");

        while (true) {
            System.out.println("\n1. Add a new student");
            System.out.println("2. Display all students and their grades");
            System.out.println("3. Calculate the average grade");
            System.out.println("4. Delete a student.");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        addNewStudent(students);
                        break;
                    case 2:
                        Student.displayStudents(students);
                        break;
                    case 3:
                        try {
                            double avg = Student.getAvg(students);
                            System.out.printf("Average Grade: %.2f%n", avg);
                        } catch (Exception e) {
                            System.out.println("Add some students first.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        deleteStudent(name, students);
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Not a valid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: The option must be a number.");
                scanner.nextLine();
            }

        }
    }

    // Add new student method
    public static void addNewStudent(ArrayList<Student> students) {

        System.out.println("---Add New Student---");
        try {

            // Request name.
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            // Request grade.
            System.out.print("Enter student grade: ");
            double grade = scanner.nextDouble();

            // Add new Student.
            Student student = new Student(name, grade);
            students.add(student);

        } catch (InputMismatchException e) {
            System.out.println("Error: The grade must be a number.");
            scanner.nextLine();
        }
    }

    // Delete student method.
    public static void deleteStudent(String name, ArrayList<Student> students) {

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                students.remove(student);
                System.out.println("Delete student success!.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!.");
        }
    }

}
