package dao;

import model.Librarian;
import model.Sach;
import model.User;
import org.database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LibrarianDao implements DAOInterface<Librarian> {

    public static LibrarianDao getInstance() {
        return new LibrarianDao();
    }

    @Override
    public int insert(Librarian l) {
        int ketQua = 0;

        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO LibrarianLogin (username, password, LibrarianID) VALUES (?, ?, ?)";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, l.getUsername());
            st.setString(2, l.getPassword());
            st.setInt(3, l.getLibrarianID());

            ketQua = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Librarian librarian) {
        return 0;
    }

    @Override
    public int delete(Librarian librarian) {
        return 0;
    }

    @Override
    public ArrayList<Librarian> selectAll() {
        return null;
    }

    @Override
    public Librarian selectById(Librarian l) {
        Librarian ketQua = null;
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM LibrarianManager WHERE LibrarianID = ?";
            st = connection.prepareStatement(sql);
            st.setInt(1, l.getLibrarianID());

            rs = st.executeQuery();

            if (rs.next()) {
                int LibrarianID = rs.getInt("LibrarianID");
                String CardID = rs.getString("employeeCard");
                ketQua = new Librarian(LibrarianID, CardID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Librarian> selectByCondition(String condition, String value) {
        return null;
    }

    @Override
    public Librarian selectByName(String name) {
        Librarian librarian = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LibrarianLogin WHERE username = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int LibrarianID = rs.getInt("LibrarianID");
                librarian = new Librarian(username, password, LibrarianID);
            }

            JDBCUtil.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return librarian;
    }
}
