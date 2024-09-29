//import View.LoginView;
//import View.QLSVView;
//import View.QLSachView;

import View.LoginView;
import View.QLSachView;
import View.StudentView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

class Test{
    public static void main(String [] args){
//        try {
//            Connection connection = JDBC.getConnection();
//
//            Statement st = connection.createStatement();
//
//            String sql = "insert into QLSach (MaSachId, TenSach, NamXB, TheLoai, TacGia) " +
//                    "values ('4', 'Python cơ bản', '2023', 'Giáo Trình', 'Bùi Việt Hà')";
//
//            int check = st.executeUpdate(sql);
//
//            System.out.println("ket qua thay doi " + check);
//            if(check > 0){
//                System.out.println("thay doi thanh cong");
//            }else{
//                System.out.println("thay doi loi");
//            }
//
//            JDBC.closeConnection(connection);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        new QLSachView();
    }
}

