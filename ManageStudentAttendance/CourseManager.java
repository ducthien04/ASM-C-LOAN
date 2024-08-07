package ManageStudentAttendance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseManager {
    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

    public Course findCourse(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void addStudentScore(int courseId, int studentId, double score) {
        // Implementation for adding student score
    }

    public void removeStudentScore(int courseId, int studentId) {
        // Implementation for removing student score
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void sortCoursesById() {
        Collections.sort(courses, Comparator.comparingInt(Course::getId));
    }

    public void sortCoursesByName() {
        Collections.sort(courses, Comparator.comparing(Course::getName));
    }
}
