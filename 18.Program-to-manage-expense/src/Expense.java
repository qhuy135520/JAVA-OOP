
public class Expense {
    private int iD;
    private String date;
    private double number;
    private String content;

    public Expense() {
    }

    public Expense(int iD, String date, double number, String content) {
        this.iD = iD;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
