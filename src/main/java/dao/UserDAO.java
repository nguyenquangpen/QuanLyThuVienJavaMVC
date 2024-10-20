package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

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

    public int insert(User t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, t.getUsername());
            st.setString(2, t.getPassword());
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

    public int update(User t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "UPDATE user SET password=? WHERE username=?";
            st = c.prepareStatement(sql);
            st.setString(1, t.getPassword());
            st.setString(2, t.getUsername());
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

    public int delete(User t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "DELETE FROM user WHERE username=?";
            st = c.prepareStatement(sql);
            st.setString(1, t.getUsername());
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

    public ArrayList<User> selectAll() {
        ArrayList<User> users = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            st = c.createStatement();
            String sql = "SELECT * FROM user";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                users.add(new User(username, password));
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
        return users;
    }

    public User selectById(String username) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM user WHERE username=?";
            st = c.prepareStatement(sql);
            st.setString(1, username);
            rs = st.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                return new User(username, password);
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

    public ArrayList<User> selectByCondition(String condition, String column) {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM user WHERE " + column + "=?";
            st = c.prepareStatement(sql);
            st.setString(1, condition);
            rs = st.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                users.add(new User(username, password));
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
        return users;
    }

    public User selectByName(String name) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM user WHERE username=?";
            st = c.prepareStatement(sql);
            st.setString(1, name);
            rs = st.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                return new User(username, password);
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
}