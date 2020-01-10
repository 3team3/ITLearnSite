package lecture.db;

import java.sql.Date;

public class LectureBean {
	private int lec_no;
	private int lec_parentno;
	private String lec_title;	
	private String lec_email;
	private String lec_pw;
	private String lec_content;
	private String lec_filename;
	private Date lec_uploaddate;
	
	public int getLec_parentno() {
		return lec_parentno;
	}
	public void setLec_parentno(int lec_parentno) {
		this.lec_parentno = lec_parentno;
	}
	public void setLec_uploaddate(Date lec_uploaddate) {
		this.lec_uploaddate = lec_uploaddate;
	}
	public int getLec_no() {
		return lec_no;
	}
	public void setLec_no(int lec_no) {
		this.lec_no = lec_no;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public String getLec_email() {
		return lec_email;
	}
	public void setLec_email(String lec_email) {
		this.lec_email = lec_email;
	}
	public String getLec_pw() {
		return lec_pw;
	}
	public void setLec_pw(String lec_pw) {
		this.lec_pw = lec_pw;
	}
	public String getLec_content() {
		return lec_content;
	}
	public void setLec_content(String lec_content) {
		this.lec_content = lec_content;
	}
	public String getLec_filename() {
		return lec_filename;
	}
	public void setLec_filename(String lec_filename) {
		this.lec_filename = lec_filename;
	}
	public Timestamp getLec_uploaddate() {
		return lec_uploaddate;
	}
	public void setLec_uploaddate(Timestamp lec_uploaddate) {
		this.lec_uploaddate = lec_uploaddate;
	}
	
}
