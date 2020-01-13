package resource.db;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ResourceBean {
	private int res_no, level;
	private int res_parentno;
	private String res_title;
	private String res_email;
	private String res_content;
	private String res_filename;
	private Date res_writedate;
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getRes_parentno() {
		return res_parentno;
	}
	public void setRes_parentno(int res_parentno) {
		this.res_parentno = res_parentno;
	}
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
		try {
			if(res_filename!=null && res_filename.length()!=0) {
				this.res_filename = URLEncoder.encode(res_filename, "UTF-8");  //파일이름에 특수문자가 있을 경우 인코딩합니다.
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public Date getRes_writedate() {
		return res_writedate;
	}
	public void setRes_writedate(Date res_writedate) {
		this.res_writedate = res_writedate;
	}
		
	
}
