package NorthBears.model;

public class EventVO {

	private String event_no;
	private String event_mgno;
	private String event_name;
	private String event_count;
	private String event_point;
	private String event_start;
	private String event_end;
	private String event_duration;
	private String member_no;

	
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public EventVO() {
		super();
	}
	public String getEvent_no() {
		return event_no;
	}
	public void setEvent_no(String event_no) {
		this.event_no = event_no;
	}
	public String getEvent_mgno() {
		return event_mgno;
	}
	public void setEvent_mgno(String event_mgno) {
		this.event_mgno = event_mgno;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_count() {
		return event_count;
	}
	public void setEvent_count(String event_count) {
		this.event_count = event_count;
	}
	public String getEvent_point() {
		return event_point;
	}
	public void setEvent_point(String event_point) {
		this.event_point = event_point;
	}
	public String getEvent_start() {
		return event_start;
	}
	public void setEvent_start(String event_start) {
		this.event_start = event_start;
	}
	public String getEvent_end() {
		return event_end;
	}
	public void setEvent_end(String event_end) {
		this.event_end = event_end;
	}
	public String getEvent_duration() {
		return event_duration;
	}
	public void setEvent_duration(String event_duration) {
		this.event_duration = event_duration;
	}
	@Override
	public String toString() {
		return "EventVO [event_no=" + event_no + ", event_mgno=" + event_mgno + ", event_name=" + event_name
				+ ", event_count=" + event_count + ", event_point=" + event_point + ", event_start=" + event_start
				+ ", event_end=" + event_end + ", event_duration=" + event_duration + "]";
	}

	
	
}
