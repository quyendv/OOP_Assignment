import java.util.LinkedHashSet;
import java.util.Set;

public class StudentManagement {
    private final Student[] students = new Student[100];
    private int size = 0;

    /**
     * Kiem tra 2 student co cung gr k.
     * @param s1   Student1
     * @param s2   Student2
     * @return  boolean
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Them Student.
     * @param newStudent Student can them
     */
    public void addStudent(Student newStudent) {
        if (size >= 100 || newStudent == null) {
            return;
        }
        students[size++] = newStudent;
    }

    /**
     * Xoa sinh vien co getId = id.
     * @param id Student can xoa
     */
    public void removeStudent(String id) {
        int count = 0;
        for (int i = 0, curIndex = 0; i < size; i++) {
            if (students[i].getId().equals(id)) {
                count++;
                continue;
            }
            students[curIndex++] = students[i];
        }
        size -= count;
    }

    /**
     * Sx theo gr.
     * @return a String
     */
    public String studentsByGroup() {
        StringBuilder ans = new StringBuilder();
        Set<String> s = new LinkedHashSet<>();

        for (int i = 0; i < size; i++) {
            s.add(students[i].getGroup());
        }

        for (String gr : s) {
            ans.append(gr).append('\n');
            for (int i = 0; i < size; i++) {
                if (students[i].getGroup().equals(gr)) {
                    ans.append(students[i].getInfo()).append('\n');
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
