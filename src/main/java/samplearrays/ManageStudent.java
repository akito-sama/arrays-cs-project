package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {


    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        return Arrays.stream(students).max(Comparator.comparingInt(Student::getGrade)).orElse(null);
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        return (int) Arrays.stream(students).filter(Student::isAdult).count();
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sum = 0;
        for (var student: students) {
            sum += student.getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        return Arrays.stream(students).filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, (x, y) -> y.getGrade() - x.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (var s: Arrays.stream(students).filter(x-> x.getGrade() >= 15).toList()) {
            System.out.println(s.getName());
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i].setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equals(students[j].getName())) {
                    return true;
                }
            }
        }
        return  false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        var newStudents = new Student[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = newStudent;
        return  newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(0, "Ahmed", 20, 20);
        arr[1] = new Student(1, "Tarik", 20, 21);
        arr[2] = new Student(2, "Salim", 20, 1);
        arr[3] = new Student(3, "Mouad", 20, 20);
        arr[4] = new Student(4, "Joker", 20, 19);



        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println(ManageStudent.findOldest(arr));

        // 3) Count adults
        System.out.println(ManageStudent.countAdults(arr));


        // 4) Average grade
        System.out.println(ManageStudent.averageGrade(arr));


        // 5) Find by name
        System.out.println(ManageStudent.findStudentByName(arr, "Salim"));


        // 6) Sort by grade desc
        ManageStudent.sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        var updated = ManageStudent.updateGrade(arr, 4, 18);
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("Has duplicates ? "+ ManageStudent.hasDuplicateNames(arr));

        // 10) Append new student
        var newStudents = ManageStudent.appendStudent(arr, new Student(5, "Youssef", 20, 10));
        for (Student s : arr) System.out.println(s);

        // 11) 2D array
        Student[][] school = {{newStudents[0], newStudents[1], newStudents[2]},
                            {newStudents[3], newStudents[4], new Student(6, "Haytam", 20, 20)}};
        for (var classe : school) {
            for (var student: classe) {
                System.out.println(student.toString());
            }
            System.out.println("-----------------------");
        }
        for (int i = 0; i < school.length; i++) {
            System.out.println("TopStudent in Class " + i + " is: " + (Arrays.stream(school[i]).max(Comparator.comparingInt(Student::getGrade)).orElse(null)));
        }
    }
}

