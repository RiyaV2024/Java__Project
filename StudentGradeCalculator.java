
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
}

class GradeCalculator {

    public int getTotal(int[] marks) {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    public double getPercentage(int total, int subjects) {
        return (double) total / (subjects * 100) * 100;
    }

    public String getGrade(double percentage) {
        if (percentage >= 90)
            return "A+";
        if (percentage >= 80)
            return "A";
        if (percentage >= 70)
            return "B";
        if (percentage >= 60)
            return "C";
        if (percentage >= 50)
            return "D";
        else
            return "Fail";
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeCalculator cal = new GradeCalculator();

        System.out.println("Enter Student name:");
        String name = sc.nextLine();

        System.out.println("Enter number of subjects:");
        int n = sc.nextInt();

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks of subject " + (i + 1) + ":");
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, marks);

        int total = cal.getTotal(student.marks);
        double percentage = cal.getPercentage(total, n);
        String grade = cal.getGrade(percentage);

        System.out.println("\nResult");
        System.out.println("Name: " + student.name);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }
}