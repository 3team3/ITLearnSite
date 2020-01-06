package member.service;

import java.util.List;

import member.member.db.MemberBean;

public interface ServiceImpl {
	/*회원 가입*/
	public int InsertMember(MemberBean bean);
	
	/*이메일 중복 검사*/
	public int emailDupChk(MemberBean bean);

	/*멤버리스트 가져오기*/
	public List<MemberBean> getMemberlist();
	
	/*회원탈퇴*/
	public int deleteMember(String email);
	
	/*이메일 인증 */
	public void emailAuth(String email);
	
}
