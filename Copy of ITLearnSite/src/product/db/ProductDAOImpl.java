package product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO{
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
    //상품 등록
    @Override
    public int addProduct(ProductBean pBean) {
    	int check = 0;
    	int product_no = 0;
    	try 
    	{
    		con = getConnection();
    		//product_no is sequence
    		sql = "insert into product(product_type, product_name, product_price) values(?,?,?)";
    		pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, pBean.getProduct_type());
    		pstmt.setString(2, pBean.getProduct_name());
    		pstmt.setInt(3, pBean.getProduct_price());    		
    		check = pstmt.executeUpdate();
    		
    		System.out.println(check);
    		closeConnection();
    		
    		//insert에 성공하면
    		if(check == 1) {
    			System.out.println("insert성공");
    			//등록된 물품의 product_no를 얻어옴
    			con = getConnection();
    			//숫자가 1~ ..n까지 1씩 증가하기 떄문에
    			sql = "select max(product_no) from product";
    			stmt = con.createStatement();
    			rs = stmt.executeQuery(sql);
    			
    			// 값을 가져왔다면?
    			if(rs.next())
    			{
    				product_no = rs.getInt(1);
    				System.out.println("productno :" +product_no);
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		
    	}
    	finally 
    	{
    		closeConnection();
		}
    	
    	return product_no;
    }
}
