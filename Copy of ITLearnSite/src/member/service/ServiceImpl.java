package member.service;

import member.member.db.MemberBean;
import member.member.db.MemberDAO;

public interface ServiceImpl {
	/*회원 가입*/
	public int InsertMember(MemberBean bean);
	
	/*이메일 중복 검사*/
	public int emailDupChk(String email);

	
	
}
