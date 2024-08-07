package ManageStudentAttendance;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Update student information");
            System.out.println("4. Add course score");
            System.out.println("5. Search for student");
            System.out.println("6. Display student list");
            System.out.println("7. Sort students by ID");
            System.out.println("8. Sort students by name");
            System.out.println("9. Add course");
            System.out.println("10. Remove course");
            System.out.println("11. Search for course");
            System.out.println("12. Display course list");
            System.out.println("13. Sort courses by ID");
            System.out.println("14. Sort courses by name");
            System.out.println("15. Add student score in course");
            System.out.println("16. Remove student score in course");
            System.out.println("17. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    studentManager.addStudent(new Student(id, name));
                }
                case 2 -> {
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    studentManager.removeStudent(removeId);
                }
                case 3 -> {
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    studentManager.updateStudent(updateId, newName);
                }
                case 4 -> {
                    System.out.print("Enter student ID to add course score: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter course score: ");
                    double score = scanner.nextDouble();
                    studentManager.addCourseScore(studentId, courseName, score);
                }
                case 5 -> {
                    System.out.print("Enter student ID to search for: ");
                    int findId = scanner.nextInt();
                    Student student = studentManager.findStudent(findId);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("No student found with ID " + findId);
                    }
                }
                case 6 -> studentManager.displayStudents();
                case 7 -> studentManager.sortStudentsById();
                case 8 -> studentManager.sortStudentsByName();
                case 9 -> {
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    courseManager.addCourse(new Course(courseId, courseName));
                }
                case 10 -> {
                    System.out.print("Enter course ID to remove: ");
                    int removeCourseId = scanner.nextInt();
                    courseManager.removeCourse(removeCourseId);
                }
                case 11 -> {
                    System.out.print("Enter course ID to search for: ");
                    int findCourseId = scanner.nextInt();
                    Course course = courseManager.findCourse(findCourseId);
                    if (course != null) {
                        System.out.println(course);
                    } else {
                        System.out.println("No course found with ID " + findCourseId);
                    }
                }
                case 12 -> courseManager.displayCourses();
                case 13 -> courseManager.sortCoursesById();
                case 14 -> courseManager.sortCoursesByName();
                case 15 -> {
                    System.out.print("Enter course ID to add student score: ");
                    int courseId = scanner.nextInt();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter score: ");
                    double score = scanner.nextDouble();
                    courseManager.addStudentScore(courseId, studentId, score);
                }
                case 16 -> {
                    System.out.print("Enter course ID to remove student score: ");
                    int courseId = scanner.nextInt();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    courseManager.removeStudentScore(courseId, studentId);
                }
                case 17 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
