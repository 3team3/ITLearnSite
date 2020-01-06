package email.emailSend;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public class JoinMail 
{
	String targetMail;
	
	
	public String getTargetMail() {
		return targetMail;
	}
	
	public JoinMail(String targetMail){
		this.targetMail = targetMail;
	}

	public void sendMail() throws UnsupportedEncodingException, MessagingException
	{
		SendMail mail = new SendMail();
		//메일의 출발지 정보 : 본인이메일 셋팅할 내용
		String FROM = "mailtester645@gmail.com";
		String FROMNAME = "강의 사이트";
		String SMTP_USERNAME = "mailtester645@gmail.com";
		String SMTP_PASSWORD = "12345678a!";
		String HOST = "smtp.gmail.com";
		String PORT = "465";
		String AUTH = "true";
		// 클라이언트에게 보낼내용
		String SUBJECT = "강의 사이트에서 발신되는 회원가입 인증메일입니다.";
		String MESSAGE = "회원가입 링크 나중에 달기"; 
		String TARGET = getTargetMail();
		
		/*보안 수준 낮은 앱허용 설정해주어야함 구글은*/
		mail.setServer(FROM, FROMNAME, SMTP_USERNAME, SMTP_PASSWORD, HOST, PORT, AUTH);
		mail.setMessage(SUBJECT, MESSAGE, TARGET);
		mail.set_SSL();
		//mail.set_TSL();	
	}
}
