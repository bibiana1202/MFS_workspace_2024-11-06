package net.developia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static final String USER = "ace";
    private static final String PASSWORD = "ace";

    public static void main(String[] args) throws SQLException {
        String selectSQL = "SELECT USERNAME, PASSWORD, NAME, EMAIL, BIRTH, JOIN_DATE FROM XCI_MEMBERS";
        Connection conn = null; //연결 인터페이스
        Statement stmt = null; //쿼리 인터페이스
        ResultSet rs = null; //결과 인터페이스
        try  {
        	conn = DriverManager.getConnection(URL, USER, PASSWORD);// 커넥션 연결
        	//connection 시 무족건 트랜잭션 처리
        	conn.setAutoCommit(false); // true: 쿼리 실행시 바로 commit
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String maskedPassword = "*".repeat(password.length());  // Password masking
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                int birth = rs.getInt("BIRTH");
                Date joinDate = rs.getDate("JOIN_DATE");
                System.out.println("Username: " + username + ", Password: " + maskedPassword + 
                                   ", Name: " + name + ", Email: " + email +
                                   ", Birth: " + birth + ", Join Date: " + joinDate);
            }
            conn.commit(); //실행의 마지막 여기서 커밋함!!!
        } catch (SQLException e) {
            e.printStackTrace();
			conn.rollback(); // 예외시 롤백
        }finally {
        	conn.setAutoCommit(true); // close 하기전 conn 원상복귀
        	// 역순으로 리소스
        	if(rs != null) try {rs.close();} catch(Exception e) {}
        	if(stmt != null) try {stmt.close();} catch(Exception e) {}
        	if(conn != null) try {conn.close();} catch(Exception e) {}
        }
    }
}