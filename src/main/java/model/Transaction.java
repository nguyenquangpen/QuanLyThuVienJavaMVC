package model;

import java.util.Date;

public class Transaction {
    private String studentID;
    private String bookID;
    private int amount;
    private Date date;
    private Date returnDate;
    private String status;

    public Transaction() {
    }

    public Transaction(String studentID, String bookID, int amount, Date date, Date returnDate, String status) {
        this.studentID = studentID;
        this.bookID = bookID;
        this.amount = amount;
        this.date = date;
        this.returnDate = returnDate;
        this.status = status;
    }
    
    public Transaction(String studentID, String bookID, Date date) {
		this.studentID = studentID;
		this.bookID = bookID;
		this.date = date;
	}

	public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "studentID='" + studentID + '\'' +
                ", bookID='" + bookID + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}
