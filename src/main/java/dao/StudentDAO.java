package dao;

import model.Sach;
import model.Student;
import org.database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student> {

    public static StudentDAO getInstance() {
        return new StudentDAO();
    }

    @Override
    public int insert(Student sd) {
        int ketQua = 0;
        Connection connection = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO student (StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, sd.getId());
            st.setString(2, sd.getName());
            st.setString(3, sd.getLocation());
            st.setInt(4, sd.getSdt());
            st.setString(5, sd.getGmail());

            ketQua = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Student sd) {
        int ketQua = 0;
        Connection connection = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "UPDATE student " +
                    " SET " +
                    " StudentName = ?" +
                    ", StudentLocation = ?" +
                    ", StudentSDT = ?" +
                    ", StudentGmail = ?" +
                    " WHERE StudentID = ?";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, sd.getName());
            st.setString(2, sd.getLocation());
            st.setInt(3, sd.getSdt());
            st.setString(4, sd.getGmail());
            st.setInt(5, sd.getId());
            ketQua = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    @Override
    public int delete(Student sd) {
        int ketQua = 0;
        Connection connection = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM student WHERE StudentID = ?";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, sd.getId());

            ketQua = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList ketQua = new ArrayList();
        try{
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();

            String sql = "SELECT * FROM student";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                int StudentID = rs.getInt("StudentID");
                String StudentName = rs.getString("StudentName");
                String StudentLocation = rs.getString("StudentLocation");
                int StudentSDT = rs.getInt("StudentSDT");
                String StudentGmail = rs.getString("StudentGmail");
                Student student = new Student(StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail);
                ketQua.add(student);
            }
            JDBCUtil.close(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Student selectById(Student sd) {
        Student ketQua = null;
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM student WHERE StudentID = ?";
            st = connection.prepareStatement(sql);
            st.setInt(1, sd.getId());

            rs = st.executeQuery();

            if (rs.next()) {
                int StudentID = rs.getInt("StudentID");
                String StudentName = rs.getString("StudentName");
                String StudentLocation = rs.getString("StudentLocation");
                int StudentSDT = rs.getInt("StudentSDT");
                String StudentGmail = rs.getString("StudentGmail");
                ketQua = new Student(StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Student selectByCondition(String condition) {
        Student ketQua = null;
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "SELECT * FROM student WHERE StudentName = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, condition);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int StudentID = rs.getInt("StudentID");
                String StudentName = rs.getString("StudentName");
                String StudentLocation = rs.getString("StudentLocation");
                int StudentSDT = rs.getInt("StudentSDT");
                String StudentGmail = rs.getString("StudentGmail");
                ketQua = new Student(StudentID, StudentName, StudentLocation, StudentSDT, StudentGmail);
            }

            JDBCUtil.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
