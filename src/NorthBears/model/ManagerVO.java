package NorthBears.model;

public class ManagerVO {

	private String manager_no;
	private String manager_id;
	private String manager_pw;
	public ManagerVO(String manager_no, String manager_id, String manager_pw) {
		super();
		this.manager_no = manager_no;
		this.manager_id = manager_id;
		this.manager_pw = manager_pw;
	}
	
	
	public ManagerVO(String manager_no) {
		super();
		this.manager_no = manager_no;
	}


	public String getManager_no() {
		return manager_no;
	}
	public void setManager_no(String manager_no) {
		this.manager_no = manager_no;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_pw() {
		return manager_pw;
	}
	public void setManager_pw(String manager_pw) {
		this.manager_pw = manager_pw;
	}
	public ManagerVO() {
		super();
	}
	@Override
	public String toString() {
		return "ManagerVO [manager_no=" + manager_no + ", manager_id=" + manager_id + ", manager_pw=" + manager_pw
				+ "]";
	}

	
}
