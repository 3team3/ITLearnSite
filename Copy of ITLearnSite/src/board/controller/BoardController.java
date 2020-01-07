package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.MemberBean;
import member.db.MemberDAO;
import member.email.JoinMail;
import member.service.MemberService;

public class BoardController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	MemberService serv = null;
	MemberDAO dao = null;
	MemberBean mBean = null;

	int result = 0; // 상태를 나타낼 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("init()");
		serv = new MemberService();
		System.out.println("MemberService() 객체 생성");
		mBean = new MemberBean();
		System.out.println("MemberBean() 객체 생성");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/* ##test code## */
		System.out.println("service()");

		String url = request.getRequestURI();
		System.out.println(url);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		
		try {
			if(path.equals("/boardList.bo"))
			{
				System.out.println("boardList.bo");
				System.out.println("Test");
				nextPage = "/board/BoardList.jsp";
			}
			System.out.println("nextPAge" + nextPage);
			if (nextPage != null) 
			{
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
