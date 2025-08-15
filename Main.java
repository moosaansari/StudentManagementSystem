import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }

    public void displayInfo() {
        System.out.println("Name: " + name + "\tAge: " + age + "\tMarks: " + marks);
    }
}

class StudentManager {
    private Student[] students;
    private int count;

    public StudentManager(int size) {
        students = new Student[size];
        count = 0;
    }

    public void addStudent(String name, int age, double marks) {
        if (count < students.length) {
            students[count] = new Student(name, age, marks);
            count++;
            System.out.println("✅ Student added successfully!\n");
        } else {
            System.out.println("⚠ Student list is full!\n");
        }
    }

    public void viewStudents() {
        if (count == 0) {
            System.out.println("⚠ No students to display.\n");
        } else {
            System.out.println("\n--- Student List ---");
            for (int i = 0; i < count; i++) {
                students[i].displayInfo();
            }
            System.out.println();
        }
    }

    public void searchStudent(String name) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                System.out.println("\n✅ Student Found:");
                students[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Student not found.\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(5);

        while (true) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    manager.addStudent(name, age, marks);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    manager.searchStudent(searchName);
                    break;

                case 4:
                    System.out.println("🚪 Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice.\n");
            }
        }
    }
}
