package notice.db;

import java.sql.Timestamp;

public class NoticeBean {
	private int noti_no;
	private String noti_title;
	private String noti_email;
	private String noti_pw;
	private String noti_content;
	private Timestamp noti_writedate;
	private int noti_readcount;
	
	public int getNoti_no() {
		return noti_no;
	}
	public void setNoti_no(int noti_no) {
		this.noti_no = noti_no;
	}
	public String getNoti_title() {
		return noti_title;
	}
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	public String getNoti_email() {
		return noti_email;
	}
	public void setNoti_email(String noti_email) {
		this.noti_email = noti_email;
	}
	public String getNoti_pw() {
		return noti_pw;
	}
	public void setNoti_pw(String noti_pw) {
		this.noti_pw = noti_pw;
	}
	public String getNoti_content() {
		return noti_content;
	}
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	public Timestamp getNoti_writedate() {
		return noti_writedate;
	}
	public void setNoti_writedate(Timestamp noti_writedate) {
		this.noti_writedate = noti_writedate;
	}
	public int getNoti_readcount() {
		return noti_readcount;
	}
	public void setNoti_readcount(int noti_readcount) {
		this.noti_readcount = noti_readcount;
	}
	
	
}
