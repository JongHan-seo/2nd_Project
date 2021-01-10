package NorthBears.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NBManagerDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	PreparedStatement psmt = null;
	
	static { 
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnect() {
		String URL = "jdbc:oracle:thin:@localhost:1521:XE"; 
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
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
	public List<MemberVO> MembergetAllList(){
		conn = getConnect();
		String sql = "select * from Member"; // 프리컴파일 (성능을 위해)
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // rs는 커서
			while(rs.next()) {
				String member_no = rs.getString("member_no");
				String member_id = rs.getString("member_id");
				String member_pw = rs.getString("member_pw");
				String member_name = rs.getString("member_name");
				String member_point  = rs.getString("member_point ");
				String member_email = rs.getString("member_email");
				String member_step  = rs.getString("member_step ");
				// 묶담
				MemberVO vo = new MemberVO();
				list.add(vo); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
	public int memberInsert(MemberVO vo) {
		conn = getConnect();
		String sql = "insert into tblMember values(sequence Member_seq.nextval,?,?,?,?,?,?)";
		int cnt = -1; // -1은 실패, 없다의 의미로...
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_id());
			ps.setString(2, vo.getMember_pw());
			ps.setString(3, vo.getMember_name());
			ps.setString(4, vo.getMember_email());
			ps.setString(5, vo.getMember_point());
			ps.setString(6, vo.getMember_step());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return cnt;
	}
	
	public int memberDelete(String num) {
		int cnt = 0;
		conn = getConnect();
		String sql = "delete from Member where member_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num );
			cnt = ps.executeUpdate();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return cnt;
		
	}
	
	public MemberVO memberContent(String member_no) {
		conn = getConnect();
		String sql = "select * from Member where member_no = ?";
		MemberVO vo = null; //MemberVO vo;라고만 쓰면 에러난다. null로 초기화.
		try {
			ps = conn.prepareStatement(sql);
	         ps.setString(1, member_no);
	         rs = ps.executeQuery();
				if(rs.next()) {
					member_no = rs.getString("member_no ");
					String member_id = rs.getString("member_id ");
					String member_pw = rs.getString("member_pw ");
					String member_name = rs.getString("member_name ");
					String member_email = rs.getString("member_email ");
					String member_point = rs.getString("member_point ");
					String member_step = rs.getString("member_step  ");
					vo = new MemberVO(); 
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	public int memberUpdate(MemberVO vo) {
		int cnt = 0;
		conn = getConnect();
		
		String sql = "update Member set member_pw = ?, member_name = ? , member_email = ?,member_point  = ?,member_step= ?  where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_pw());
			ps.setString(2, vo.getMember_name());
			ps.setString(3, vo.getMember_email());
			ps.setString(4, vo.getMember_point());
			ps.setString(5, vo.getMember_step());
			ps.setString(6, vo.getMember_no());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int UserInfoUpdate(MemberVO vo) {
		int cnt = 0;
		conn = getConnect();
		System.out.println(vo.getMember_name());
		System.out.println(vo.getMember_pw());
		System.out.println(vo.getMember_email());
		System.out.println(vo.getMember_no());
		String sql = "update Member set member_pw = ?, member_name = ? , member_email = ? where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_pw());
			ps.setString(2, vo.getMember_name());
			ps.setString(3, vo.getMember_email());
			ps.setString(4, vo.getMember_no());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(cnt);
		return cnt;
	}
	

	public List<ProgressVO> ProgressAllList(){
		conn = getConnect();
		String sql = "select * from Progress"; // 프리컴파일 (성능을 위해)
		List<ProgressVO> list = new ArrayList<ProgressVO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // rs는 커서
			while(rs.next()) {
				String member_no = rs.getString("member_no");
				String service_sum = rs.getString("service_sum");
				String category1 = rs.getString("category1");
				String category2 = rs.getString("category2");
				String category3  = rs.getString("category3 ");
				// 묶담
				ProgressVO vo = new ProgressVO();
				list.add(vo); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BoardVO> BoardAllList(){
		conn = getConnect();
		String sql = "select * from Board"; // 프리컴파일 (성능을 위해)
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // rs는 커서
			while(rs.next()) {
				String board_no = rs.getString("board_no");
				String board_name = rs.getString("board_name");
				String board_sort = rs.getString("board_sort");
				String board_date = rs.getString("board_date");
				String board_content  = rs.getString("board_content ");
				String member_no = rs.getString("member_no");
				String member_id  = rs.getString("member_id ");
				// 묶담
				BoardVO vo = new BoardVO();
				list.add(vo); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public int BoardUpdate(BoardVO vo) {
		int cnt = 0;
		conn = getConnect();
		
		String sql = "update Board set board_name = ?, board_content = ? where board_no=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getBoard_name());
			ps.setString(2, vo.getBoard_content());
			ps.setString(3, vo.getBoard_no());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int BoardDelete(String num) {
		conn = getConnect();
		String sql = "delete from Board where board_no = ?";
		int cnt=0;
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, num);
	         cnt = ps.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return cnt;
	
}
	
	public List<NoticeVO> NoticeAllList(){
		conn = getConnect();
		String sql = "select * from Notice"; // 프리컴파일 (성능을 위해)
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // rs는 커서
			while(rs.next()) {
				String notice_no = rs.getString("notice_no");
				String notice_name = rs.getString("notice_name");
				String notice_date = rs.getString("notice_date");
				String notice_content = rs.getString("notice_content");
				// 묶담
				NoticeVO vo = new NoticeVO();
				list.add(vo); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int NoticeInsert(NoticeVO vo) {
		conn = getConnect();
		String sql = "insert into Notice values(sequence Notice_seq.nextval,?,?,?)";
		int cnt = -1; // -1은 실패, 없다의 의미로...
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getNotice_name());
			ps.setString(2, vo.getNotice_date());
			ps.setString(3, vo.getNotice_content());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return cnt;
	}
	
	public int NoticeDelete(String num) {
		conn = getConnect();
		String sql = "delete from Notice where notice_no = ?";
		int cnt=0;
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, num);
	         cnt = ps.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return cnt;
	
}

	public int NoticeUpdate(NoticeVO vo) {
		int cnt = 0;
		conn = getConnect();
		
		String sql = "update Notice set notice_name = ?, notice_content = ? where notice_no=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getNotice_name());
			ps.setString(2, vo.getNotice_content());
			ps.setString(3, vo.getNotice_no());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public List<EventVO> EventAllList(){
		conn = getConnect();
		String sql = "select * from Event"; // 프리컴파일 (성능을 위해)
		List<EventVO> list = new ArrayList<EventVO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // rs는 커서
			while(rs.next()) {
				String event_no = rs.getString("event_no");
				String event_mgno = rs.getString("event_mgno");
				String event_name = rs.getString("event_name");
				String event_count = rs.getString("event_count");
				String event_point = rs.getString("event_point");
				String event_start = rs.getString("event_start");
				String event_end = rs.getString("event_end");
				String event_duration = rs.getString("event_duration");
				// 묶담
				EventVO vo = new EventVO();
				list.add(vo); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int EventUpdate(EventVO vo) {
		int cnt = 0;
		conn = getConnect();
		
		String sql = "update Event set event_mgno = ?, event_name = ?, event_count = ?, event_point = ?, event_start = ?, event_duration = ? where event_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getEvent_mgno());
			ps.setString(2, vo.getEvent_name());
			ps.setString(3, vo.getEvent_count());
			ps.setString(4, vo.getEvent_point());
			ps.setString(5, vo.getEvent_start());
			ps.setString(6, vo.getEvent_duration());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
	public int EventDelete(String num) {
		conn = getConnect();
		String sql = "delete from Event where event_no = ?";
		int cnt=0;
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1,num);
	         cnt = ps.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return cnt;
	
}
	
	
	public int EventInsert(EventVO vo) {
		conn = getConnect();
		String sql = "insert into Event values(sequence Event_seq.nextval,?,?,?,?,?,?,?)";
		int cnt = -1; // -1은 실패, 없다의 의미로...
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getEvent_mgno());
			ps.setString(2, vo.getEvent_name());
			ps.setString(3, vo.getEvent_count());
			ps.setString(4, vo.getEvent_point());
			ps.setString(5, vo.getEvent_start());
			ps.setString(6, vo.getEvent_end());
			ps.setString(7, vo.getEvent_duration());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return cnt;
	}
	
	
	
	
	

	
}
