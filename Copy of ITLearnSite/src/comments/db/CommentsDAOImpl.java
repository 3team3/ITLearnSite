package comments.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentsDAOImpl implements CommentsDAO {
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
    public int getCommentsNo() {
    	int check = 0;
    	try 
    	{
    		con = getConnection();
    	 	sql = "select min(co_no) from resource_comments where res_no = ?";
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next())
    		{
    			//쿼리 조회해서 결과가 있을 때
    			check = rs.getInt(1)+1;
    		}
    		else
    		{
    			//쿼리 조회해서 결과가 없을 때 = 댓글이 없을 때
    			check = 1;
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	finally{
    		closeConnection();
    	}
    	return check;
    }
    
    //댓글 쓰기 작업
    @Override
    public int insertComments(CommentsBean cBean) {
    	int check = 0;
    	try 
    	{
			con = getConnection();
			//co_no, res_no, co_email, co_date, co_content
			sql = "insert into resource values(?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cBean.getCo_no()+1);
			pstmt.setInt(2, cBean.getRes_no());
			pstmt.setString(3, cBean.getCo_email());
			pstmt.setString(4, cBean.getCo_content());
			
			check = pstmt.executeUpdate();
			
			if(check == 1)
			{
				//executeUpdate 의 리턴값이 1일 때
				check = 1;
			}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		//트랜젝션 반환
    		closeConnection();
    	}
    	return check;
    }
}
