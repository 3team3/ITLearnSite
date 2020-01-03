package member.service;

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
	@Override
	public int InsertMember(MemberBean bean) {
		int result = dao.insertMember(bean);
		return result;
	}
	@Override
	public int emailDupChk(String email) {
		int result = mailDAO.mailDupChk(email);
		return result;
	}
}
