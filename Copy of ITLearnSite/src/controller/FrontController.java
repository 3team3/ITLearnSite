package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.member.db.MemberBean;
import member.member.db.MemberDAO;
import member.service.MemberService;
public class FrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	MemberService serv= null;
	MemberDAO dao = null;
	MemberBean mBean = null;
	
	int result = 0; // 상태를 나타낼 변수
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		serv = new MemberService();
		mBean = new MemberBean();

	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*##test code##*/
	    System.out.println("service()");
		
		
		String url = request.getRequestURI();
		System.out.println(url);
		
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		MemberDAO memberDao =null;
		try 
		{
			if(path == null){
				nextPage = "/index.jsp";
			}else if(path.equals("/joinMember.do")){
				//header.jsp의 회원가입 버튼을 누를 때 (${path}/joinMember.do)
				nextPage = "/member/join.jsp";
			}else if(path.equals("/insertMember.do")){
				
				System.out.println("insertMember.do1");
				//joinMember.do(회원가입 페이지에서 submit할 때)
				mBean = insertMember(request, response);
				
				System.out.println("insertMember.do2" + mBean.getAddress());
				
				result = serv.InsertMember(mBean);
				System.out.println("insertMember.do3");
				System.out.println("데이터베이스 insert결과 1이면 성공 0 실패 = " + result);
				nextPage = "/main.jsp";
			}else if(path.equals("/emailDupChk.do")){
				String email = emailDupChk(request, response);
				result = serv.emailDupChk(email);
				System.out.println(result);
				
				PrintWriter out = response.getWriter();
				if(result == 1){
					out.print(1);
				}else if(result == 0){
					out.print(2);
				}
			}
			else if(path.equals("/index.do")){
				nextPage = "/main.jsp";
			}else if(path.equals("/memberlist.do")){
				memberDao = new MemberDAO();
				List<MemberBean> memberlist = memberDao.getMemberlist();
				
				request.setAttribute("memberlist", memberlist);
				nextPage = "/member/memberlist.jsp";
				
			}else if(path.equals("/login.do")){
				nextPage="/member/login.jsp";
			}else if(path.equals("/login1.do")){
				String email = request.getParameter("email");
				String pw = request.getParameter("pw");
				
				MemberDAO mDao = MemberDAO.getInstance();
				int loginResult = mDao.login(email, pw);
				
				if (loginResult == 1){
					request.setAttribute("loginResult", loginResult);
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("loginResult", loginResult);
					RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
					rd.forward(request, response);
				}
				nextPage="/main.jsp";
			}else if(path.equals("/logout.do")){
				HttpSession session = request.getSession();
				session.invalidate();
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);		
			}else if(path.equals("/MemberDeleteAction.do")){
				nextPage="/member/memberDelete.jsp";
			}else if(path.equals("/MemberDeleteAction1.do")){
				/*String email = (String)request.getAttribute("email"); 
				System.out.println(email);
			    memberDao= new MemberDAO();
			    int check = dao.deleteMember(email);		
					
				if(check !=0){			
					HttpSession session = request.getSession();
					session.invalidate();			
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('탈퇴되었습니다');");		
					out.println("window.location.href='/ITLearnSite/main.jsp'");
					out.println("</script>");
					out.close();
				}else{
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out=response.getWriter();
						out.println("<script>");
						out.println("alert('탈퇴실패');");
						out.println("history.back();");
						out.println("</script>");
						out.close();		*/
				}
				nextPage="/main.jsp";
			}
			
			
			System.out.println(nextPage);
			//null PointException
			if(nextPage != null){
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	private String emailDupChk(HttpServletRequest request, HttpServletResponse response){
		String email = null;
		if(request.getParameter("email") != null){
			email = request.getParameter("email");
		}
		return email;
	}
	private MemberBean insertMember(HttpServletRequest request, HttpServletResponse response){
		String email = null;
		String pw = null;
		String name = null;
		int gender = 0;
		String birth_year = null;
		String birth_month = null;
		String birth_day = null;
		String phonenumber = null;
		String address = null;
		String address1 = null;
		String address2 = null;
		int sms = 0;
		
		// 1. 파라미터 추출
		// 2. 유효성 : 값이 넘어왔는지 여부
		/* 값을 받아왔을 경우에만 처리하기 위해서 */
		if(request.getParameter("email") != null){
			email = request.getParameter("email");
			System.out.println("email =" + email);
		}
		if(request.getParameter("pw1") != null){
			pw = request.getParameter("pw1");
			System.out.println("pw = "+ pw);
		}
		if(request.getParameter("name") != null){
			name = request.getParameter("name");
			System.out.println("name = "+ name);
		}
		if(Integer.parseInt(request.getParameter("gender")) != 0){
			gender = Integer.parseInt(request.getParameter("gender"));
			System.out.println("gender=" + gender);
		}
		if(request.getParameter("birth_year") != null){
			birth_year = request.getParameter("birth_year");
			System.out.println("birthyear = " + birth_year);
		}
		if(request.getParameter("birth_month") != null){
			birth_month = request.getParameter("birth_month");
			System.out.println("birthmonth = "+ birth_month);
		}
		if(request.getParameter("birth_day") != null){
			birth_day = request.getParameter("birth_day");
			System.out.println("birthday = " + birth_day);
		}
		if(request.getParameter("phonenumber") != null){
			phonenumber = request.getParameter("phonenumber");
			System.out.println("phonenubmer = " + phonenumber);
		}
		if(request.getParameter("address") != null){
			address = request.getParameter("address");
			System.out.println("address=" + address);
		}
		if(request.getParameter("address1") != null){
			address1 = request.getParameter("address1");
			System.out.println("address1 = "+address1);
		}
		if(request.getParameter("address2") != null){
			address2 = request.getParameter("address2");
			System.out.println("address2 =" + address2);
		}
		if(Integer.parseInt(request.getParameter("sms")) != 0){
			sms = Integer.parseInt(request.getParameter("sms"));
			System.out.println("sms수신동의 = "+ sms);
		}
		
		//3. VO객체생성 및 바인딩
		mBean = new MemberBean();
		mBean.setEmail(email);
		mBean.setPw(pw);
		mBean.setName(name);
		mBean.setGender(gender);
		mBean.setBirth_year(birth_year);
		mBean.setBirth_month(birth_month);
		mBean.setBirth_day(birth_day);
		mBean.setPhonenumber(phonenumber);
		mBean.setAddress(address);
		mBean.setAddress1(address1);
		mBean.setAddress2(address2);
		mBean.setSms(sms);
		
		return mBean;
	}
}
