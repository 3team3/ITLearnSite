package member.member.db;

import java.util.List;



public interface MemberDAOImpl{
	
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
}
