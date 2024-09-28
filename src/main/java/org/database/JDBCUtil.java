package org.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;

        try {
            String url = "jdbc:mySQL://localhost:3306/library_management";
            String user = "root";
            String password = "11111111";
            c = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void close(Connection c) {
        try{
            if(c != null) {
                c.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
