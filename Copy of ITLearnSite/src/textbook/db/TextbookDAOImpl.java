package textbook.db;

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
      Context envContext =(Context)ctx.lookup("java:/comp/env");
      ds = (DataSource)envContext.lookup("jdbc/oracle");
      return ds.getConnection();
    }
    
    private void closeConnection(){
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
            if(stmt != null) stmt.close();
          
        } catch (SQLException e) {
            System.out.println("closeConnection()메소드에서 오류  : " +e);
        }
    }
    @Override
    public ArrayList<TextbookBean> selectBookList(TextbookBean tBean) {
    	ArrayList<TextbookBean> list = new ArrayList<TextbookBean>();
    	try {
    		con = getConnection();
    		sql = "select * from book";
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		System.out.println("??????????????????????");
    		while(rs.next())
    		{
    			System.out.println("??????????????????????");
    			TextbookBean textBean = new TextbookBean();
    			
    			textBean.setBook_title(rs.getString(1));
    			textBean.setBook_content(rs.getString(2));
    			textBean.setBook_publisher(rs.getString(3));
    			textBean.setBook_price(rs.getInt(4));
    			textBean.setBook_no(rs.getInt(5));
    			textBean.setBook_page(rs.getInt(6));
    			textBean.setBook_filename(rs.getString(7));
     			textBean.setBook_uploaddate(rs.getDate(8));
     			
     			System.out.println(rs.getString(1));
     			
     			list.add(textBean);
    		}
    	}catch(Exception e) {
    		
    	}finally {
			closeConnection();
		}
    	for(int i = 0 ; i< list.size(); i++)
    	{
    		System.out.println("dao 책이름 : " + list.get(i).getBook_title());
    	}
    	return list;
    }
}

