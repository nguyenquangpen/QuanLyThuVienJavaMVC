package model;

public class AcceptNo {
    private String StudentID;
    private String BookID;
    private int amount;
    private String status;
    public AcceptNo() {
    }
    public AcceptNo(String StudentID, String BookID, int amount, String status) {
        this.StudentID = StudentID;
        this.BookID = BookID;
        this.amount = amount;
        this.status = status;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Status{" +
                "StudentID='" + StudentID + '\'' +
                ", BookID='" + BookID + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
