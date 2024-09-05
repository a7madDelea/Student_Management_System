import java.util.ArrayList;

public class Student {

    // Variables.
    private String name;
    private double grade;

    // Constroctor.
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Setters methods.

    // Set name method.
    public void setName(String name) {
        this.name = name;
    }

    // Set grade method.
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Getters methods.

    // Get name method.
    public String getName() {
        return this.name;
    }

    // Get grade.
    public double getGrade() {
        return this.grade;
    }

    // Display all students method.
    public static void displayStudents(ArrayList<Student> students) {
        System.out.println("---Display All Students---");
        if (students.isEmpty()) {
            System.out.println("No students have been added yet.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("\nStudent number " + (i + 1) + ":");
                System.out.println("Student name: " + students.get(i).name + "\nStudent grade: " + students.get(i).grade);
            }
        }
    }

    // Calculate the average grades.
    public static double getAvg(ArrayList<Student> students) {
        System.out.println("---Get AVG---");
        if (students.isEmpty()) {
            throw new IllegalStateException("Cannot calculate average - no grades available.");
        }
        double total = 0;
        for (int i = 0; i < students.size(); i++) {
            total += students.get(i).grade;
        }
        return total / students.size();
    }
}
