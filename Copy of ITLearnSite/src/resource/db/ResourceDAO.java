package resource.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.db.MemberBean;


public class ResourceDAO implements ResourceDAOImpl{
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
            System.out.println("closeConnection()메소드에서 오류 : " +e);
        }
    }
    
    //자료실 내용
    @Override
    public ResourceBean resourceView(int res_no){
    	ResourceBean rBean = new ResourceBean();
  		try{
  			con = getConnection();
  			String sql ="select * from resource_table where res_no=?";
  			pstmt = con.prepareStatement(sql);
  	        pstmt.setInt(1, res_no);
  	        rs = pstmt.executeQuery();
  	        if(rs.next()){
  	        	rBean.setRes_no(res_no);
  	        	rBean.setRes_title(rs.getString("res_title"));
  	        	rBean.setRes_email(rs.getString("res_email"));
  	        	rBean.setRes_content(rs.getString("res_content"));
  	        	rBean.setRes_filename(rs.getString("res_filename"));
  	        	rBean.setRes_writedate(rs.getTimestamp("res_writedate"));
  	        }
  				
  			}catch(Exception e){
  				System.out.println("callMember()메소드에서 오류 :"+e);
  			}finally{
  				closeConnection(); 
  			}
  			return rBean;
  		}
    
    //자료실 내용 삭제
    public void resourceDelete(int res_no){		
		try {
			//커넥션풀로부터 커넥션 얻기
			con = getConnection();
			String query="Delete From resource_table where res_no = ?";	
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, res_no);
			pstmt.executeUpdate();			
		}catch(Exception e){
			System.out.println("resourceDelete메소드에서 오류 :"+e);
		}finally{
			closeConnection(); 
		}
		
	}
}
