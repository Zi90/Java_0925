package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/* DB 접속 객체
	 * DB Driver, url, user, password
	 * com.mysql.cj.jdbc.Driver
	 * jdbc:mysql://localhost:3306/DB명
	 */
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	
	private String jdbDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbUrl = "jdbc:mysql://localhost:3306/javadb";
	
	// 생성자
	private DatabaseConnection() {
		try {
			// 드라이버를 로드하기 위한 메서드
			Class.forName(jdbDriver);
			// 연결을 위해서 url, user, password
			conn = DriverManager.getConnection(jdbUrl, "javaUser", "mysql");
		} catch (ClassNotFoundException e) {
			// 드라이버를 찾을 수 없을 경우
			System.out.println("드라이버를 찾을 수 없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			// con 연결정보가 잘못되었을 경우
			System.out.println("연결정보가 정확하지 않습니다.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnection getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
