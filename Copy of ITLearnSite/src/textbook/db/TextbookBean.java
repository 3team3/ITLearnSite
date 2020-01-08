package textbook.db;

import java.sql.Timestamp;

public class TextbookBean {
	private int book_no; 
	private String book_title;
	private String book_email;
	private String book_pw;
	private String book_content;
	private String book_filename;
	private Timestamp book_uploaddate;
	
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_email() {
		return book_email;
	}
	public void setBook_email(String book_email) {
		this.book_email = book_email;
	}
	public String getBook_pw() {
		return book_pw;
	}
	public void setBook_pw(String book_pw) {
		this.book_pw = book_pw;
	}
	public String getBook_content() {
		return book_content;
	}
	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}
	public String getBook_filename() {
		return book_filename;
	}
	public void setBook_filename(String book_filename) {
		this.book_filename = book_filename;
	}
	public Timestamp getBook_uploaddate() {
		return book_uploaddate;
	}
	public void setBook_uploaddate(Timestamp book_uploaddate) {
		this.book_uploaddate = book_uploaddate;
	}
	
}
