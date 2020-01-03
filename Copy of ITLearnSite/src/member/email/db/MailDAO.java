package member.email.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MailDAO implements MailDAOImpl {
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DataSource ds = null;
    String sql = "";
    Statement stmt = null;
    
    private Connection getConnection() throws Exception {
        Context ctx = new InitialContext();
        ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jspbeginner");
        return ds.getConnection();
    }
    
    private void closeConnection(){
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
            if(stmt != null) stmt.close();
          
        } catch (SQLException e) {
            System.out.println("closeConnection()硫붿냼�뱶�뿉�꽌 �삤瑜�  : " +e);
        }
    }
    
	/*이메일 중복 체크*/
	@Override
	public int mailDupChk(String email) {
		int check = 0;
		try 
		{
			con = getConnection();
			sql = "SELECT COUNT(email) FROM MEMBER WHERE EMAIL=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
		
			
			if(rs.next())
			{
				if(rs.getInt(1) == 1)
				{
					//중복
					check = 1;
					System.out.println("MailDAO 중복case : check" + rs.getInt(1));
				}
				else
				{
					//중복 아님
					check = 0;
					System.out.println("MailDAO 중복아닌case: check" + rs.getInt(1));
				}
				
			}
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return check;
		
	}
}
