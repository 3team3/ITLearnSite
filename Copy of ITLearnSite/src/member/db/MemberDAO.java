package member.db;

import java.util.List;



<<<<<<< HEAD
public interface MemberDAO{
=======
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
            System.out.println("closeConnection()메소드에서 오류 : " +e);
        }
    }
>>>>>>> refs/remotes/origin/ran
	
	/*회원 추가*/
	public int insertMember(MemberBean mBean);
	/*회원 로그인*/
	public int login(String email, String pw);
	/*회원 탈퇴*/
	public int deleteMember(String email); 
	/*전체 회원 정보 조회*/
	public List<MemberBean> getMemberlist();
	/*email 인증*/
	public void emailAuth(String email);
	/*회원 정보 불러오기*/
	public MemberBean callMember(String email);
	/*회원 수정*/ 
	public int updateMember (MemberBean mBean);
	/*관리자권한 회원삭제*/
	public void AdmindeleteMember(String email);
	
}