import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Student names
        ArrayList<String> names = new ArrayList<>();
        // Student grades
        ArrayList<Double> grades = new ArrayList<>();
        // Run System
        System.out.println("--- Student Management System ---");

        while (true) {
            System.out.println("\n1. Add a new student");
            System.out.println("2. Display all students and their grades");
            System.out.println("3. Calculate the average grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addNewStudent(names, grades);
                    break;
                case 2:
                    displayStudents(names, grades);
                    break;
                case 3:
                    try {
                        double avg = getAvg(grades);
                        System.out.printf("Average Grade: %.2f%n", avg);
                    } catch (Exception e) {
                        System.out.println("Add some students first.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Not a valid option. Please try again.");
                    break;
            }
        }
    }

    // Add new student method
    public static void addNewStudent(ArrayList<String> names, ArrayList<Double> grades) {
        System.out.println("---Add New Student---");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student grade: ");
            double grade = scanner.nextDouble();

            names.add(name);
            grades.add(grade);

        } catch (InputMismatchException e) {
            System.out.println("Error: The grade must be a number.");
            scanner.nextLine();
        }
    }

    // Display all students method
    public static void displayStudents(ArrayList<String> names, ArrayList<Double> grades) {
        System.out.println("---Display All Students---");
        if (names.isEmpty()) {
            System.out.println("No students have been added yet.");
        } else {
            for (int i = 0; i < names.size(); i++) {
                System.out.println("\nStudent number " + (i + 1) + ":");
                System.out.println("Student name: " + names.get(i) + "\nStudent grade: " + grades.get(i));
            }
        }
    }

    // Calculate the average grade
    public static double getAvg(ArrayList<Double> grades) {
        System.out.println("---Get AVG---");
        if (grades.isEmpty()) {
            throw new IllegalStateException("Cannot calculate average - no grades available.");
        }
        double total = 0;
        for (Double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }
}
