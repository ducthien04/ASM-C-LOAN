package ManageStudentAttendance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void updateStudent(int id, String newName) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                break;
            }
        }
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void addCourseScore(int studentId, String courseName, double score) {
        // Implementation for adding course score
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentsById() {
        Collections.sort(students, Comparator.comparingInt(Student::getId));
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }
}
