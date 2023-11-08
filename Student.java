package PR9_2;
import java.util.Comparator;
import java.util.List;

public record Student(String name, int age, double score) {
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.score(), s1.score());
    }
}

class QuickSort {
    public static void quickSort(List<Student> students, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int partitionIndex = partition(students, low, high, comparator);
            quickSort(students, low, partitionIndex - 1, comparator);
            quickSort(students, partitionIndex + 1, high, comparator);
        }
    }

    private static int partition(List<Student> students, int low, int high, Comparator<Student> comparator) {
        int pivotIndex = low + (high - low) / 2;
        Student pivot = students.get(pivotIndex);
        swap(students, pivotIndex, high);
        int partitionIndex = low;
        for (int i = low; i < high; i++) {
            if (comparator.compare(students.get(i), pivot) < 0) {
                swap(students, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(students, partitionIndex, high);
        return partitionIndex;
    }

    private static void swap(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }
}

class Name {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Гена", 20, 80),
                new Student("Петя", 22, 75),
                new Student("Вася", 21, 90),
                new Student("Галя", 20, 85),
                new Student("Люба", 21, 70)
        );

        StudentComparator comparator = new StudentComparator();
        QuickSort.quickSort(students, 0, students.size() - 1, comparator);

        System.out.println("Отсортированные студенты:");
        for (Student student : students) {
            System.out.println(student.name() + " - " + student.score());
        }
    }
}
