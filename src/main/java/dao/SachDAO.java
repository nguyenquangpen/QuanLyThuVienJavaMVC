package dao;

import model.Sach;

import java.sql.*;
import java.util.ArrayList;

public class SachDAO {
    private Connection c = null;

    public void openConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/library_management";
            String user = "root";
            String password = "11111111";
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

    public int insert(Sach t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "INSERT INTO QLSach (MaSachId, TenSach, NamXB, TheLoai, TacGia) VALUES (?, ?, ?, ?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, t.getId());
            st.setString(2, t.getTenSach());
            st.setInt(3, t.getNamXuatBan());
            st.setString(4, t.getTheLoai());
            st.setString(5, t.getTenTacGia());
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

    public int update(Sach t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "UPDATE QLSach SET TenSach=?, NamXB=?, TheLoai=?, TacGia=? WHERE MaSachId=?";
            st = c.prepareStatement(sql);
            st.setString(1, t.getTenSach());
            st.setInt(2, t.getNamXuatBan());
            st.setString(3, t.getTheLoai());
            st.setString(4, t.getTenTacGia());
            st.setString(5, t.getId());
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

    public int delete(Sach t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "DELETE FROM QLSach WHERE MaSachId = ?";
            st = c.prepareStatement(sql);
            st.setString(1, t.getId());
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

    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            st = c.createStatement();
            String sql = "SELECT * FROM QLSach";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                ketQua.add(new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong));
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

    public Sach selectById(String BookID) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM QLSach WHERE MaSachId = ?";
            st = c.prepareStatement(sql);
            st.setString(1, BookID);
            rs = st.executeQuery();
            if (rs.next()) {
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                return new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong);
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

    public ArrayList<Sach> selectByCondition(String condition, String column) {
        ArrayList<Sach> arrKetqua = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            openConnection();
            String sql = "SELECT * FROM QLSach WHERE " + column + " = ?";
            st = c.prepareStatement(sql);
            st.setString(1, condition);
            rs = st.executeQuery();
            while (rs.next()) {
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                arrKetqua.add(new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong));
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
        return arrKetqua;
    }
}