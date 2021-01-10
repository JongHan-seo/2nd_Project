package NorthBears.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getConnect() {
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id="hr";
		String pw="hr";
		
		try {
			conn=DriverManager.getConnection(url, id, pw);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(conn!=null)
		{
			System.out.println("연결 완료");
		}
		
		
		
	}
	
	public void Close() {
		
		try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	
	
	public List<MemberVO> getAllList(){
		
		getConnect();
		List<MemberVO> list=new ArrayList<MemberVO>();
		
		String sql = "select * from Member";
		try {
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String member_no=rs.getString("member_no");
				String member_id=rs.getString("member_id");
				String member_pw=rs.getString("member_pw");
				String member_name=rs.getString("member_name");
				String member_email=rs.getString("member_email");
				String member_point = rs.getString("member_point");
				String member_step = rs.getString("member_step");
				
				MemberVO vo=new MemberVO();
				vo.setMember_email(member_email);
				vo.setMember_id(member_id);
				vo.setMember_name(member_name);
				vo.setMember_no(member_no);
				vo.setMember_point(member_point);
				vo.setMember_pw(member_pw);
				vo.setMember_step(member_step);
				
				
				
				
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		Close();
		return list;
		
	}
	
	
	public int memberinsert(MemberVO vo) {
		int cnt = 0;
		getConnect();
		
		String sql="insert into Member values(Member_seq.nextVal,?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,vo.getMember_id());
			ps.setString(2,vo.getMember_pw());
			ps.setString(3,vo.getMember_name());
			ps.setString(4,vo.getMember_email());
			
			cnt=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		Close();
		return cnt;
	}
	
	public MemberVO login(MemberVO vo) {
		
		String member_no=null;
		String member_id=null;
		
		getConnect();
		
		String sql = "select * from member where member_id=? and member_pw=?";
		System.out.println("sql문 통과 : "+sql);
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_id());
			ps.setString(2, vo.getMember_pw());
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				member_no=rs.getString("member_no");
				member_id=rs.getString("member_id");
				
				
			}
			
			System.out.println("member_id :"+member_no);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		vo.setMember_no(member_no);
		
		Close();
		return vo;
	}
	
	
	public String IdConfirm(MemberVO vo) {
		
		getConnect();
		String result=null;
		
		String sql="select member_id from member where member_id=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_id());
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				result=rs.getString("member_id");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		Close();
		return result;
		
		
		
	}
	
	public String RfidFind(String rfid) {
		getConnect();
		String id=null;
		
		String sql="select * from member where member_rf=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, rfid);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				id=rs.getString("member_id");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		Close();
		return id;
	}
	
	
}
