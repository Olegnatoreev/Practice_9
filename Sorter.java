package PR9_1;

public class Sorter {
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = new Student[5];
        students[0] = new Student("12345", "Гена", "Галкин", 5.0);
        students[1] = new Student("11234", "Петя", "Пушкин", 2.5);
        students[2] = new Student("56789", "Вася", "Медведев", 1.0);
        students[3] = new Student("23490", "Галя", "Путин", 4.0);
        students[4] = new Student("23456", "Олег", "Островский", 3.5);

        // Sort the iDNumber array using insertion sort
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getIdNumber().compareTo(key.getIdNumber()) > 0) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }

        System.out.println("Отсартированный массив:");
        for (Student student : students) {
            System.out.println(student.getIdNumber() + " " + student.getFirstName() + " " + student.getLastName() + " " + student.getGrade());
        }
    }
}

class Student {
    private final String idNumber;
    private final String firstName;
    private final String lastName;
    private final double grade;

    public Student(String idNumber, String firstName, String lastName, double grade) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return idNumber + " " + firstName + " " + lastName + " " + grade;
    }
}