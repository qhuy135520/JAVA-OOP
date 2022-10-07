import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionData {
    public final static String dateValue = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static String inputString() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.print("Enter again: ");
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
                System.out.print("Please enter a number: ");
            }
        }
    }

    public static double inputPositiveDouble() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
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
                System.out.print("Please enter a number: ");
            }
        }
    }

    public static String inputDate() {
        Pattern p = Pattern.compile(dateValue);
        while (true) {
            String date = inputString();
            date.split(" +");
            if (p.matcher(date).find()) {
                return date;
            } else {
                System.out.println("Date to correct format(dd-MM-yyyy). Example: 13-Apr-2002 ");
                System.out.print("Enter Again!!");
            }
        }
    }

    public static int inputLimit() {
        while (true) {
            int result = inputInt();
            if (result >= 1 && result <= 4) {
                return result;
            } else {
                System.out.println("Please enter choice (" + 1 + " to " + 4 + ")!!");
                System.out.print("Enter choice: ");
            }
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
                System.out.println("Please choose Y(yes) OR N(no)!! ");
                System.out.print("Enter choice: ");
            }
        }
    }
}
