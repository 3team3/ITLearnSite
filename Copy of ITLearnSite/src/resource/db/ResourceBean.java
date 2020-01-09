package resource.db;

import java.sql.Timestamp;

public class ResourceBean {
	private int res_no;
	private String res_title;
	private String res_email;
	private String res_content;
	private String res_filename;
	private Timestamp res_writedate;
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public String getRes_title() {
		return res_title;
	}
	public void setRes_title(String res_title) {
		this.res_title = res_title;
	}
	public String getRes_email() {
		return res_email;
	}
	public void setRes_email(String res_email) {
		this.res_email = res_email;
	}
	public String getRes_content() {
		return res_content;
	}
	public void setRes_content(String res_content) {
		this.res_content = res_content;
	}
	public String getRes_filename() {
		return res_filename;
	}
	public void setRes_filename(String res_filename) {
		this.res_filename = res_filename;
	}
	public Timestamp getRes_writedate() {
		return res_writedate;
	}
	public void setRes_writedate(Timestamp res_writedate) {
		this.res_writedate = res_writedate;
	}
	
	
}
