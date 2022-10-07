import java.util.Objects;

public class Student {
    private int iD;
    private String studentName;
    private String semester;
    private String courseName;
    private int index;

    public Student() {
    }

    public Student(int iD, String studentName, String semester, String courseName, int index) {
        this.iD = iD;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
        this.index = index;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, iD, index, semester, studentName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return Objects.equals(courseName, other.courseName) && iD == other.iD && index == other.index
                && Objects.equals(semester, other.semester) && Objects.equals(studentName, other.studentName);
    }
}