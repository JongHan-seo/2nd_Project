package NorthBears.model;

public class NoticeVO {
	private String notice_no;
	private String notice_name;
	private String notice_date;
	private String notice_content;
	public NoticeVO() {
		super();
	}
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	@Override
	public String toString() {
		return "NoticeVO [notice_no=" + notice_no + ", notice_name=" + notice_name + ", notice_date=" + notice_date
				+ ", notice_content=" + notice_content + "]";
	}

	
}
