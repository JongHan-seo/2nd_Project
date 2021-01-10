package NorthBears.model;

public class BoardVO {

	private String board_no;
	private String board_name;
	private String board_sort;
	private String board_date;
	private String board_content;
	private String member_no;
	private String member_id;
	public BoardVO() {
		super();
	}
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_sort() {
		return board_sort;
	}
	public void setBoard_sort(String board_sort) {
		this.board_sort = board_sort;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_name=" + board_name + ", board_sort=" + board_sort
				+ ", board_date=" + board_date + ", board_content=" + board_content + ", member_no=" + member_no
				+ ", member_id=" + member_id + "]";
	}

	

	
}
