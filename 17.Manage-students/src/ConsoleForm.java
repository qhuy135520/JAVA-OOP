import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.zip.Checksum;

import javax.xml.transform.Templates;

public class ConsoleForm {
    StudentManage studentManage = new StudentManage();
    List<String> choices = Arrays.asList(
            "======Welcome To Student Management======",
            "||=====================================||",
            "||1. Create                            ||",
            "||2. Find and Sort                     ||",
            "||3. Update/Delete                     ||",
            "||4. Report                            ||",
            "||5. Exit                              ||",
            "||=====================================||", "Choose: ");

    public int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return ExceptionData.inputLimit();
    }

    public void createInformationStudent() {
        int count = 0;
        System.out.println("===========Add Students===========");
        System.out.println("you must enter at least 3 students");
        while (true) {
            Student student = new Student();
            System.out.print("Enter ID: ");
            student.setiD(ExceptionData.inputPositiveInt());
            System.out.print("Enter Student Name: ");
            student.setStudentName(ExceptionData.inputName());
            System.out.print("Enter Course Name: ");
            student.setCourseName(ExceptionData.inputCourse());
            System.out.print("Enter Semester: ");
            student.setSemester(ExceptionData.inputSemester());
            if (ExceptionData.checkExist(studentManage.studentList, student.getiD(), student.getStudentName(),
                    student.getCourseName(), student.getSemester())) {
                count++;
                studentManage.addStudent(student);
                System.out.println("Add successful student " + count + " !!");
            } else {
                System.out.println("This information is existed!!");
            }
            if (count >= 3) {
                if (ExceptionData.yesOrNo().equalsIgnoreCase("N")) {
                    return;
                }
            }
        }
    }

    public void findAndSortStudent() {
        System.out.print("Enter student you want to looking for: ");
        String name = ExceptionData.inputName();
        studentManage.sortStudentByName();
        ArrayList<Student> temp = studentManage.findStudentByName(name);
        if (!temp.isEmpty()) {
            System.out.printf("%-15s%-20s%-20s\n", "Name", "Course Name", "Semester");
            for (Student s : temp) {
                System.out.printf("%-15s%-20s%-20s\n", s.getStudentName(),
                        s.getCourseName(), s.getSemester());
            }
        } else {
            System.out.println("Not found !!");
        }
    }

    public void updateOrDeleteStudent() {
        System.out.println("===========Update or Delete===========");
        String choose = ExceptionData.updateOrDelete();
        int stt = 0;
        int iD = 0;
        ArrayList<Student> temp = null;
        Student student = null;
        try {
            if (choose.equalsIgnoreCase("U")) {
                System.out.print("Ente ID: ");
                iD = ExceptionData.inputPositiveInt();
                if (!ExceptionData.updateId(studentManage.studentList, iD)) {
                    System.out.println("Not found, changed failed !!");
                    return;
                }

                temp = studentManage.findStudentByID(iD);
                if (!temp.isEmpty()) {
                    stt = display(temp) - 1;
                    for (Student s : studentManage.studentList) {
                        if (s.equals(temp.get(stt))) {
                            student = s;
                            break;
                        }
                    }
                    System.out.print("Enter ID: ");
                    int idUpdate = ExceptionData.inputPositiveInt();
                    System.out.print("Enter name: ");
                    String nameUpdate = ExceptionData.inputName();
                    System.out.print("Enter Course Name: ");
                    String courseName = ExceptionData.inputCourse();
                    System.out.print("Enter Semester: ");
                    String semester = ExceptionData.inputSemester();

                    if (!ExceptionData.checkChange(student, idUpdate, nameUpdate, courseName, semester)) {
                        System.out.println("Nothing changed");
                        return;
                    } else if (ExceptionData.checkExist(studentManage.studentList, iD, nameUpdate, courseName,
                            semester)) {
                        student.setiD(idUpdate);
                        student.setStudentName(nameUpdate);
                        student.setCourseName(courseName);
                        student.setSemester(semester);
                        System.out.println("Update successful");
                    } else {
                        System.out.println("failed, Exist student!!");
                    }
                }
            } else {
                boolean isSuccess = false;
                System.out.println("Enter ID:");
                iD = ExceptionData.inputPositiveInt();

                temp = studentManage.findStudentByID(iD);
                if (!temp.isEmpty()) {
                    stt = display(temp) - 1;
                    System.out.println(temp.get(stt).getSemester());
                    for (Student s : studentManage.studentList) {
                        if (s.equals(temp.get(stt))) {
                            student = s;
                            studentManage.studentList.remove(stt);
                            System.out.println("Successful!!");
                            isSuccess = true;
                            return;
                        }
                    }
                }
                if (!isSuccess)
                    System.out.println("Failed,Not Found!!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Failed, not Found!!");
        }
    }

    public int display(ArrayList<Student> student) {
        int stt = 0;
        try {
            System.out.printf("%-10s%-10s%-15s%-20s%-20s\n", "STT", "ID", "Name", "Course Name", "Semester");
            int i = 0;
            for (Student s : student) {
                i++;
                System.out.printf("%-10d%-10s%-15s%-20s%-20s\n", i, s.getiD(),
                        s.getStudentName(),
                        s.getCourseName(), s.getSemester());
            }
            System.out.println("Choose STT: ");
            stt = ExceptionData.inputPositiveInt();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Failed !!, Not Found !!");
        }
        return stt;
    }

    public void report() {
        if (!studentManage.studentList.isEmpty()) {
            HashMap<String, Integer> reports = studentManage.addHashStudent();
            System.out.println("=========Report=========");
            if (!reports.isEmpty()) {
                System.out.printf("%-10s%-15s%-20s%-20s\n", "ID", "Name", "Course Name", "Total Course");
                for (String key : reports.keySet()) {
                    String[] words = key.split(";");
                    Integer total = reports.get(key);
                    System.out.printf("%-10s%-15s%-20s%-20s\n", words[0], words[1], words[2], total);
                }
            } else {
                System.out.println("List is empty!!");
            }
        } else {
            System.out.println("List is Empty!!");
        }
    }

    public void execute() {
        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    createInformationStudent();
                    break;
                case 2:
                    findAndSortStudent();
                    break;
                case 3:
                    updateOrDeleteStudent();
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    System.out.println("Good Bye !!");
                    System.exit(0);
            }
        }
    }
}
