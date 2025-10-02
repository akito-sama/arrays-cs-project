package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    int[] updatedCourses = {};
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = new int[registeredCourses.length + 1];
        int newCourse = 2025;
        System.arraycopy(registeredCourses, 0, updatedCourses, 0, registeredCourses.length);
        updatedCourses[registeredCourses.length] = newCourse;
        for (var i: updatedCourses) {
            System.out.print(i + " ");
        }
        if (Arrays.stream(updatedCourses).anyMatch(x -> x == newCourse)) {
            System.out.println("we have found the number: " + newCourse);
        } else {
            System.out.println("we have not found the number: " + newCourse);
        }
    }
}
