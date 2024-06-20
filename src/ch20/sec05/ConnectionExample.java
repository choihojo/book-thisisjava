package ch20.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/thisisjava", "root", "1234");

            System.out.println("연결 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결 종료");
                } catch (SQLException e) {}
            }
        }
    }

}
