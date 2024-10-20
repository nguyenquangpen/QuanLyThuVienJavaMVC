package dao;

import model.Librarian;

import java.sql.*;
import java.util.ArrayList;

public class LibrarianDao {
    private Connection c = null;

    public void openConnection() {
        try {
        	String url = "jdbc:mySQL://localhost:3306/library_management";
            String user = "root";
            String password = "";
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnection() {
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

    public int insert(Librarian l) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "INSERT INTO librarianlogin (username, password, LibrarianID) VALUES (?, ?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, l.getUsername());
            st.setString(2, l.getPassword());
            st.setInt(3, l.getLibrarianID());
            return st.executeUpdate();
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
            closeConnection();
        }
    }

    public Librarian selectById(int librarianID) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM librarianmanager WHERE LibrarianID = ?";
            st = c.prepareStatement(sql);
            st.setInt(1, librarianID);
            rs = st.executeQuery();
            if (rs.next()) {
                String CardID = rs.getString("employeeCard");
                return new Librarian(librarianID, CardID);
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
            closeConnection();
        }
        return null;
    }

    public Librarian selectByName(String name) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM librarianlogin WHERE username = ?";
            st = c.prepareStatement(sql);
            st.setString(1, name);
            rs = st.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int librarianID = rs.getInt("LibrarianID");
                return new Librarian(username, password, librarianID);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Select by name failed: " + e.getMessage(), e);
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
            closeConnection();
        }
        return null;
    }

    public ArrayList<Librarian> selectByCondition(String condition, String value) {

        return null;
    }

}