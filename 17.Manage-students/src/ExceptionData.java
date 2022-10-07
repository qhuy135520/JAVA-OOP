import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionData {

    public static String inputString() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.err.print("Please try again: ");
            } else {
                return result.trim();
            }
        }
    }

    public static int inputInt() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number");
                System.err.print("Please try again: ");
            }
        }
    }

    public static int inputPositiveInt() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number");
                System.err.print("Please try again: ");
            }
        }
    }

    public static double inputDouble() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                System.out.print("Please try again: ");
            }
        }
    }

    public static String inputName() {
        Pattern p = Pattern.compile("^[a-zA-Z\\s]+$");
        while (true) {
            String name = inputString();
            name.split(" +");
            if (p.matcher(name).find()) {
                return name;
            } else {
                System.err.print("Wrong name type, please try again: ");
            }
        }
    }

    public static int inputLimit() {
        while (true) {
            int result = inputInt();
            if (result > 0 && result < 6) {
                return result;
            } else {
                System.err.print("Please enter choice (" + 1 + " to " + 5 + "):");
            }
        }
    }

    public static boolean checkExist(ArrayList<Student> temp, int iD, String name, String courseName,
            String semester) {
        boolean isExist = true;
        if (!temp.isEmpty()) {
            for (Student s : temp) {
                if (s.getiD() == iD && s.getStudentName().equalsIgnoreCase(name)
                        && s.getCourseName().equalsIgnoreCase(courseName)
                        && s.getSemester().equalsIgnoreCase(semester)) {
                    isExist = false;
                }
            }
        }
        return isExist;
    }

    public static boolean checkId(ArrayList<Student> temp, int iD) {
        boolean isExist = true;
        if (!temp.isEmpty()) {
            for (Student s : temp) {
                if (s.getiD() == iD) {
                    isExist = false;
                }
            }
        }
        return isExist;
    }

    public static int inputId(ArrayList<Student> temp) {
        while (true) {
            int iD = inputPositiveInt();
            boolean check = checkId(temp, iD);
            if (!check) {
                System.out.print("ID is already exist, try again: ");
            } else {
                return iD;
            }
        }
    }

    public static int changeId(Student s, ArrayList<Student> list) {
        while (true) {
            int idUpdate = inputPositiveInt();
            boolean check = checkId(list, idUpdate);
            if (!check && s.getiD() != (idUpdate)) {
                System.out.print("ID is already exist, try again: ");
            } else {
                return idUpdate;
            }
        }
    }

    public static boolean updateId(ArrayList<Student> temp, int iD) {

        boolean check = checkId(temp, iD);
        if (!check) {
            for (Student s : temp) {
                if (s.getiD() == iD) {
                    break;
                }
            }
            System.err.println("Exist!!, can change!!");
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkChange(Student s, int iD, String name, String courseName,
            String semester) {
        if (s.getiD() == iD && s.getStudentName().equals(name)
                && s.getCourseName().equals(courseName) && s.getSemester().equalsIgnoreCase(semester)) {
            return false;
        }
        return true;
    }

    public static String inputCourse() {
        while (true) {
            String result = inputString();
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("Please input: Java OR .Net OR C/C++");
            System.out.print("Enter Course Name: ");
        }
    }

    public static String inputSemester() {
        while (true) {
            String result = inputString();
            if (result.equalsIgnoreCase("spring")
                    || result.equalsIgnoreCase("summer")
                    || result.equalsIgnoreCase("fall")) {
                return result;
            }
            System.err.println("Please input: Spring OR Summer OR Fall");
            System.out.print("Enter Semester: ");
        }
    }

    public static String yesOrNo() {
        System.out.print("Do you want to continue (Y/N): ");
        while (true) {
            String choose = inputString();
            choose = choose.trim();
            if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("N")) {
                return choose;
            } else {
                System.err.print("Please choose Y(yes) OR N(no): ");
            }
        }
    }

    public static String updateOrDelete() {
        System.out.print("Do you want to update (U) or delete (D) student: ");
        while (true) {
            String choose = inputString();
            choose = choose.trim();
            if (choose.equalsIgnoreCase("U") || choose.equalsIgnoreCase("D")) {
                return choose;
            } else {
                System.err.print("Please choose U(update) OR D(): ");
            }
        }
    }
}
