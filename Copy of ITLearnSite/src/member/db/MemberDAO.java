package member.db;

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


public class MemberDAO implements MemberDAOImpl{
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DataSource ds = null;
    String sql = "";
    Statement stmt = null;
    private static MemberDAO mDao;
    
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
	
	@Override
	public int insertMember(MemberBean mBean) {
		int check = 0;
		System.out.println(mBean.getEmail() + mBean.getPw());
		try 
		{
			
			con = getConnection();
			sql = "insert into member(email, pw, name, gender, birth_year, birth_month, birth_day, phonenumber, address, address1, address2, sms)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
	        pstmt = con.prepareStatement(sql);
	        
	        pstmt.setString(1, mBean.getEmail());
	        pstmt.setString(2, mBean.getPw());
	        pstmt.setString(3, mBean.getName());
	        pstmt.setInt(4, mBean.getGender());
	        pstmt.setString(5, mBean.getBirth_year());
	        pstmt.setString(6, mBean.getBirth_month());
	        pstmt.setString(7, mBean.getBirth_day());
	        pstmt.setString(8, mBean.getPhonenumber());
	        pstmt.setString(9, mBean.getAddress());
	        pstmt.setString(10, mBean.getAddress1());
	        pstmt.setString(11, mBean.getAddress2());
	        pstmt.setInt(12, mBean.getSms());
	        
	        check = pstmt.executeUpdate();
	        
	        /*test code*/
	        System.out.println("test- MemberDAO- insertMember()");
	        System.out.println(check);
		} 
		catch (Exception e) 
		{
			System.out.println("insertMember()메소드에서 오류 : "+e);
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return check;
		
	}
	
	//전체 회원 정보 조회
    @Override
    public List<MemberBean> getMemberlist(){
    	List<MemberBean> memberList = new ArrayList<MemberBean>();
        try{
            con = getConnection();
            sql = "select * from member";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
            	MemberBean memberBean = new MemberBean();
            	memberBean.setEmail(rs.getString("email"));
            	memberBean.setPw(rs.getString("pw"));
            	memberBean.setName(rs.getString("name"));
            	memberBean.setGender(rs.getInt("gender"));
            	memberBean.setBirth_year(rs.getString("birth_year"));
            	memberBean.setBirth_month(rs.getString("birth_month"));
            	memberBean.setBirth_day(rs.getString("birth_day"));
            	memberBean.setPhonenumber(rs.getString("phonenumber"));
            	memberBean.setAddress(rs.getString("address"));
            	memberBean.setAddress1(rs.getString("address1"));
            	memberBean.setAddress2(rs.getString("address2"));
            	memberBean.setSms(rs.getInt("sms")); 
            	memberList.add(memberBean);
            	
            }                    
        }catch(Exception e){
                System.out.println("getMemberlist()메소드에서 오류 :"+e);
        }finally{
            closeConnection();  
        }
            return memberList;
   }
    
    public static synchronized MemberDAO getInstance() {
		if (mDao == null) {
			mDao = new MemberDAO();
		}
		return mDao;
	}
 
    //회원 로그인
	public int login(String email, String pw) {
		
		try {
			con = getConnection();
			StringBuffer query = new StringBuffer();
			query.append("SELECT pw, auth").append(" FROM member").append(" WHERE email = ?");
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					 //비밀번호 맞음
					if(rs.getString("auth").equals("y"))
					{
						//비번이 ok email ok
						return 1;
					}
					else
					{
						//비번 ok email fail
						return -1;
					}
				} 
				else
				{
					//비번틀림
					return 0;
				}
			}
		
		} catch (Exception e) {
			System.out.println("login()메소드에서 오류 :"+e);	
		
		}finally{
			closeConnection();
		}
		return -1;
	}
	
	//회원탈퇴
	@Override
	public int deleteMember(String email){ 
		   
		   Connection con = null;
	       PreparedStatement pstmt = null;
	       ResultSet rs = null;
	       int check=0;
	       try {	         
	  		 con =getConnection();
			 pstmt = con.prepareStatement("delete from MEMBER where email = ?");		     
		        pstmt.setString(1, email.trim());
		      check = pstmt.executeUpdate(); //쿼리실행으로 삭제된 레코드 수 반환    
	       }catch(Exception e){
	    	   System.out.println("deleteMember()메소드에서 오류 :"+e);
	       }finally{
	    	   closeConnection();  			
	       }
	       return check;
		   
	   }
	//이메일 인증
	@Override
	public void emailAuth(String email) {
		try 
		{
			
			con = getConnection();
			sql = "update member set auth='y' where email=?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, email);
	        pstmt.executeUpdate();
	    
		} 
		catch (Exception e) 
		{
			System.out.println("이메일 인증 오류 : "+e);
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
	}
	
	
	//회원정보 불러오기
		@Override
		public MemberBean callMember(String email) {
			
			Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        MemberBean mBean = new MemberBean();
			
			try{
				con = getConnection();
				String sql ="select * from member where email=?";
				pstmt = con.prepareStatement(sql);
	        	pstmt.setString(1, email);
	        	rs = pstmt.executeQuery();
	        	
	        	if(rs.next()){
	        		mBean.setEmail(rs.getString("email"));
	        		mBean.setPw(rs.getString("pw"));
	        		mBean.setName(rs.getString("name"));
	        		mBean.setGender(rs.getInt("gender"));
	        		mBean.setBirth_year(rs.getString("birth_year"));
	        		mBean.setBirth_month(rs.getString("birth_month"));
	        		mBean.setBirth_day(rs.getString("birth_day"));
	        		mBean.setPhonenumber(rs.getString("phonenumber"));
	        		mBean.setAddress(rs.getString("address"));
	        		mBean.setAddress1(rs.getString("address1"));
	        		mBean.setAddress2(rs.getString("address2"));
	        		mBean.setSms(rs.getInt("sms")); 
	        	}
				
			}catch(Exception e){
				System.out.println("callMember()메소드에서 오류 :"+e);
			}finally{
				closeConnection(); 
			}
			return mBean;
		}
		
		
		//회원정보수정
		@Override
		public int updateMember(MemberBean mBean) {
			int check = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
	 		try{
				con = getConnection();
				
				String sql = "update member set pw=?, name=?, gender=?, "
							+ "birth_year=?, birth_month=?, birth_day=?, phonenumber=?, "
							+ "address=?, address1=?, address2=?, sms=?"
							+ " where email=?";
			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mBean.getPw());
				pstmt.setString(2, mBean.getName());
				pstmt.setInt(3, mBean.getGender());
				pstmt.setString(4, mBean.getBirth_year());
				pstmt.setString(5, mBean.getBirth_month());
				pstmt.setString(6, mBean.getBirth_day());
				pstmt.setString(7, mBean.getPhonenumber());
				pstmt.setString(8, mBean.getAddress());
				pstmt.setString(9, mBean.getAddress1());
				pstmt.setString(10, mBean.getAddress2());
				pstmt.setInt(11, mBean.getSms());
				pstmt.setString(12, mBean.getEmail());

				check = pstmt.executeUpdate();
				
			}catch(Exception e){
				System.out.println("updateMember()메소드에서 오류 : "+e);
				
			}finally{
				closeConnection();  			
			}
			return check;
		}
		
	
}
