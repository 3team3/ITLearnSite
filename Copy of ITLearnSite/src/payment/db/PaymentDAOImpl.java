package payment.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lecture.db.PaylecBean;
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
    
    //전체 주문 목록 조회(관리자)
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
            	paymentBean.setPay_no(rs.getInt("pay_no"));
            	paymentBean.setPay_email(rs.getString("pay_email"));
            	paymentBean.setPay_name(rs.getString("pay_name"));
            	paymentBean.setPay_phonenumber(rs.getString("pay_phonenumber"));
            	paymentBean.setPay_address(rs.getString("pay_address"));
            	paymentBean.setPay_address1(rs.getString("pay_address1"));
            	paymentBean.setPay_address2(rs.getString("pay_address2"));
            	paymentBean.setPay_pro1_name(rs.getString("pay_pro1_name"));
            	paymentBean.setPay_pro1_cnt(rs.getInt("pay_pro1_cnt"));
            	paymentBean.setPay_pro1_price(rs.getInt("pay_pro1_price"));
            	paymentBean.setPay_pro1_sort(rs.getString("pay_pro1_sort"));
            	paymentBean.setPay_pro2_name(rs.getString("pay_pro2_name"));
            	paymentBean.setPay_pro2_cnt(rs.getInt("pay_pro2_cnt"));
            	paymentBean.setPay_pro2_price(rs.getInt("pay_pro2_price"));
            	paymentBean.setPay_pro2_sort(rs.getString("pay_pro2_sort"));          	
            	paymentBean.setPay_pro3_name(rs.getString("pay_pro3_name"));
            	paymentBean.setPay_pro3_cnt(rs.getInt("pay_pro3_cnt"));
            	paymentBean.setPay_pro3_price(rs.getInt("pay_pro3_price"));
            	paymentBean.setPay_pro3_sort(rs.getString("pay_pro3_sort"));         	
            	paymentBean.setPay_pro4_name(rs.getString("pay_pro4_name"));
            	paymentBean.setPay_pro4_cnt(rs.getInt("pay_pro4_cnt"));
            	paymentBean.setPay_pro4_price(rs.getInt("pay_pro4_price"));
            	paymentBean.setPay_pro4_sort(rs.getString("pay_pro4_sort"));          	
            	paymentBean.setPay_pro5_name(rs.getString("pay_pro5_name"));
            	paymentBean.setPay_pro5_cnt(rs.getInt("pay_pro5_cnt"));
            	paymentBean.setPay_pro5_price(rs.getInt("pay_pro5_price"));
            	paymentBean.setPay_pro5_sort(rs.getString("pay_pro5_sort"));
            	paymentBean.setPay_total(rs.getString("pay_total"));
            	paymentBean.setPay_option(rs.getInt("pay_option"));
            	
            	paymentList.add(paymentBean);
            	
            }                    
        }catch(Exception e){
                System.out.println("getPaymentlist()메소드에서 오류 :"+e);
        }finally{
            closeConnection();  
        }
            return paymentList;
    }

  	//회원 전체주문 확인
    @Override
    public List<PaymentBean> callPayment(String email){
    	List<PaymentBean> paymentList = new ArrayList<PaymentBean>();
        try{
            con = getConnection();
            sql = "select * from payment_table where pay_email='"+email+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            	PaymentBean paymentBean = new PaymentBean();
            	paymentBean.setPay_no(rs.getInt("pay_no"));
            	paymentBean.setPay_email(rs.getString("pay_email"));
            	paymentBean.setPay_name(rs.getString("pay_name"));
            	paymentBean.setPay_phonenumber(rs.getString("pay_phonenumber"));
            	paymentBean.setPay_address(rs.getString("pay_address"));
            	paymentBean.setPay_address1(rs.getString("pay_address1"));
            	paymentBean.setPay_address2(rs.getString("pay_address2"));
            	paymentBean.setPay_pro1_name(rs.getString("pay_pro1_name"));
            	paymentBean.setPay_pro1_cnt(rs.getInt("pay_pro1_cnt"));
            	paymentBean.setPay_pro1_price(rs.getInt("pay_pro1_price"));
            	paymentBean.setPay_pro1_sort(rs.getString("pay_pro1_sort"));
            	paymentBean.setPay_pro2_name(rs.getString("pay_pro2_name"));
            	paymentBean.setPay_pro2_cnt(rs.getInt("pay_pro2_cnt"));
            	paymentBean.setPay_pro2_price(rs.getInt("pay_pro2_price"));
            	paymentBean.setPay_pro2_sort(rs.getString("pay_pro2_sort"));          	
            	paymentBean.setPay_pro3_name(rs.getString("pay_pro3_name"));
            	paymentBean.setPay_pro3_cnt(rs.getInt("pay_pro3_cnt"));
            	paymentBean.setPay_pro3_price(rs.getInt("pay_pro3_price"));
            	paymentBean.setPay_pro3_sort(rs.getString("pay_pro3_sort"));         	
            	paymentBean.setPay_pro4_name(rs.getString("pay_pro4_name"));
            	paymentBean.setPay_pro4_cnt(rs.getInt("pay_pro4_cnt"));
            	paymentBean.setPay_pro4_price(rs.getInt("pay_pro4_price"));
            	paymentBean.setPay_pro4_sort(rs.getString("pay_pro4_sort"));          	
            	paymentBean.setPay_pro5_name(rs.getString("pay_pro5_name"));
            	paymentBean.setPay_pro5_cnt(rs.getInt("pay_pro5_cnt"));
            	paymentBean.setPay_pro5_price(rs.getInt("pay_pro5_price"));
            	paymentBean.setPay_pro5_sort(rs.getString("pay_pro5_sort"));
            	paymentBean.setPay_total(rs.getString("pay_total"));
            	paymentBean.setPay_option(rs.getInt("pay_option"));
            	
            	paymentList.add(paymentBean);
            	
            }                    
        }catch(Exception e){
                System.out.println("getPaymentlist()메소드에서 오류 :"+e);
        }finally{
            closeConnection();  
        }
            return paymentList;
    }
  	
  	//회원 주문 하기
    @Override
  	public void insertPayment(PaymentBean pBean){
    	int pay_no;
    	try{
			con = getConnection();
            sql = "select max(pay_no) from payment_table";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                pay_no = rs.getInt(1) + 1;
            }else{
                pay_no = 1;             
            }
			
            //주문 DB
			sql = "insert into payment_table(pay_no,pay_email,pay_name,pay_phonenumber,pay_address,pay_address1,pay_address2,"
            		+ "pay_pro1_name,pay_pro1_cnt,pay_pro1_price,pay_pro1_sort,"
            		+ "pay_pro2_name,pay_pro2_cnt,pay_pro2_price,pay_pro2_sort,"
            		+ "pay_pro3_name,pay_pro3_cnt,pay_pro3_price,pay_pro3_sort,"
            		+ "pay_pro4_name,pay_pro4_cnt,pay_pro4_price,pay_pro4_sort,"
            		+ "pay_pro5_name,pay_pro5_cnt,pay_pro5_price,pay_pro5_sort,"
            		+ "pay_total,pay_option) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        pstmt = con.prepareStatement(sql);
	        
	        pstmt.setInt(1,pay_no);
	        pstmt.setString(2,pBean.getPay_email());
	        pstmt.setString(3,pBean.getPay_name() );
	        pstmt.setString(4,pBean.getPay_phonenumber());
	        pstmt.setString(5,pBean.getPay_address());
	        pstmt.setString(6,pBean.getPay_address1());
	        pstmt.setString(7,pBean.getPay_address2());
	        int j;
	        if(pBean.getPay_pro1_name()!=null){
		        pstmt.setString(8,pBean.getPay_pro1_name());
		        pstmt.setInt(9,pBean.getPay_pro1_cnt());
		        pstmt.setInt(10,pBean.getPay_pro1_price());
		        pstmt.setString(11,pBean.getPay_pro1_sort());
		        j=12;
		      	while(j<28){
		        	pstmt.setString(j,"x");
		        	j++;
					pstmt.setInt(j,0);
					j++;
					pstmt.setInt(j,0);
					j++;
					pstmt.setString(j,"x");
					j++;
		      	}
		      	if(pBean.getPay_pro2_name()!=null){
			        pstmt.setString(12,pBean.getPay_pro2_name());
			        pstmt.setInt(13,pBean.getPay_pro2_cnt());
			        pstmt.setInt(14,pBean.getPay_pro2_price());
			        pstmt.setString(15,pBean.getPay_pro2_sort());
			        j=16;
			      	while(j<28){
			        	pstmt.setString(j,"x");
			        	j++;
						pstmt.setInt(j,0);
						j++;
						pstmt.setInt(j,0);
						j++;
						pstmt.setString(j,"x");
						j++;
			      	}
			      	if(pBean.getPay_pro3_name()!=null){
			        	pstmt.setString(16,pBean.getPay_pro3_name());
					    pstmt.setInt(17,pBean.getPay_pro3_cnt());
					    pstmt.setInt(18,pBean.getPay_pro3_price());
					    pstmt.setString(19,pBean.getPay_pro3_sort());
					    j=20;
				      	while(j<28){
				        	pstmt.setString(j,"x");
				        	j++;
							pstmt.setInt(j,0);
							j++;
							pstmt.setInt(j,0);
							j++;
							pstmt.setString(j,"x");
							j++;
				      	}
				      	if(pBean.getPay_pro4_name()!=null){
			        		pstmt.setString(20,pBean.getPay_pro4_name());
						    pstmt.setInt(21,pBean.getPay_pro4_cnt());
						    pstmt.setInt(22,pBean.getPay_pro4_price());
						    pstmt.setString(23,pBean.getPay_pro4_sort());   
						    j=24;
						    while(j<28){
					        	pstmt.setString(j,"x");
					        	j++;
								pstmt.setInt(j,0);
								j++;
								pstmt.setInt(j,0);
								j++;
								pstmt.setString(j,"x");
								j++;
					      	}
						    if(pBean.getPay_pro5_name()!=null){
			        			pstmt.setString(24,pBean.getPay_pro5_name());
			 			        pstmt.setInt(25,pBean.getPay_pro5_cnt());
			 			        pstmt.setInt(26,pBean.getPay_pro5_price());
			 			        pstmt.setString(27,pBean.getPay_pro5_sort());	
					        }
				      	}
			      	}
		      	} 	
	        }
	        pstmt.setString(28,pBean.getPay_total());
	        pstmt.setInt(29,0);
	        
			pstmt.executeUpdate();	
			
			//장바구니 DB비우기
			sql = "delete from cart_table where email='"+pBean.getPay_email()+"'";
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
			
			
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
			 pstmt = con.prepareStatement("delete from payment_table where pay_email = ?");		     
		     pstmt.setString(1, email.trim());
		     pstmt.executeUpdate();
    	}catch(Exception e){
	    	   System.out.println("deletePayment()메소드에서 오류 :"+e);
	    }finally{
	    	   closeConnection();  			
	    }
    }
    
    //회원 결제 확인
    @Override
    public void updatePayment(int pay_no,int pay_option){
 		try{
			con = getConnection();
			pstmt = con.prepareStatement("update payment_table set pay_option=? where pay_no="+pay_no);
			pstmt.setInt(1, pay_option);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("updatePayment()메소드에서 오류 : "+e);
			
		}finally{
			closeConnection();  			
		}
	
    }
    
    //결제 확인 시 강의리스트 insert
    @Override
    public PaylecBean setPay_lec(int pay_no){
    	PaylecBean plBean = new PaylecBean();
    	int set_no;
    	try{
    		con = getConnection();
    		
    		sql = "select max(set_no) from set_pay_lec_table";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                set_no = rs.getInt(1) + 1;
            }else{
                set_no = 1;             
            }		
    		
            sql = "select * from payment_table where pay_no="+pay_no;
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){		
            	plBean.setSet_no(set_no);
            	plBean.setSet_email(rs.getString("pay_email"));
            	if(rs.getString("pay_pro1_sort").equals("강의"))
            	{
            		plBean.setSet_lec_title(rs.getString("pay_pro1_name"));
            	}
            	if(rs.getString("pay_pro2_sort").equals("강의"))
            	{
            		plBean.setSet_lec_title(rs.getString("pay_pro2_name"));
            	}
            	if(rs.getString("pay_pro3_sort").equals("강의"))
            	{
            		plBean.setSet_lec_title(rs.getString("pay_pro3_name"));
            	}
            	if(rs.getString("pay_pro4_sort").equals("강의"))
            	{
            		plBean.setSet_lec_title(rs.getString("pay_pro4_name"));
            	}
            	if(rs.getString("pay_pro5_sort").equals("강의"))
            	{
            		plBean.setSet_lec_title(rs.getString("pay_pro5_name"));
            	}         	      	         	
            }  
            
            sql = "insert into set_pay_lec_table(set_no,set_email,set_lec_title, set_endDate) values(?,?,?,add_months(sysdate, 1))";
            pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1,plBean.getSet_no());
	        pstmt.setString(2,plBean.getSet_email() );
	        pstmt.setString(3,plBean.getSet_lec_title());	        
	        pstmt.executeUpdate();	
            
		}catch(Exception e){
			System.out.println("setPay_lec()메소드에서 오류 : "+e);
			
		}finally{
			closeConnection();  			
		}
    	return plBean;
    }
}

