import java.util.Arrays;
import java.util.List;

public class ConsoleForm {
    ExpenseManage expenseManage = new ExpenseManage();
    int count = 0;
    List<String> choices = Arrays.asList(
            "||=====Handy Expense program=====||",
            "||1. Add an expense              ||",
            "||2. Display all expenses        ||",
            "||3. Delete an expense           ||",
            "||4. Exit                        ||",
            "||===============================||",
            "choose: ");

    public int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return ExceptionData.inputLimit();
    }

    public void addExpense() {
        while (true) {
            Expense expense = new Expense();
            System.out.print("Enter Date: ");
            expense.setDate(ExceptionData.inputDate());

            System.out.print("Enter Amount: ");
            expense.setNumber(ExceptionData.inputPositiveDouble());

            System.out.print("Enter Content: ");
            expense.setContent(ExceptionData.inputString());

            count++;
            expense.setiD(count);
            expenseManage.addExpense(expense);
            if (ExceptionData.yesOrNo().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void displayAll() {
        int total = 0;
        if (!expenseManage.expenseList.isEmpty()) {
            System.out.printf("%-7s%-15s%-10s%-10s\n", "ID", "Date", "Amount", "Content");
            for (Expense e : expenseManage.expenseList) {
                System.out.printf("%-7d%-15s%-10.1f%-10s\n", e.getiD(), e.getDate(), e.getNumber(), e.getContent());
                total += e.getNumber();
            }
            System.out.println("Total: " + total);
        } else {
            System.out.println("List is Empty !!");
        }
    }

    public void deleteAnExpense() {

        System.out.println("---------Delete an expense---------");
        displayAll();
        System.out.print("ID: ");
        int iD = ExceptionData.inputPositiveInt();

        if (!expenseManage.expenseList.isEmpty()) {
            boolean isExist = expenseManage.deleteExpense(iD);
            if (!isExist) {
                System.out.println("Delete an expense fail!!");
            } else {
                System.out.println("Delete an expense successful!!");
                count--;
            }
        } else {
            System.out.println("Delete an expense fail!!");
        }
    }

    public void execute() {
        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    deleteAnExpense();
                    break;
                case 4:
                    System.out.println("Good Bye!!");
                    System.exit(0);
            }
        }
    }
}
