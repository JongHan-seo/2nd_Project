package NorthBears.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArduinoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	PreparedStatement psmt;
	int cnt = 0;

	// 1.Connection ´Ý±â
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2.getConn ¿­±â
	private void getConnection() {
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void TrashPointPlus() {
		getConnection();
		
		String sql="insert into ";
		
		
		
		close();
	}

	
			
			
			
			

}
