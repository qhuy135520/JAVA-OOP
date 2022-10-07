import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class StudentManage {
    ArrayList<Student> studentList = new ArrayList<>();

    public StudentManage() {
    }

    public StudentManage(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public static Student getiDStudent(ArrayList<Student> student, int iD) {
        for (Student s : student) {
            if (s.getiD() == iD) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> studentFound = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                studentFound.add(s);
            }
        }
        return studentFound;
    }

    public ArrayList<Student> findStudentByID(int ID) {
        ArrayList<Student> studentFound = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getiD() == ID) {
                studentFound.add(s);
            }
        }
        return studentFound;
    }

    public void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getStudentName().compareTo(o2.getStudentName()) > 0) {
                    return 1;
                } else if (o1.getStudentName().compareTo(o2.getStudentName()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public HashMap<String, Integer> addHashStudent() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : studentList) {
            String key = student.getiD() + ";" + student.getStudentName() + ";" + student.getCourseName();
            if (reports.containsKey(key)) {
                int total = reports.get(key);
                reports.put(key, total + 1);
            } else {
                reports.put(key, 1);
            }
        }
        return reports;
    }
}
