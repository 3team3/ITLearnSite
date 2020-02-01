package question.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import question.db.QuestionBean;
	
	public class QuestionDAOImpl implements QuestionDAO {
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
	    


	//새 글번호 검색
	private int getNewNo(){
		try {
			con = getConnection();
			String query = "SELECT  max(ques_no) from question_table ";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next())
				return (rs.getInt(1) + 1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeConnection();
		}
		return 0;
	}
	
	//글쓰기
	@Override
	public int insertQuestion(QuestionBean qBean){
		int ques_no = getNewNo();
		try {
			con = getConnection();
			int ques_parentno = qBean.getQues_parentno();
			String ques_title = qBean.getQues_title();
			String ques_email = qBean.getQues_email();
			String ques_content = qBean.getQues_content();
			int ques_readconut = 0;
			String isSecret = qBean.getIsSecret();
			String isNotice = qBean.getIsNotice();
			int ques_ref = qBean.getQues_ref(); 
			String ques_parentemail = qBean.getQues_parentemail();
			
			
			String query = "INSERT INTO question_table (QUES_NO, QUES_PARENTNO, QUES_TITLE, QUES_EMAIL, QUES_CONTENT, QUES_READCOUNT, ISSECRET, ISNOTICE, QUES_REF, QUES_PARENTEMAIL)"
					+ " VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			
			if(ques_parentno == 0) {
				ques_ref = ques_no;
				ques_parentemail = ques_email;
			}
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ques_no);
			pstmt.setInt(2, ques_parentno);
			pstmt.setString(3, ques_title);
			pstmt.setString(4, ques_email);
			pstmt.setString(5, ques_content);
			pstmt.setInt(6, ques_readconut);
			pstmt.setString(7, isSecret);
			pstmt.setString(8, isNotice);
			pstmt.setInt(9, ques_ref);
			pstmt.setString(10, ques_parentemail);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertQuestion메소드에서 오류 :" + e);
		} finally{
			closeConnection();
		}
		return ques_no;
	}
	
	//글수정
	@Override
	public void updateQuestion(QuestionBean qBean){
		
		int ques_no = qBean.getQues_no();
		String ques_title = qBean.getQues_title();
		String ques_content = qBean.getQues_content();
		String isSecret = qBean.getIsSecret();
		
		try {
			con = getConnection();
			String query = "update question_table set ques_title=?, ques_content=?, isSecret=?"
						+ ", ques_writedate=sysdate where ques_no=?";

			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ques_title);
			pstmt.setString(2, ques_content);
			pstmt.setString(3, isSecret);
			pstmt.setInt(4, ques_no);
			pstmt.executeUpdate();
			 
		} catch (Exception e) {
			System.out.println("updateQuestion메소드에서 오류 :" + e);
		} finally{
			closeConnection();
		}
	}
	
	//글 내용 보기
	@Override
	public QuestionBean questionView(int ques_no) {
		QuestionBean qBean = new QuestionBean();
		try {
			con = getConnection();
			String sql = "select * from question_table where ques_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ques_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qBean.setQues_no(ques_no);
				qBean.setQues_title(rs.getString("ques_title"));
				qBean.setQues_email(rs.getString("ques_email"));
				qBean.setQues_content(rs.getString("ques_content"));
				qBean.setIsSecret(rs.getString("isSecret"));
				qBean.setQues_writedate(rs.getDate("ques_writedate"));
				qBean.setQues_readcount(rs.getInt("ques_readcount"));
			}

		} catch (Exception e) {
			System.out.println("QuestionView()메소드에서 오류 :" + e);
		} finally {
			closeConnection();
		}
		return qBean;
	}

	//글 삭제
	@Override
	public void questionDelete(int ques_no) {
		try {
			// 커넥션풀로부터 커넥션 얻기
			con = getConnection();
			String query = "Delete From question_table where ques_no = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ques_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("questionDelete메소드에서 오류 :" + e);
		} finally {
			closeConnection();
		}
	}
	
	//공지글 가져오기
		@Override
		public List selectNotice() {
			List questionsList1 = new ArrayList();
			try {
				con = getConnection();
				String query = "select * from question_table where isNotice = 'y'";

				System.out.println(query);
				pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {

					int ques_no = rs.getInt("ques_no");
					String ques_title = rs.getString("ques_title");
					String ques_email = rs.getString("ques_email");
					Date ques_writedate = rs.getDate("ques_writedate");
					int ques_readcount = rs.getInt("ques_readcount");
					String isNotice = rs.getString("isNotice");
					String isSecret = rs.getString("isSecret");
					
					QuestionBean bean = new QuestionBean();

					bean.setQues_no(ques_no);
					bean.setQues_title(ques_title);
					bean.setQues_email(ques_email);
					bean.setQues_writedate(ques_writedate);
					bean.setQues_readcount(ques_readcount);
					bean.setIsNotice(isNotice);
					bean.setIsSecret(isSecret);
					
					questionsList1.add(bean);
				}
				
				System.out.println("QuestionsList : " + questionsList1);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
			return questionsList1;
		}
		
		
	//페이징 처리를 위해 공지사항 갯수 가져오기
		private int countNotice(){
			try {
				con = getConnection();
				String query = "select count(*) from question_table where isNotice='y' ";
				System.out.println(query);
				pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery(query);
				if (rs.next())
					return (rs.getInt(1));
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				closeConnection();
			}
			return 0;
		}
		
	//일반글 가져오기
		@Override
		public List selectQuestions(Map pagingMap) {
			List questionsList2 = new ArrayList();

			// 전달 받은 section 값과 pageNum 값을 가져옴
			int section = (Integer) pagingMap.get("section");
			int pageNum = (Integer) pagingMap.get("pageNum");
			int countNotice = countNotice();

			try {
				con = getConnection();
				String query = "select * from ( " + "select ROWNUM as recNum, lvl, "
						+ "ques_no, ques_parentno, ques_title, ques_email, ques_writedate, ques_readcount, isSecret, isNotice, ques_ref, ques_parentemail " + "from (select level as lvl, "
						+ "ques_no, ques_parentno, ques_title, ques_email, ques_writedate, ques_readcount, isSecret, isNotice, ques_ref, ques_parentemail " + "from question_table "
						+ "start with ques_parentno=0 "
						+ "connect by prior ques_no = ques_parentno " + "order siblings by ques_ref desc))"
						+ "where recNum between(?-1)*100+(?-1)*(10-?)+1 " + "and (?-1)*100+?*(10-?)"
						+ "AND isNotice = 'n'";

				// section과 pageNum 값으로 레코드 번호의 범위를 조건으로 정한
				// (이들 값이 각각 1로 전송 시, between 1 and 10이 됨)

				System.out.println(query);

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, section);
				pstmt.setInt(2, pageNum);
				pstmt.setInt(3, countNotice);
				pstmt.setInt(4, section);
				pstmt.setInt(5, pageNum);
				pstmt.setInt(6, countNotice);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {

					int level = rs.getInt("lvl");
					int ques_no = rs.getInt("ques_no");
					int ques_parentno = rs.getInt("ques_parentno");
					String ques_title = rs.getString("ques_title");
					String ques_email = rs.getString("ques_email");
					Date ques_writedate = rs.getDate("ques_writedate");
					int ques_readcount = rs.getInt("ques_readcount");
					String isNotice = rs.getString("isNotice");
					String isSecret = rs.getString("isSecret");
					int ques_ref = rs.getInt("ques_ref");
					String ques_parentemail = rs.getString("ques_parentemail");
					
					QuestionBean bean = new QuestionBean();

					bean.setLevel(level);
					bean.setQues_no(ques_no);
					bean.setQues_parentno(ques_parentno);
					bean.setQues_title(ques_title);
					bean.setQues_email(ques_email);
					bean.setQues_writedate(ques_writedate);
					bean.setQues_readcount(ques_readcount);
					bean.setIsNotice(isNotice);
					bean.setIsSecret(isSecret);
					bean.setQues_ref(ques_ref);
					bean.setQues_parentemail(ques_parentemail);
					
					questionsList2.add(bean);
				}
				System.out.println("QuestionsList : " + questionsList2);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
			return questionsList2;
		}
	
	//전체 글 개수
	@Override
	public int selectTotQuestions() {
		try {
			con = getConnection();
			
			//전체 글 수 조회
			String query = "select count(ques_no) from question_table";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return (rs.getInt(1));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {	
			closeConnection();		
		}
		return 0;	
	}
	
	//조회수 증가
	@Override
	public void updateReadcount(int ques_no){
		try {
			
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			
			conn = getConnection();
			sql = "update question_table set ques_readcount=ques_readcount+1 where ques_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ques_no);	
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();	
		}
		
	}
	
	//자료실 검색
    @Override
    public ArrayList<QuestionBean> questionSelect(HashMap<String, Object> listOpt){
    	
    	 ArrayList<QuestionBean> QuestionList = new ArrayList<QuestionBean>();
    	 String opt=(String)listOpt.get("opt"); //검색옵션
    	 String condition = (String)listOpt.get("condition"); //검색내용
    	 /*int start = (Integer)listOpt.get("start"); //페이지번호
    	 */
    	 
    	 try{
             con = getConnection();  
             
             //0: 제목 //1:내용// 2:글쓴이
             if(opt.equals("0")){
            	 sql="select * from question_table where ques_title LIKE '%' || ? || '%'";
            	 pstmt = con.prepareStatement(sql);
            	 pstmt.setString(1, condition);            	 
            	 rs=pstmt.executeQuery();            	 
             }
             else if(opt.equals("1")){
            	 sql="select * from question_table where ques_content LIKE '%' || ? || '%'";
            	 pstmt = con.prepareStatement(sql);
            	 pstmt.setString(1, condition); 
            	 rs=pstmt.executeQuery(); 
             }
             else if(opt.equals("2")){
            	 sql="select * from question_table where ques_email LIKE '%' || ? || '%'";
            	 pstmt = con.prepareStatement(sql);
            	 pstmt.setString(1, condition); 
            	 rs=pstmt.executeQuery(); 
             }
             
             while(rs.next())
             {QuestionBean qBean= new QuestionBean();
             qBean.setQues_no(rs.getInt("ques_no"));
             qBean.setQues_title(rs.getString("ques_title"));
             qBean.setQues_email(rs.getString("ques_email"));
             qBean.setQues_writedate(rs.getDate("ques_writedate"));             
             QuestionList.add(qBean);
             }             
            
             }catch(Exception e){
                 System.out.println("questionSelect()에서 오류 : " +e);
             }finally{
                 closeConnection();
             }
             return QuestionList;                    
         }
    
    
}

