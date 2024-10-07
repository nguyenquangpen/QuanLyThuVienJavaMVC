package dao;

import model.Sach;
import model.Status;
import org.database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class AcceptNoDao {
    private Connection c = null;

    public void acceptNo() {
        try {
            String url = "jdbc:mysql://localhost:3306/library_management";  // Corrected URL
            String user = "root";
            String password = "11111111";
            c = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insert(String studentID, String bookID, int amount, String cm) {
        PreparedStatement st = null;
        try {
            acceptNo(); // Open connection
            String sql = "INSERT INTO LibrarianAcept (StudentID, MaSachID, SoLuong, ChoMuon) VALUES (?, ?, ?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, bookID);
            st.setInt(3, amount);
            st.setString(4, cm);

            return st.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            close(); // Close connection
        }
    }

    public Status selectByID(String studentID, String bookID) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            acceptNo(); // Open connection
            String sql = "SELECT * FROM LibrarianAcept WHERE StudentID = ? AND MaSachID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, bookID);
            rs = st.executeQuery();
            if (rs.next()) {
                String StudentID = rs.getString("StudentID");
                String BookID = rs.getString("MaSachID");
                int amount = rs.getInt("SoLuong");
                String status = rs.getString("ChoMuon");
                return new Status(StudentID, BookID, amount, status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            close(); // Close connection
        }
        return null;
    }

    public boolean update(String studentID, String bookID, int amount, String cm) {
        PreparedStatement st = null;
        try {
            acceptNo(); // Open connection
            String sql = "UPDATE LibrarianAcept SET SoLuong = ?, ChoMuon = ? WHERE StudentID = ? AND MaSachID = ?";
            st = c.prepareStatement(sql);
            st.setInt(1, amount);
            st.setString(2, cm);
            st.setString(3, studentID);
            st.setString(4, bookID);
            return st.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            close(); // Close connection
        }
    }

    public ArrayList<Status> selectAll() {
        ArrayList<Status> ketQua = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            acceptNo(); // Open connection
            st = c.createStatement();
            String sql = "SELECT * FROM LibrarianAcept";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String StudentID = rs.getString("StudentID");
                String BookID = rs.getString("MaSachID");
                int amount = rs.getInt("SoLuong");
                String status = rs.getString("ChoMuon");
                ketQua.add(new Status(StudentID, BookID, amount, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            close(); // Close connection
        }
        return ketQua;
    }
}