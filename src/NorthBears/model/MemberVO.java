package NorthBears.model;

public class MemberVO {
	private String member_no;
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_email;
	private String member_point;
	private String member_step;
	private String member_rf;
	private String member_qr;
	private String item_pw;

	
	public MemberVO(String member_no) {
		super();
		this.member_no = member_no;
	}
	public String getItem_pw() {
		return item_pw;
	}
	public void setItem_pw(String item_pw) {
		this.item_pw = item_pw;
	}
	public String getMember_rf() {
		return member_rf;
	}
	public void setMember_rf(String member_rf) {
		this.member_rf = member_rf;
	}
	public String getMember_qr() {
		return member_qr;
	}
	public void setMember_qr(String member_qr) {
		this.member_qr = member_qr;
	}
	public MemberVO() {
		super();
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
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_point() {
		return member_point;
	}
	public void setMember_point(String member_point) {
		this.member_point = member_point;
	}
	public String getMember_step() {
		return member_step;
	}
	public void setMember_step(String member_step) {
		this.member_step = member_step;
	}
	@Override
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_email=" + member_email + ", member_point=" + member_point
				+ ", member_step=" + member_step + "]";
	}

	
	
}
