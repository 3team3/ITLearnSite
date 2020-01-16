package lecture.db;

import java.sql.Date;

public class LectureBean {
	private int lec_no, level;
	private int lec_parentno;
	private String lec_title;
	private int lec_price;
	private String lec_content;
	private String lec_imgfile;
	private String lec_spofile;
	private Date lec_uploaddate;
	public int getLec_no() {
		return lec_no;
	}
	public void setLec_no(int lec_no) {
		this.lec_no = lec_no;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLec_parentno() {
		return lec_parentno;
	}
	public void setLec_parentno(int lec_parentno) {
		this.lec_parentno = lec_parentno;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public int getLec_price() {
		return lec_price;
	}
	public void setLec_price(int lec_price) {
		this.lec_price = lec_price;
	}
	public String getLec_content() {
		return lec_content;
	}
	public void setLec_content(String lec_content) {
		this.lec_content = lec_content;
	}
	public String getLec_imgfile() {
		return lec_imgfile;
	}
	public void setLec_imgfile(String lec_imgfile) {
		this.lec_imgfile = lec_imgfile;
	}
	public String getLec_spofile() {
		return lec_spofile;
	}
	public void setLec_spofile(String lec_spofile) {
		this.lec_spofile = lec_spofile;
	}
	public Date getLec_uploaddate() {
		return lec_uploaddate;
	}
	public void setLec_uploaddate(Date lec_uploaddate) {
		this.lec_uploaddate = lec_uploaddate;
	}
	
	
	
}
