package question.db;

import java.sql.Timestamp;

public class QuestionBean {

	private int ques_no, ques_parentno;
	private String ques_title;
	private String  ques_email;
	private String ques_pw;
	private String  ques_content;
	private Timestamp ques_writedate;
	private int  ques_main_seq;
	private int  ques_main_tab;
	private int  ques_sub_seq; 
	private int  ques_readcount;
	
	public int getQues_parentno() {
		return ques_parentno;
	}
	public void setQues_parentno(int ques_parentno) {
		this.ques_parentno = ques_parentno;
	}
	public int getQues_no() {
		return ques_no;
	}	
	public void setQues_no(int ques_no) {
		this.ques_no = ques_no;
	}
	public String getQues_title() {
		return ques_title;
	}
	public void setQues_title(String ques_title) {
		this.ques_title = ques_title;
	}
	public String getQues_email() {
		return ques_email;
	}
	public void setQues_email(String ques_email) {
		this.ques_email = ques_email;
	}
	public String getQues_pw() {
		return ques_pw;
	}
	public void setQues_pw(String ques_pw) {
		this.ques_pw = ques_pw;
	}
	public String getQues_content() {
		return ques_content;
	}
	public void setQues_content(String ques_content) {
		this.ques_content = ques_content;
	}
	public Timestamp getQues_writedate() {
		return ques_writedate;
	}
	public void setQues_writedate(Timestamp ques_writedate) {
		this.ques_writedate = ques_writedate;
	}
	public int getQues_main_seq() {
		return ques_main_seq;
	}
	public void setQues_main_seq(int ques_main_seq) {
		this.ques_main_seq = ques_main_seq;
	}
	public int getQues_main_tab() {
		return ques_main_tab;
	}
	public void setQues_main_tab(int ques_main_tab) {
		this.ques_main_tab = ques_main_tab;
	}
	public int getQues_sub_seq() {
		return ques_sub_seq;
	}
	public void setQues_sub_seq(int ques_sub_seq) {
		this.ques_sub_seq = ques_sub_seq;
	}
	public int getQues_readcount() {
		return ques_readcount;
	}
	public void setQues_readcount(int ques_readcount) {
		this.ques_readcount = ques_readcount;
	} 
}
