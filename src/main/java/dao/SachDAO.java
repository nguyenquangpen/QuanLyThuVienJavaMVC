package dao;

import model.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.database.JDBCUtil;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance(){
        return new SachDAO();
    }

    @Override
    public int insert(Sach t) {
        int ketQua = 0;
        Connection connection = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO QLSach (MaSachId, TenSach, NamXB, TheLoai, TacGia) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, t.getId());
            st.setString(2, t.getTenSach());
            st.setInt(3, t.getNamXuatBan());
            st.setString(4, t.getTheLoai());
            st.setString(5, t.getTenTacGia());

            ketQua = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    @Override
    public int update(Sach t) {
        int ketQua = 0;
        try{
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE QLSach "+
                    " SET " +
                    " tenSach=?"+
                    ", NamXB=?"+
                    ", TheLoai=?"+
                    ", TacGia=?"+
                    " WHERE MaSachId =?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, t.getTenSach());
            st.setInt(2, t.getNamXuatBan());
            st.setString(3, t.getTheLoai());
            st.setString(4, t.getTenTacGia());
            st.setString(5, t.getId());

            ketQua = st.executeUpdate();
            JDBCUtil.close(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Sach t) {
        int ketQua = 0;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "DELETE FROM QLSach WHERE MaSachId = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, t.getId());

            ketQua = st.executeUpdate();

            JDBCUtil.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList ketQua = new ArrayList();
        try{
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();

            String sql = "SELECT * FROM QLSach";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                Sach sach = new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong);
                ketQua.add(sach);
            }
            JDBCUtil.close(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Sach selectById(Sach t) {
        Sach ketQua = null;
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM QLSach WHERE MaSachId = ?";
            st = connection.prepareStatement(sql);
            st.setString(1, t.getId());

            rs = st.executeQuery();

            if (rs.next()) {
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                ketQua = new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    @Override
    public Sach selectByCondition(String condition) {
        Sach ketQua = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM QLSach WHERE TenSach = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, condition);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String MaSachId = rs.getString("MaSachId");
                String TenSach = rs.getString("TenSach");
                int NamXB = rs.getInt("NamXB");
                String TheLoai = rs.getString("TheLoai");
                String TacGia = rs.getString("TacGia");
                int SoLuong = rs.getInt("SoLuong");
                ketQua = new Sach(MaSachId, TenSach, NamXB, TheLoai, TacGia, SoLuong);
            }

            JDBCUtil.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
