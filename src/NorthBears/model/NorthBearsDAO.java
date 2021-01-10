package NorthBears.model;

import java.sql.*;

public class NorthBearsDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	PreparedStatement psmt = null;
	int cnt = 0;

	public void getConnect() {
		String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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

	public String memberLogin(String member_id, String member_pw) {

		getConnect();
		String member_no = null;

		String sql = "select member_no from Member where member_id=? and member_pw=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, member_id);
			ps.setString(2, member_pw);
			rs = ps.executeQuery();

			if (rs.next()) {
				member_no = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member_no;
	}

	public String ManagerLogin(String manager_id, String manager_pw) {
		getConnect();
		String manager_no = null;

		String sql = "select manager_no from Manager where manager_id=? and manager_pw=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, manager_id);
			ps.setString(2, manager_pw);
			rs = ps.executeQuery();

			if (rs.next()) {
				manager_no = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager_no;
	}

	public int join(String member_id, String member_pw, String member_name, String member_email) {
		getConnect();

		String sql = "insert into Member(member_no,member_id,member_pw,member_name,member_email)"
				+ " values(Member_seq.nextVal, ?, ?, ?, ?)";

		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, member_id);
			ps.setString(2, member_pw);
			ps.setString(3, member_name);
			ps.setString(4, member_email);

			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public void Progress() {
		getConnect();

		/*
		 * try { String sql = "insert into member values(?,?,?)"; psmt =
		 * conn.prepareStatement(sql);
		 * 
		 * psmt.setString(1, dto.getId()); psmt.setString(2, dto.getPw());
		 * psmt.setString(3, dto.getName());
		 * 
		 * cnt = psmt.executeUpdate(); } catch (SQLException e) { e.printStackTrace(); }
		 * finally { close(); }
		 */

		close();
	}
	
	public int progressjoin(String member_id) {
		getConnect();
		int cnt=0;
		
		String sql="insert into progress(member_no,service_sum,category1,category2,category3) "
				+ "values((select member_no from member where member_id=?), '0', '0', '0', '0')";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, member_id);
			
			cnt=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		close();
		
		return cnt;
	}

}
