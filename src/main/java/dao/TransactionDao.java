package dao;
import model.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class TransactionDao {
    private Connection c = null;

    public void acceptNo() {
        try {
            String url = "nhập của bạn vào đây";
            String user = "tên người dùng của bạn";
            String password = "mật khẩu của bạn";
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (c != null) {
                c.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean insert(String studentID, String bookID, int amount, String date, String returnDate, String status) {
        PreparedStatement st = null;
        try {
            acceptNo();
            String sql = "INSERT INTO Transaction (StudentID, BookID, Amount, NgayMuon, NgayTra, Status) VALUES (?, ?, ?, ?, ?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, bookID);
            st.setInt(3, amount);

            // Chuyển đổi ngày mượn sang java.sql.Date
            java.sql.Date sqlBorrowDate = java.sql.Date.valueOf(date);
            st.setDate(4, sqlBorrowDate);

            java.sql.Date sqlReturnDate = java.sql.Date.valueOf(returnDate);
            st.setDate(5, sqlReturnDate);

            st.setString(6, status);

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Insert failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }

    public boolean update(String studentID, String bookID, String returnDate, String status) {
        PreparedStatement st = null;
        try {
            acceptNo();
            String sql = "UPDATE Transaction SET Status = ?, NgayTra = ? WHERE StudentID = ? AND BookID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, status);

            java.sql.Date sqlBorrowDate = java.sql.Date.valueOf(returnDate);
            st.setDate(2, sqlBorrowDate);

            st.setString(3, studentID);
            st.setString(4, bookID);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Update failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }

    public ArrayList<Transaction> selectAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            acceptNo();
            String sql = "SELECT * FROM Transaction";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                String studentID = rs.getString("StudentID");
                String bookID = rs.getString("BookID");
                int amount = rs.getInt("Amount");
                Date borrowDate = rs.getDate("NgayMuon");
                Date returnDate = rs.getDate("NgayTra");
                String status = rs.getString("Status");
                Transaction transaction = new Transaction(studentID, bookID, amount, borrowDate, returnDate, status);
                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            throw new RuntimeException("Select all failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }

    public boolean delete(String studentID, String BookID, String status) {
        PreparedStatement st = null;
        try {
            acceptNo();
            String sql = "DELETE FROM Transaction WHERE StudentID = ? AND BookID = ? AND Status = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, BookID);
            st.setString(3, status);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Delete failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }
    public ArrayList<Transaction> selectByCondition(String studentID, String column, String value){
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            acceptNo();
            String sql = "SELECT * FROM Transaction WHERE StudentID = ? AND " + column + " = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, value); 
            rs = st.executeQuery();
            while (rs.next()) {
                String BookID = rs.getString("BookID");
                int amount = rs.getInt("Amount");
                Date borrowDate = rs.getDate("NgayMuon");
                Date returnDate = rs.getDate("NgayTra");
                String status = rs.getString("Status");
                Transaction transaction = new Transaction(studentID, BookID, amount, borrowDate, returnDate, status);
                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            throw new RuntimeException("Select by condition failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }
    public ArrayList<Transaction> selectByName(String studentID, String column) {
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            acceptNo();
            String sql = "SELECT * FROM Transaction WHERE StudentID = ? AND " + column + " IS NOT NULL";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);

            rs = st.executeQuery();
            while (rs.next()) {
                String BookID = rs.getString("BookID");
                int amount = rs.getInt("Amount");
                Date borrowDate = rs.getDate("NgayMuon");
                Date returnDate = rs.getDate("NgayTra");
                String status = rs.getString("Status");
                Transaction transaction = new Transaction(studentID, BookID, amount, borrowDate, returnDate, status);
                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            throw new RuntimeException("Select all failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }
    public boolean delete_Book(String studentID) {
        PreparedStatement st = null;
        try {
            acceptNo();
            String sql = "DELETE FROM Transaction WHERE StudentID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Delete failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }
    public ArrayList<Transaction> selectByName(String studentID){
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            acceptNo();
            // Xây dựng câu lệnh SQL với tên cột đã được xác thực
            String sql = "SELECT * FROM Transaction WHERE StudentID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            rs = st.executeQuery();
            while (rs.next()) {
                String BookID = rs.getString("BookID");
                int amount = rs.getInt("Amount");
                Date borrowDate = rs.getDate("NgayMuon");
                Date returnDate = rs.getDate("NgayTra");
                String status = rs.getString("Status");
                Transaction transaction = new Transaction(studentID, BookID, amount, borrowDate, returnDate, status);
                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            throw new RuntimeException("Select by condition failed: " + e.getMessage(), e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close();
        }
    }
}