package dao;

import model.AcceptNo;

import java.sql.*;
import java.util.ArrayList;

public class AcceptNoDao {
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

    public AcceptNo selectByID(String studentID, String bookID) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            acceptNo();
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
                return new AcceptNo(StudentID, BookID, amount, status);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Select by ID failed: " + e.getMessage(), e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close result set: " + e.getMessage());
                    e.printStackTrace();
                }
            }
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
        return null;
    }

    public boolean update(String studentID, String bookID, int amount, String cm) {
        PreparedStatement st = null;
        try {
            acceptNo(); // Open connection
            String sql = "UPDATE LibrarianAcept SET ChoMuon = ? WHERE StudentID = ? AND MaSachID = ?";
            st = c.prepareStatement(sql);

            st.setString(1, cm);
            st.setString(2, studentID);
            st.setString(3, bookID);
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

    public ArrayList<AcceptNo> selectAll() {
        ArrayList<AcceptNo> ketQua = new ArrayList<>();
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
                ketQua.add(new AcceptNo(StudentID, BookID, amount, status));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Select all failed: " + e.getMessage(), e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close result set: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close statement: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            close(); // Close connection
        }
        return ketQua;
    }
    public int delete(String studentID, String bookID) {
        PreparedStatement st = null;
        try {
            acceptNo(); // Open connection
            String sql = "DELETE FROM LibrarianAcept WHERE StudentID = ? AND MaSachID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, bookID);
            return st.executeUpdate();
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
            close(); // Close connection
        }
    }
    public boolean isAccepted(String MaSachid) {
        String query = "SELECT ChoMuon FROM LibrarianAcept WHERE MaSachID = ?";
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            acceptNo();
            st = c.prepareStatement(query);
            st.setString(1, MaSachid);
            rs = st.executeQuery();
            if (rs.next()) {
                return "Accepted".equals(rs.getString("ChoMuon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}