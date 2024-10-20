package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

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

    public int insert(Student sd) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "INSERT INTO student (StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail) VALUES (?, ?, ?, ?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, sd.getId());
            st.setString(2, sd.getName());
            st.setString(3, sd.getLocation());
            st.setInt(4, sd.getSdt());
            st.setString(5, sd.getGmail());
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

    public int update(Student sd) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "UPDATE student SET StudentName = ?, StudentLocation = ?, StudentSDT = ?, StudentGmail = ? WHERE StudentID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, sd.getName());
            st.setString(2, sd.getLocation());
            st.setInt(3, sd.getSdt());
            st.setString(4, sd.getGmail());
            st.setString(5, sd.getId());
            return st.executeUpdate();
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
            closeConnection();
        }
    }

    public int delete(Student sd) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "DELETE FROM student WHERE StudentID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, sd.getId());
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
            closeConnection();
        }
    }

    public ArrayList<Student> selectAll() {
        ArrayList<Student> ketQua = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            st = c.createStatement();
            String sql = "SELECT * FROM student";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String StudentID = rs.getString("StudentID");
                String StudentName = rs.getString("StudentName");
                String StudentLocation = rs.getString("StudentLocation");
                int StudentSDT = rs.getInt("StudentSDT");
                String StudentGmail = rs.getString("StudentGmail");
                ketQua.add(new Student(StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail));
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
            closeConnection();
        }
        return ketQua;
    }

    public Student selectById(String studentID) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM student WHERE StudentID = ?";
            st = c.prepareStatement(sql);
            st.setString(1, studentID);
            rs = st.executeQuery();
            if (rs.next()) {
                String StudentID = rs.getString("StudentID");
                String StudentName = rs.getString("StudentName");
                String StudentLocation = rs.getString("StudentLocation");
                int StudentSDT = rs.getInt("StudentSDT");
                String StudentGmail = rs.getString("StudentGmail");
                return new Student(StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail);
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

    public ArrayList<Student> selectByCondition(String condition, String column) {
        ArrayList<Student> arrKetQua = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM student WHERE " + column + " = ?";
            st = c.prepareStatement(sql);
            st.setString(1, condition);
            rs = st.executeQuery();
            while (rs.next()) {
                String StudentID = rs.getString("StudentID");
                String StudentName = rs.getString("StudentName");
                String StudentLocation = rs.getString("StudentLocation");
                int StudentSDT = rs.getInt("StudentSDT");
                String StudentGmail = rs.getString("StudentGmail");
                arrKetQua.add(new Student(StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Select by condition failed: " + e.getMessage(), e);
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
        return arrKetQua;
    }

    public Student selectByName(String name) {
        // Implementation needed based on specific requirements
        return null;
    }
}