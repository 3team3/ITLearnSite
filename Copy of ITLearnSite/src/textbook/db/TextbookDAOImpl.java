package textbook.db;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TextbookDAOImpl implements TextbookDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = "";
	Statement stmt = null;

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/oracle");
		return ds.getConnection();
	}

	private void closeConnection() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();

		} catch (SQLException e) {
			System.out.println("closeConnection()메소드에서 오류  : " + e);
		}
	}
	
	@Override
	public TextbookBean bookdetail(int product_no) {
		TextbookBean textBean = new TextbookBean();
		try {
			con = getConnection();
			sql = "select * from book_table where product_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_no);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				System.out.println("TextbookDAOImpl.java");
				System.out.println("----------------------");
				System.out.println("product_no=" + rs.getInt(1));//product_no
				
				String decodeTitle = URLDecoder.decode(rs.getString(2),"utf-8");
				System.out.println("title="+decodeTitle);//title
				
				String decodelink = URLDecoder.decode(rs.getString(3),"utf-8");
				System.out.println("link="+decodelink);//link
				
				String decodeImage = URLDecoder.decode(rs.getString(4),"utf-8");
				System.out.println("img="+decodeImage);//image
				
				System.out.println("author="+rs.getString(5));//author
				
				System.out.println("price="+rs.getInt(6));//price
				
				System.out.println("discount="+rs.getInt(7));//discount
				
				System.out.println("publisher="+rs.getString(8));//publisher
				
				System.out.println("pubdate="+rs.getDate(9));//pubdate
				
				System.out.println("isbn="+rs.getString(10));//isbn
				
				String decodeDescription = URLDecoder.decode(rs.getString(11),"utf-8");
				System.out.println("description="+decodeDescription);//description
				
				System.out.println("stock="+rs.getInt(12));//isbn
				
				textBean.setProduct_no(rs.getInt(1));
				textBean.setBook_title(decodeTitle);
				textBean.setBook_link(decodelink);
				textBean.setBook_image(decodeImage);
				textBean.setBook_author(rs.getString(5));
				textBean.setBook_price(rs.getInt(6));
				textBean.setBook_discount(rs.getInt(7));
				textBean.setBook_publisher(rs.getString(8));
				textBean.setBook_pubdate(String.valueOf(rs.getDate(9)));
				textBean.setBook_isbn(rs.getString(10));
				textBean.setBook_description(decodeDescription);
				textBean.setBook_stock(rs.getInt(12));
				
			}
		} catch (Exception e) {

		} finally {
			closeConnection();
		}
		return textBean;
	}

	@Override
	public int insertBook(TextbookBean tBean) {
		int result = 0;

		try {
			con = getConnection();
			sql = "insert into book_table values(BOOK_PRODUCT_SEQ.nextval,?,?,?,?,?,?,?,To_Date(?, 'yyyymmdd'),?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tBean.getBook_title());
			pstmt.setString(2, tBean.getBook_link());
			pstmt.setString(3, tBean.getBook_image());
			pstmt.setString(4, tBean.getBook_author());
			pstmt.setInt(5, tBean.getBook_price());
			pstmt.setInt(6, tBean.getBook_price());
			pstmt.setString(7, tBean.getBook_publisher());
			pstmt.setString(8, tBean.getBook_pubdate());
			pstmt.setString(9, tBean.getBook_isbn());
			pstmt.setString(10, tBean.getBook_description());
			pstmt.setInt(11, tBean.getBook_stock());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 : " + e);
		} finally {
			closeConnection();
		}
		return result;
	}

	@Override
	public ArrayList<TextbookBean> selectBookList(TextbookBean tBean) {
		ArrayList<TextbookBean> list = new ArrayList<TextbookBean>();
		try {
			con = getConnection();
			sql = "select * from book_table";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("TextbookDAOImpl.java");
				System.out.println("----------------------");
				System.out.println("product_no=" + rs.getInt(1));//product_no
				System.out.println("title="+rs.getString(2));//title
				System.out.println("link="+rs.getString(3));//link
				System.out.println("img="+rs.getString(4));//image
				System.out.println("author="+rs.getString(5));//author
				System.out.println("price="+rs.getInt(6));//price
				System.out.println("discount="+rs.getInt(7));//discount
				System.out.println("publisher="+rs.getString(8));//publisher
				System.out.println("pubdate="+rs.getDate(9));//pubdate
				System.out.println("isbn="+rs.getString(10));//isbn
				System.out.println("description="+rs.getString(11));//description
				System.out.println("book_stock=" + rs.getString(12));//bookstock
				
				TextbookBean textBean = new TextbookBean();
				textBean.setProduct_no(rs.getInt(1));
				textBean.setBook_title(rs.getString(2));
				textBean.setBook_link(rs.getString(3));
				textBean.setBook_image(rs.getString(4));
				textBean.setBook_author(rs.getString(5));
				textBean.setBook_price(rs.getInt(6));
				textBean.setBook_discount(rs.getInt(7));
				textBean.setBook_publisher(rs.getString(8));
				textBean.setBook_pubdate(String.valueOf(rs.getDate(9)));
				textBean.setBook_isbn(rs.getString(10));
				textBean.setBook_description(rs.getString(11));
				textBean.setBook_stock(rs.getInt(12));
				list.add(textBean);
			}
		} catch (Exception e) {

		} finally {
			closeConnection();
		}
		return list;
	}
}
