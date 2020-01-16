package textbook.db;

import java.sql.Date;

public class TextbookBean {
	private int book_no;
	private String book_title;
	private String book_content;
	private String book_publisher;
	private int book_price;
	private int book_page;
	private String book_filename;
	private Date book_uploaddate;
	
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
	public String getBook_content() {
		return book_content;
	}
	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getBook_page() {
		return book_page;
	}
	public void setBook_page(int book_page) {
		this.book_page = book_page;
	}
	public String getBook_filename() {
		return book_filename;
	}
	public void setBook_filename(String book_filename) {
		this.book_filename = book_filename;
	}
	public Date getBook_uploaddate() {
		return book_uploaddate;
	}
	public void setBook_uploaddate(Date book_uploaddate) {
		this.book_uploaddate = book_uploaddate;
	}
}
