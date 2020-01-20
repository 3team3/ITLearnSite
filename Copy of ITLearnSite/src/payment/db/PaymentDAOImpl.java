package payment.db;

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

import member.db.MemberBean;

public class PaymentDAOImpl implements PaymentDAO {
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
    
    //전체 주문 목록 조회
    @Override
    public List<PaymentBean> getPaymentlist(){
    	List<PaymentBean> paymentList = new ArrayList<PaymentBean>();
        try{
            con = getConnection();
            sql = "select * from payment_table";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            	PaymentBean paymentBean = new PaymentBean();
            	
            	//paymentBean.setEmail(rs.getString("email"));
            	
            	paymentList.add(paymentBean);
            	
            }                    
        }catch(Exception e){
                System.out.println("getPaymentlist()메소드에서 오류 :"+e);
        }finally{
            closeConnection();  
        }
            return paymentList;
    }

  	//회원 주문 확인
    @Override
  	public PaymentBean callPayment(String email){
        PaymentBean pBean = new PaymentBean();
        try{
			con = getConnection();
			String sql ="select * from payment_table where payment_email=?";
			pstmt = con.prepareStatement(sql);
        	pstmt.setString(1, email);
        	rs = pstmt.executeQuery();
        	
        	if(rs.next()){
        		//pBean.setEmail(rs.getString("email"));
        		
        	}
			
		}catch(Exception e){
			System.out.println("callPayment()메소드에서 오류 :"+e);
		}finally{
			closeConnection(); 
		}
		return pBean;
    }
  	
  	//회원 주문 수정
    @Override
  	public void updatePayment(PaymentBean pBean){
    	try{
			con = getConnection();
			
			//String sql = "update payment_table set 열이름=? where email=?";
		
			//pstmt = con.prepareStatement(sql);
	
			//pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("updatePayment()메소드에서 오류 : "+e);
			
		}finally{
			closeConnection();  			
		}
    }
  	
  	//회원 주문 하기
    @Override
  	public void insertPayment(PaymentBean pBean){
    	try{
			con = getConnection();
			//sql = "insert into payment_table(열이름) values(?)";
	        //pstmt = con.prepareStatement(sql);
	        
	        //pstmt.setString(1, mBean.getEmail());
			pstmt.executeUpdate();	        
		} 
		catch (Exception e) 
		{
			System.out.println("insertPayment()메소드에서 오류 : "+e);
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
    }
  	
  	//회원 주문 취소
    @Override
  	public void deletePayment(String email){
    	try{	         
	  		 con = getConnection();
			 pstmt = con.prepareStatement("delete from payment_table where payment_email = ?");		     
		     pstmt.setString(1, email.trim());
		     pstmt.executeUpdate();
    	}catch(Exception e){
	    	   System.out.println("deletePayment()메소드에서 오류 :"+e);
	    }finally{
	    	   closeConnection();  			
	    }
    }
}

