import java.util.ArrayList;

public class ExpenseManage {
    ArrayList<Expense> expenseList = new ArrayList<>();

    public ExpenseManage() {
    }

    public ExpenseManage(ArrayList<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(ArrayList<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void addExpense(Expense expense) {
        this.expenseList.add(expense);
    }

    public boolean deleteExpense(int iD) {
        boolean isExist = false;
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getiD() == iD) {
                expenseList.remove(i);
                isExist = true;
                for (Expense expense : expenseList) {
                    if (expense.getiD() > iD) {
                        expense.setiD(expense.getiD() - 1);
                    }
                }
                break;
            }
        }
        return isExist;
    }
}
