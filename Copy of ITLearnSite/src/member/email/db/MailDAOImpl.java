package member.email.db;

public interface MailDAOImpl {
	/*이메일 중복 체크 */
	public int mailDupChk(String email);
}
