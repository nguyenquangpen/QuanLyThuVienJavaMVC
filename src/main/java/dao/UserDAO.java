package dao;

import model.User;
import org.database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User> {

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User t) {
        int ketQua = 0;
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO User (username, password) VALUES (?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, t.getUsername());
            pstmt.setString(2, t.getPassword());

            ketQua = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) JDBCUtil.close(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ketQua;
    }


    @Override
    public int update(User t) {
        int ketQua = 0;
        try{
            Connection connection = JDBCUtil.getConnection();

            String sql = "UPDATE User "+
                    " SET " +
                    ", password=?"+
                    " WHERE username =?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, t.getPassword());
            st.setString(2, t.getUsername());

            ketQua = st.executeUpdate(sql);
            JDBCUtil.close(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(User t) {
        return 0;
    }

    @Override
    public ArrayList<User> selectAll() {
        return null;
    }

    @Override
    public User selectById(User t) {
        return null;
    }
    @Override
    public User selectByCondition(String condition) {
        User user = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM User WHERE username = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, condition);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User(username, password);
            }

            JDBCUtil.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
