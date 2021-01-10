package NorthBears.model;

public class ProgressVO {
	
	private String member_no;
	private String service_sum;
	private String category1;
	private String category2;
	private String category3;
	
	public ProgressVO() {
		super();
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getService_sum() {
		return service_sum;
	}
	public void setService_sum(String service_sum) {
		this.service_sum = service_sum;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public String getCategory3() {
		return category3;
	}
	public void setCategory3(String category3) {
		this.category3 = category3;
	}
	@Override
	public String toString() {
		return "ProgressVO [member_no=" + member_no + ", service_sum=" + service_sum + ", category1=" + category1
				+ ", category2=" + category2 + ", category3=" + category3 + "]";
	}

	

}
