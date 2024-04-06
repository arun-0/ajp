import java.sql.*;
import java.util.Scanner;

public class StudentInformationSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ajp";
    private static final String USER = "ajp";
    private static final String PASS = "ajp";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            createTable(conn);
            boolean running = true;
            while (running) {
                displayMenu();
                int choice = getUserChoice();
                switch (choice) {
                    case 1:
                        insertStudent(conn);
                        break;
                    case 2:
                        updateStudent(conn);
                        break;
                    case 3:
                        deleteStudent(conn);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("Student Information System");
        System.out.println("1. Insert Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }
        return choice;
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                   + "studentId INT PRIMARY KEY AUTO_INCREMENT,"
                   + "name VARCHAR(50),"
                   + "age INT,"
                   + "grade VARCHAR(10)"
                   + ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully, OR it already exists.");
        }
    }

    private static void insertStudent(Connection conn) throws SQLException {
        System.out.println("Enter student details:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Grade: ");
        String grade = scanner.nextLine();

        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student inserted successfully.");
            } else {
                System.out.println("Failed to insert student.");
            }
        }
    }

    private static void updateStudent(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter new student details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Grade: ");
        String grade = scanner.nextLine();

        String sql = "UPDATE students SET name = ?, age = ?, grade = ? WHERE studentId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.setInt(4, studentId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID " + studentId + ".");
            }
        }
    }

    private static void deleteStudent(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to delete: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String sql = "DELETE FROM students WHERE studentId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with ID " + studentId + ".");
            }
        }
    }
}
