package cart.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDAOImpl implements CartDAO {
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

	public ArrayList<CartBean> getcartlist(String email) {
		ArrayList<CartBean> cartlist=new ArrayList<CartBean>();
		try{
			con=getConnection();
			sql="select * from cart_table where email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			while(rs.next()){
				CartBean cbean = new CartBean();
				cbean.setCart_num(rs.getInt("cart_num"));
				cbean.setEmail(rs.getString("email"));
				cbean.setPro_name(rs.getString("pro_name"));
				cbean.setPro_cnt(rs.getInt("pro_cnt"));
				cbean.setPro_price(rs.getInt("pro_price"));
				cbean.setPro_sort(rs.getString("pro_sort"));
				cartlist.add(cbean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
        closeConnection();  
		}		
		return cartlist;
	}


}