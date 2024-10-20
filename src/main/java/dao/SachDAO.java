package dao;

import model.Sach;

import java.sql.*;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class SachDAO {
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

    public int insert(Sach t) {
        PreparedStatement st = null;
        try {
            openConnection();
            String sql = "INSERT INTO qlsach (MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong, DaMuon, TonKho) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            st = c.prepareStatement(sql);
            st.setString(1, t.getId());
            st.setString(2, t.getTenSach());
            st.setInt(3, t.getNamXuatBan());
            st.setString(4, t.getTheLoai());
            st.setString(5, t.getTenTacGia());
            st.setInt(6, t.getSoLuong());
            st.setInt(7, t.getDaMuon());
            st.setInt(8, t.getTonKho());
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
            String sql = "UPDATE qlsach SET TenSach=?, NamXB=?, TheLoai=?, TacGia=?, SoLuong=?, DaMuon=?, TonKho=? WHERE MaSachId=?";
            st = c.prepareStatement(sql);
            st.setString(1, t.getTenSach());
            st.setInt(2, t.getNamXuatBan());
            st.setString(3, t.getTheLoai());
            st.setString(4, t.getTenTacGia());
            st.setInt(5, t.getSoLuong()); 
            st.setInt(6, t.getDaMuon());   
            st.setInt(7, t.getTonKho());    
            st.setString(8, t.getId());    
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
            String sql = "DELETE FROM qlsach WHERE MaSachId = ?";
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
            String sql = "SELECT * FROM qlsach";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                int DaMuon = rs.getInt("DaMuon");
                ketQua.add(new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong, DaMuon));
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
            String sql = "SELECT * FROM qlsach WHERE MaSachId = ?";
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
                int DaMuon = rs.getInt("DaMuon");
                return (new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong, DaMuon));
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
            String sql = "SELECT * FROM qlsach WHERE " + column + " = ?";
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
                int DaMuon = rs.getInt("DaMuon");
                arrKetqua.add(new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong, DaMuon));
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
	public int updateStockAndBorrowed(String bookID, int newTonKho, int newDaMuon) {
		String sql = "UPDATE qlsach SET TonKho = ?, DaMuon = ? WHERE MaSachId = ?";
		PreparedStatement st = null;
	        try {
	            openConnection();
	            st = c.prepareStatement(sql);
	            st.setInt(1, newTonKho);
	            st.setInt(2, newDaMuon);
	            st.setString(3, bookID);
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
	public int updateSoLuong(String bookID, int newSoLuong, int DaMuon) {
		String sql = "UPDATE qlsach SET SoLuong =?, DaMuon =? WHERE MaSachId = ?";
		PreparedStatement st = null;
		try {
            openConnection();
            st = c.prepareStatement(sql);
            st.setInt(1, newSoLuong);
            st.setInt(2, DaMuon);
            st.setString(3, bookID);
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
	public int getDaMuon(String bookID) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			openConnection();
			String sql = "SELECT DaMuon FROM qlsach WHERE MaSachId = ?";
			st = c.prepareStatement(sql);
			st.setString(1, bookID);
			rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("DaMuon");
			}
		}catch(SQLException e) {
				throw new RuntimeException("Failed to get DaMuon: " + e.getMessage(), e);
		}finally {
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
	       closeConnection();
	}
	return 0;
	}
}