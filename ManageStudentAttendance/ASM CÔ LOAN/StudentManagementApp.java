/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private final int studentId;
    private String name;
    private double score;

    public Student(int studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGrade() {
        if (score < 5.0) {
            return "Fail";
        } else if (score < 6.5) {
            return "Average";
        } else if (score < 7.5) {
            return "Good";
        } else if (score < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Score: " + score + ", Grade: " + getGrade();
    }
}

class Course {
    private final int courseId;
    private final String courseName;
    private final List<Student> enrolledStudents;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(int studentId) {
        enrolledStudents.removeIf(student -> student.getStudentId() == studentId);
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName + ", Enrolled Students: " + enrolledStudents;
    }
}

class StudentManager {
    private final List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        students.removeIf(student -> student.getStudentId() == studentId);
    }

    public void updateStudent(int studentId, String name, double score) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.setName(name);
                student.setScore(score);
                break;
            }
        }
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getScore).reversed());
    }

    public Student findStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class CourseManager {
    private final List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(int courseId) {
        courses.removeIf(course -> course.getCourseId() == courseId);
    }

    public Course findCourse(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}

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
            System.out.println("4. Sort students");
            System.out.println("5. Search for student");
            System.out.println("6. Display student list");
            System.out.println("7. Add course");
            System.out.println("8. Remove course");
            System.out.println("9. Search for course");
            System.out.println("10. Display course list");
            System.out.println("11. Enroll student in course");
            System.out.println("12. Display students in a course");
            System.out.println("13. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student score: ");
                    double score = scanner.nextDouble();
                    studentManager.addStudent(new Student(id, name, score));
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
                    System.out.print("Enter new score: ");
                    double newScore = scanner.nextDouble();
                    studentManager.updateStudent(updateId, newName, newScore);
                }
                case 4 -> {
                    studentManager.sortStudents();
                    System.out.println("Student list sorted.");
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
                case 7 -> {
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    courseManager.addCourse(new Course(courseId, courseName));
                }
                case 8 -> {
                    System.out.print("Enter course ID to remove: ");
                    int removeCourseId = scanner.nextInt();
                    courseManager.removeCourse(removeCourseId);
                }
                case 9 -> {
                    System.out.print("Enter course ID to search for: ");
                    int findCourseId = scanner.nextInt();
                    Course course = courseManager.findCourse(findCourseId);
                    if (course != null) {
                        System.out.println(course);
                    } else {
                        System.out.println("No course found with ID " + findCourseId);
                    }
                }
                case 10 -> courseManager.displayCourses();
                case 11 -> {
                    System.out.print("Enter course ID to enroll student in: ");
                    int courseId = scanner.nextInt();
                    Course course = courseManager.findCourse(courseId);
                    if (course != null) {
                        System.out.print("Enter student ID to enroll: ");
                        int studentId = scanner.nextInt();
                        Student student = studentManager.findStudent(studentId);
                        if (student != null) {
                            course.addStudent(student);
                            System.out.println("Student enrolled in course.");
                        } else {
                            System.out.println("No student found with ID " + studentId);
                        }
                    } else {
                        System.out.println("No course found with ID " + courseId);
                    }
                }
                case 12 -> {
                    System.out.print("Enter course ID to display students: ");
                    int courseId = scanner.nextInt();
                    Course course = courseManager.findCourse(courseId);
                    if (course != null) {
                        System.out.println("Students in course: " + course.getCourseName());
                        for (Student student : course.getEnrolledStudents()) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("No course found with ID " + courseId);
                    }
                }
                case 13 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
