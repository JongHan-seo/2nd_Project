package NorthBears.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NBUserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	PreparedStatement psmt;
	int cnt = 0;

	// 1.Connection 丸奄
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

	// 2.getConn 伸奄
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

	// 3.噺据 纏盗
	public int userDelete(String member_no) {
		getConnection();

		String sql = "delete from member where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 4.噺据舛左 呪舛
	public int memberUpdate(MemberVO vo) {
		getConnection();
		int cnt = 0;

		String sql = "update Member set member_pw=?, member_name=?, member_email=?  where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_pw());
			ps.setString(2, vo.getMember_name());
			ps.setString(3, vo.getMember_email());
			ps.setString(4, vo.getMember_no());
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 5.噺据 雌室舛左左奄
	public MemberVO memberContent(String member_no) {
		getConnection();
		String sql = "select * from Member where member_no = ?";
		MemberVO vo = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);
			rs = ps.executeQuery();
			if (rs.next()) {
				member_no = rs.getString("member_no");
				String member_id = rs.getString("member_id");
				String member_pw = rs.getString("member_pw");
				String member_name = rs.getString("member_name");
				String member_email = rs.getString("member_email");
				String member_point = rs.getString("member_point");
				String member_step = rs.getString("member_step");
				String item_pw = rs.getString("item_pw");
				vo = new MemberVO();
				vo.setMember_no(member_no);
				vo.setMember_id(member_id);
				vo.setMember_pw(member_pw);
				vo.setMember_name(member_name);
				vo.setMember_email(member_email);
				vo.setMember_point(member_point);
				vo.setMember_step(member_step);
				vo.setItem_pw(item_pw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 6.鯵昔左政匂昔闘 左奄
	public String myPoint(String member_no) {
		getConnection();
		String member_point = null;

		String sql = "select member_point from Member where member_no=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);
			rs = ps.executeQuery();

			if (rs.next()) {
				member_point = rs.getString("member_point");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member_point;
	}

	// 7.蟹税 舘域左奄
	public String myStep(String member_no) {
		getConnection();
		String member_step = null;

		String sql = "select member_step from Member where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);
			rs = ps.executeQuery();

			if (rs.next()) {
				member_step = rs.getString("member_step");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member_step;
	}

	// 8.匂昔闘拭 魚献 舘域 衣舛(蟹税舘域左奄敗呪 戚遂) 1. 蟹税 匂昔闘 select 2. 匂昔闘拭 魚虞 舘域衣舛
	public String stepByPoint(String member_no) {
		
		//蟹税 匂昔闘 select敗呪
		String member_point = myPoint(member_no);
        System.out.println(member_point);
		int myPoint = Integer.parseInt(member_point);
		String member_step = null;

		if (myPoint <= 2) {
			member_step = "1";
		} else if (myPoint <= 4) {
			member_step = "2";
		} else if (myPoint <= 6) {
			member_step = "3";
		} else if (myPoint <= 8) {
			member_step = "4";
		} else if (myPoint <= 10) {
			member_step = "5";
		} else if (myPoint <= 12) {
			member_step = "6";
		} else if (myPoint <= 14) {
			member_step = "7";
		} else if (myPoint <= 16) {
			member_step = "8";
		} else if (myPoint <= 18) {
			member_step = "9";
		} else if (myPoint <= 20) {
			member_step = "10";
		}
		return member_step;
	}

	// 9.匂昔闘 呪舛 吉 板 蟹税 舘域亀 穣汽戚闘(蟹税舘域左奄敗呪 戚遂) 3. 舘域 穣汽戚闘
	public int memberStepUpdate(String member_no) {
		String member_step = stepByPoint(member_no);

		getConnection();
		String sql = "update Member set member_step = ? where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_step);
			ps.setString(2, member_no);

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 10.重硲亜 神檎 end date拭 劾促 穣汽戚闘(古鯵痕呪研 rfid 葵生稽 背亀 吃牛?)
	public int eventEndDateUpdate(String member_no) {
		getConnection();
		String sql = "update Event set event_end=sysdate where member_no=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	//11.event_start, event_duration 溌昔...
	
	
	// 12.薄仙 遭楳掻昔 戚坤闘 左奄_遭楳紫牌左奄---呪舛馬奄..............ばばば 古鯵痕呪拭辞 庚薦亜 赤澗依 旭精汽 壱団操推............ばばばばばばばばばばばばば 戚闇 遭促 公馬畏製
	public int eventList(String member_no, String event_start, int event_duration) {
		getConnection();
		String sql="select count(event_end) from Event where ?<(select sysdate from dual) and (?+?)>(select sysdate from dual) and member_no=?";
		
		//String sql = "select * from Event where ?<(select sysdate from dual) and (?+?)>(select sysdate from dual) and member_no=? order by event_start desc";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, event_start);
			ps.setString(2, event_start);
			ps.setInt(3, event_duration);
			ps.setString(4, member_no);

			rs=ps.executeQuery();
			
			if (rs.next()) {
				cnt=rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 13.戚坤闘_穿端左奄: 薄仙遭楳掻昔戚坤闘+走貝戚坤闘(劾促鎧顕授舛慶: 置悦戚坤闘採斗左奄)
	public List<EventVO> eventGetAllList(MemberVO vo) {

		getConnection();
		String sql = "select * from Event order by event_start desc";

		List<EventVO> list = new ArrayList<EventVO>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				
					String event_no = rs.getString("event_no");
					String event_mgno = rs.getString("event_mgno");
					String event_name = rs.getString("event_name");
					String event_count = rs.getString("event_count");
					String event_point = rs.getString("event_point");
					String event_start = rs.getString("event_start");
					String event_end = rs.getString("event_end");
					String event_duration = rs.getString("event_duration");
				
				// 広壱 眼壱..(VO拭 広壱, arraylist拭 眼壱)
				EventVO evo = new EventVO();
				evo.setEvent_count(event_count);
				evo.setEvent_duration(event_duration);
				evo.setEvent_end(event_end);
				evo.setEvent_mgno(event_mgno);
				evo.setEvent_name(event_name);
				evo.setEvent_no(event_no);
				evo.setEvent_point(event_point);
				evo.setEvent_start(event_start);
				
				
				list.add(evo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 14.因走紫牌 AllList
	public List<NoticeVO> noticeGetAllList() {
		getConnection();
		String sql = "select * from Notice";
		NoticeVO vo = new NoticeVO();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String notice_no = rs.getString("notice_no");
				String notice_name = rs.getString("notice_name");
				String notice_date = rs.getString("notice_date");
				String notice_content = rs.getString("notice_content");
				
				
				
				vo.setNotice_content(notice_content);
				vo.setNotice_date(notice_date);
				vo.setNotice_name(notice_name);
				vo.setNotice_no(notice_no);
				
				list.add(vo);

				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 15.惟獣毒 軒什闘左奄
	public List<BoardVO> BoardGetAllList() {
		getConnection();
		String sql = "select * from Board order by board_date desc";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			ps = conn.prepareStatement(sql);
			
			
			rs = ps.executeQuery();

			while (rs.next()) {
				String board_no = rs.getString("board_no");
				String board_sort = rs.getString("board_sort");
				String board_name = rs.getString("board_name");
				String member_id = rs.getString("member_id");
				String member_no = rs.getString("member_no");
				String board_date = rs.getString("board_date");
				String board_content = rs.getString("board_content");

				// 広壱 眼壱..(VO拭 広壱, arraylist拭 眼壱)
				BoardVO vo = new BoardVO();
				vo.setBoard_content(board_content);
				vo.setBoard_date(board_date);
				vo.setBoard_name(board_name);
				vo.setBoard_no(board_no);
				vo.setBoard_sort(board_sort);
				vo.setMember_id(member_id);
				vo.setMember_no(member_no);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 16.鎧亜 彰 惟獣越 軒什闘左奄
	public List<BoardVO> myBoardGetAllList(String member_no) {
		getConnection();
		String sql = "select board_no, board_name, board_sort, board_date, member_id from Board where member_no=?";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String board_no = rs.getString("board_no");
				String board_name = rs.getString("board_name");
				String board_sort = rs.getString("board_sort");
				String board_date = rs.getString("board_date");
				String member_id = rs.getString("member_id");

				// 広壱 眼壱..(VO拭 広壱, arraylist拭 眼壱)
				BoardVO vo = new BoardVO();
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 17.鎧亜 彰 惟獣越 鎧遂左奄 -薦鯉聖 適遣梅聖獣
	public List<BoardVO> myBoardContent(MemberVO vo, String board_no) {
		getConnection();
		String sql = "select * from Board where member_no=? and board_no=?";

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_no());
			ps.setString(2, board_no);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				board_no = rs.getString("board_no");
				String board_sort = rs.getString("board_sort");
				String board_content = rs.getString("board_content");
				String board_date = rs.getString("board_date");
				String member_id = rs.getString("member_id");

				// 広壱 眼壱..(VO拭 広壱, arraylist拭 眼壱)
				BoardVO bvo = new BoardVO();
				bvo.setBoard_content(board_content);
				bvo.setBoard_date(board_date);
				bvo.setBoard_name(vo.getMember_name());
				bvo.setBoard_no(board_no);
				bvo.setBoard_sort(board_sort);
								
				list.add(bvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 18.惟獣越 肢薦- 肢薦獄動 適遣獣(鎧越幻 肢薦)
	public int myBoardDelete(String board_no, String member_no) {
		getConnection();

		String sql = "delete from Board where board_no=? and member_no=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, board_no);
			ps.setString(2, member_no);

			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 19.惟獣越 呪舛-鎧越左奄拭辞 呪舛獄動 適遣獣
	public int myBoardUpdate(String content,String board_no,String member_no) {
		getConnection();

		String sql = "update Board set board_content=? where member_no=? and board_no=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, member_no);
			ps.setString(3, board_no);

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 20.朝砺壱軒 軒什闘左奄
	public List<CategoryVO> categoryGetAllList() {
		getConnection();
		String sql = "select category_no, category_name from Category";

		List<CategoryVO> list = new ArrayList<CategoryVO>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String category_no = rs.getString("category_no");
				String category_name = rs.getString("category_name");

				// 広壱 眼壱..(VO拭 広壱, arraylist拭 眼壱)
				CategoryVO vo = new CategoryVO();
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 21.遭楳紫牌 砺戚鷺拭辞 sum update馬奄 是背,
	// 1. select 辞搾什刊旋判呪背辞 希廃葵 鋼発
	public String progressSum(String member_no) {
		String sum = null;
		int category1 = 0;
		int category2 = 0;
		int category3 = 0;

		getConnection();

		String sql = "select category1, category2, category3 from Progress where member_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);
			rs = ps.executeQuery();

			if (rs.next()) {
				category1 = Integer.parseInt(rs.getString("category1"));
				category2 = Integer.parseInt(rs.getString("category2"));
				category3 = Integer.parseInt(rs.getString("category3"));
			}
			sum = String.valueOf(category1 + category2 + category3);
			// sum=category1+category2+category3;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return sum;
	}

	// 22-2. 遭楳紫牌 砺戚鷺拭辞 sum update(progressSum敗呪紫遂)
	public int progressUpdate(String member_no) {

		String sum = progressSum(member_no);

		getConnection();
		System.out.println("杯税衣引 " + sum);

		String sql = "update Progress set service_sum = ? where member_no=?";

		try {
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1, sum);
			ps.setString(2, member_no);

			cnt = ps.executeUpdate();

			if (cnt > 0) {
				System.out.println("穣汽戚闘 失因");
			} else {
				System.out.println("穣汽戚闘 叔鳶");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 23.朝砺壱軒紺 遭楳紫牌軒什闘左奄
	public List<ProgressVO> progressGetList(String member_no) {
		getConnection();
		String sql = "select * from Progress where member_no=?";

		List<ProgressVO> list = new ArrayList<ProgressVO>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member_no);

			rs = ps.executeQuery();
			if (rs.next()) {
				String service_sum = rs.getString("service_sum");
				String category1 = rs.getString("category1");
				String category2 = rs.getString("category2");
				String category3 = rs.getString("category3");

				// 広壱 眼壱..(VO拭 広壱, arraylist拭 眼壱)
				ProgressVO vo = new ProgressVO();
				vo.setMember_no(member_no);
				vo.setService_sum(service_sum);
				vo.setCategory1(category1);
				vo.setCategory2(category2);
				vo.setCategory3(category3);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	
	// 24.噺据紺 左政庭肉溌昔 軒什闘 -呪遂松眼雁
	
	
	//25.噺据亜脊但拭辞 id溌昔馬奄
	
		public String IdConfirm(MemberVO vo) {
		
		getConnection();
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
		
		
		close();
		return result;
		
		
		
	}
	
		//26.rfid 溌昔
	public String RfidFind(String rfid) {
		getConnection();
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
		
		
		
		close();
		return id;
	}
	
	//27.惟獣毒 越床奄
	
	public int BoardWrite(MemberVO vo,String content, String subject, String sort) {
		
		getConnection();
		int cnt=0;
		String sql="insert into Board(Board_No,Board_Name,Board_Sort,board_content,Member_No,member_id) "
				+ "VALUES(Board_seq.nextval,?,?,?,?,?)";
		System.out.println("name 溌昔 : "+vo.getMember_name());
		System.out.println("content 溌昔 : "+content);
		System.out.println("name 溌昔 : "+vo.getMember_no());
		System.out.println("sort 溌昔 : "+sort);
		
		
		
		
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getMember_name());
			ps.setString(2, sort);			
			ps.setString(3, content);
			ps.setString(4, vo.getMember_no());
			ps.setString(5, vo.getMember_id());
			
			cnt=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("cnt 溌昔 : "+cnt);
		
		close();
		
		return cnt;
		
	}
	
	// 28.噺据 List窒径馬奄
		public List<MemberVO> memberContentList(String member_no) {
			getConnection();
			String sql = "select * from Member where member_no = ?";
			MemberVO vo = null;
			List<MemberVO> list = new ArrayList<MemberVO>();
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, member_no);
				rs = ps.executeQuery();
				if (rs.next()) {
					member_no = rs.getString("member_no");
					String member_id = rs.getString("member_id");
					String member_pw = rs.getString("member_pw");
					String member_name = rs.getString("member_name");
					String member_email = rs.getString("member_email");
					String member_point = rs.getString("member_point");
					String member_step = rs.getString("member_step");
					String item_pw = rs.getString("item_pw");
					
					
					
					
					vo = new MemberVO();
					vo.setMember_no(member_no);
					vo.setMember_id(member_id);
					vo.setMember_pw(member_pw);
					vo.setMember_name(member_name);
					vo.setMember_email(member_email);
					vo.setMember_point(member_point);
					vo.setMember_step(member_step);
					vo.setItem_pw(item_pw);
					
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
				System.out.println("member_no:"+vo.getMember_no());
				System.out.println("member_id:"+vo.getMember_id());
				
				
			}
			return list;
		}
	//29.img爽社 亜閃亜奄
		
		public String GetImage(MemberVO vo) {
			String imageStep=null;
			
			
			
			if(vo.getMember_step().equals("1")) {
				imageStep="/aranoz-master/gom/step1.jpg";								
			}else if(vo.getMember_step().equals("2")) {
				imageStep="/aranoz-master/gom/step2.jpg";								
			}else if(vo.getMember_step().equals("3")) {
				imageStep="/aranoz-master/gom/step2.jpg";								
			}else if(vo.getMember_step().equals("4")) {
				imageStep="/aranoz-master/gom/step2.jpg";								
			}
				
			
			
			
			return imageStep;
		}
	
		//30.遭楳紫牌 妊
		public ProgressVO Progress(MemberVO vo) {
			getConnection();
			ProgressVO pvo = new ProgressVO();
			
			String sql = "select * from progress where member_no =?"; 
			
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getMember_no());
				
				rs=ps.executeQuery();
				if(rs.next()) {
					
					String category1=rs.getString("category1");
					String category2=rs.getString("category2");
					String category3=rs.getString("category3");
					
					int sum=Integer.parseInt(category1)+Integer.parseInt(category2)+Integer.parseInt(category3);
					String service_sum=Integer.toString(sum);
					
					
					pvo.setService_sum(service_sum);
					pvo.setCategory1(category1);
					pvo.setCategory2(category2);
					pvo.setCategory3(category3);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			close();
			return pvo;
			
		}
		
		
		//31.video亜閃神奄
		public String GetVideo(MemberVO vo) {
			String videoStep=null;
			
			
			
			if(vo.getMember_step().equals("1")) {
				videoStep="/aranoz-master/video/1.mp4";								
			}else if(vo.getMember_step().equals("2")) {
				videoStep="/aranoz-master/video/2.mp4";								
			}else if(vo.getMember_step().equals("3")) {
				videoStep="/aranoz-master/video/3.mp4";								
			}else if(vo.getMember_step().equals("4")) {
				videoStep="/aranoz-master/video/4.mp4";								
			}
				
			
			
			
			return videoStep;
		}
		
		public int BoardDelete(MemberVO vo, String boardno) {
			int cnt=0;
			getConnection();
			
			String sql="delete from board where board_no=? and member_no=?";
			
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, boardno);
				ps.setString(2, vo.getMember_no());
				
				cnt=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			close();
			return cnt;
		}

}
