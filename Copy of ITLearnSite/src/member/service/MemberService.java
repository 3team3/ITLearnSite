package member.service;

import java.util.List;

import member.email.db.MailDAO;
import member.member.db.MemberBean;
import member.member.db.MemberDAO;

public class MemberService implements ServiceImpl{
	
	MemberDAO dao;
	MailDAO mailDAO;
	
	public MemberService() {
		dao = new MemberDAO();
		mailDAO = new MailDAO();
	}	
	//회원가입
	@Override
	public int InsertMember(MemberBean bean) {
		int result = dao.insertMember(bean);
		return result;
	}
	//이메일 중복체크
	@Override
	public int emailDupChk(MemberBean bean) {
		int result = mailDAO.mailDupChk(bean);
		return result;
	}
	//멤버 목록 
	@Override
	public List<MemberBean> getMemberlist() {
		List<MemberBean> listMember = dao.getMemberlist();
		return listMember;
	}
	//회원탈퇴
	@Override
	public int deleteMember(String email) {
		int result = dao.deleteMember(email);
		return result;
	}
}
