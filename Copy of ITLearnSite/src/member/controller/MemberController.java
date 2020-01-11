package member.controller;

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
import member.db.MemberDAOImpl;
import member.email.JoinMail;
import member.service.MemberServiceImpl;

public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	MemberServiceImpl serv = null;
	MemberDAOImpl dao = null;
	MemberBean mBean = null;

	int result = 0; // 상태를 나타낼 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("init()");
		serv = new MemberServiceImpl();
		System.out.println("MemberService() 객체 생성");
		mBean = new MemberBean();
		System.out.println("MemberBean() 객체 생성");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = request.getRequestURI();
		System.out.println(url);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		String paging = null;
		
		try {
			// 인덱스 페이지 요청
			//!-- V-C-V
			if (path == null) 
			{
				nextPage = "/main.jsp";
			} 
			// 기본페이지
			else if (path.equals("/index.do")) 
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/default.jsp";
				request.setAttribute("paging", paging);
<<<<<<< HEAD
=======
			}
			else if(path.equals("/lectures.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/lectures.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/books.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/books.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/resource.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/resource.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/customer.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/customerService.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/mypage.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/mypage.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/admin.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/admin.jsp";
				request.setAttribute("paging", paging);
>>>>>>> refs/remotes/origin/ran
			}
			// 메뉴 - 강의
			else if(path.equals("/lectures.do"))
			{	
				paging = "/pages/main/center/menu/lectures.jsp";
				request.setAttribute("paging", paging);
				nextPage="/main.jsp";
			}
			//메뉴 - 도서
			else if(path.equals("/books.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/books.jsp";
				request.setAttribute("paging", paging);
			}
			
			//메뉴 - 고객센터
			else if(path.equals("/customer.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/customerService.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/mypage.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/mypage.jsp";
				request.setAttribute("paging", paging);
			}
			//관리자
			else if(path.equals("/admin.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/menu/admin.jsp";
				request.setAttribute("paging", paging);
			}
			//고객센터-공지 게시판
			else if(path.equals("/noticelist.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/notice/NoticeList.jsp";
				request.setAttribute("paging", paging);
			}
			//고객센터-문의 게시판
			else if(path.equals("/questionlist.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/question/QuestionList.jsp";
				request.setAttribute("paging", paging);
			}
			//마이 페이지 - 내 강의실
			else if(path.equals("/mylecture.do"))
			{
				nextPage = "/main.jsp";
				request.setAttribute("paging", paging);
			}
			//마이페이지 - 내 주문
			else if(path.equals("/myorder.do"))
			{
				nextPage = "/main.jsp";
				request.setAttribute("paging", paging);
			}
			//고객센터- 주문 수정
			else if(path.equals("/myorderchange.do"))
			{
				nextPage = "/main.jsp";
				request.setAttribute("paging", paging);
			}
			
			// ##########회원가입########## Start
			else if (path.equals("/joinMember.do")) 
			{
				// 회원가입 페이지이동
				nextPage = "/main.jsp";
				paging = "/pages/main/center/member/join.jsp";
				request.setAttribute("paging", paging);
			}
			// 회원가입 페이지에서 중복체크해주는 ajax부분
			else if (path.equals("/emailDupChk.do")) 
			{
				mBean = getMemberBeanProperty(request, response);
				result = serv.emailDupChk(mBean);
				System.out.println(result);

				PrintWriter out = response.getWriter();
				if (result == 1) 
				{
					out.print(1);
				} 
				else if (result == 0) 
				{
					out.print(0);
				}
			}
			// 회원가입시 submit버튼 눌럿을 시 요청
			// 이메일 발송
			else if (path.equals("/insertMember.do")) 
			{
				mBean = getMemberBeanProperty(request, response); // MemberBean에 값을 셋팅해주고 반환해주는 메소드
				result = serv.InsertMember(mBean);// MemberService에 있는 메서드를 호출 // MemberService serv = new
													// MemberService()
				String message = "<a href = " + request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/emailAuth.do?email="+mBean.getEmail()+">" +"링크"+ "</a>";
				JoinMail mail = new JoinMail(mBean.getEmail(), message);
				try {
					mail.sendMail();//메일 전송
				} catch (UnsupportedEncodingException | MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
<<<<<<< HEAD
				nextPage = "/main.jsp";
				paging = "/pages/main/center/member/joinSuccess.jsp";// 회원가입후 회원가입 성공페이지로 이동
				request.setAttribute("paging", paging);
=======
				nextPage = "/pages/main/center/member/joinSuccess.jsp";// 회원가입후 회원가입 성공페이지로 이동
>>>>>>> refs/remotes/origin/ran
			}
			//이메일 인증
			else if(path.equals("/emailAuth.do"))
			{
				//이메일로 온 링크 클릭시 나오는 주소에 email=? 파라미터 값
				String email = request.getParameter("email");
				System.out.println(email);
				serv.emailAuth(email);
				
				nextPage = "/pages/main/center/member/emailAuthSuccess.jsp";
			}
			// ##########회원가입########## End

			// ##########회원리스트########## Start
			else if (path.equals("/memberlist.do")) 
			{
				List<MemberBean> memberlist = serv.getMemberlist();
				request.setAttribute("memberlist", memberlist);
				nextPage = "/pages/main/center/member/memberlist.jsp";

			}
			// ##########회원리스트########## End
			
			// ##########관리자권한 회원삭제########## Start
			else if(path.equals("/AdminMemberDelete.do"))
			{
						
				if(request.getParameter("email")!=null){
					serv.AdmindeleteMember(request.getParameter("email"));	
				}
				List<MemberBean> memberlist = serv.getMemberlist();
				request.setAttribute("memberlist", memberlist);
				nextPage = "/pages/main/center/member/memberlist.jsp";
				
			}
			// ##########관리자권한 회원삭제########## End
			
			// ##########로그인/로그아웃########## Start
			// 로그인 버튼 누를시
			else if (path.equals("/login.do"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/member/login.jsp";
				request.setAttribute("paging", paging);
			} 
			else if (path.equals("/login1.do")) 
			{
				String email = request.getParameter("email");
				String pw = request.getParameter("pw");

				MemberDAOImpl mDao = MemberDAOImpl.getInstance();
				int loginResult = mDao.login(email, pw);
				
				//로그인 성공시
				if (loginResult == 1) 
				{
					request.setAttribute("loginResult", loginResult);
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					
					nextPage = "/main.jsp";
					paging = "/pages/main/center/default.jsp";
					request.setAttribute("paging", paging);
				} 
				//비번 틀렸을 시
				else if(loginResult == 0)
				{
					request.setAttribute("loginResult", loginResult);
					nextPage = "/login.do";
				}
				//비번은 맞고 이메일 인증 안됫을 시
				else if(loginResult == -1) 
				{
					request.setAttribute("loginResult", loginResult);
					nextPage = "/login.do";
				}
			} 
			else if (path.equals("/logout.do")) 
			{
				HttpSession session = request.getSession();
				System.out.println("로그아웃되었습니다.");
				session.invalidate();
				nextPage = "/index.jsp";
			}
			// ##########로그인/로그아웃########## END

			// ##########회원탈퇴 ############## Start
			else if (path.equals("/MemberDeleteAction.do")) 
			{
				nextPage = "/pages/main/center/member/memberDelete.jsp";
			} 
			else if (path.equals("/MemberDeleteAction1.do")) 
			{
				HttpSession session = request.getSession();
				String email = (String) session.getAttribute("email");
				int check = serv.deleteMember(email);

				if (check != 0) 
				{
					session = request.getSession();
					session.invalidate();
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('탈퇴되었습니다');");
					out.println("window.location.href='/ITLearnSite/main.jsp'");
					out.println("</script>");
					out.close();
				} 
				else 
				{
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('탈퇴실패');");
					out.println("history.back();");
					out.println("</script>");
					out.close();
					nextPage = "/main.jsp";
				}
				// ##########회원탈퇴 ############## End
				
				// ##########회원수정 ############## Start
				}
			else if(path.equals("/relogin.do")){
<<<<<<< HEAD
				nextPage = "/main.jsp";
				paging = "/pages/main/center/member/relogin.jsp";
				request.setAttribute("paging", paging);
=======
				nextPage="/pages/main/center/member/relogin.jsp";
>>>>>>> refs/remotes/origin/ran
			}
			else if (path.equals("/relogin1.do")) 
			{
				HttpSession session = request.getSession();
				String email = (String)session.getAttribute("email");
				String pw = request.getParameter("pw");
				System.out.println(email);
				System.out.println(pw);

				MemberDAOImpl mDao = MemberDAOImpl.getInstance();
				int loginResult = mDao.login(email, pw);
				System.out.println(loginResult);
				//로그인 성공시
				if (loginResult == 1) 
				{
					request.setAttribute("loginResult", loginResult);
					nextPage = "main.jsp";
					paging = "/pages/main/center/member/modify.jsp";
					request.setAttribute("paging", paging);
				} 
				//비번 틀렸을 시
				else if(loginResult == 0)
				{
					request.setAttribute("loginResult", loginResult);
					nextPage = "/relogin.do";
				}
			} 
			else if(path.equals("/MemberUpdateAction.do"))
			{
				String email = (String)request.getSession().getAttribute("email"); 
				MemberBean mBean = serv.callMember(email);
				request.setAttribute("mBean", mBean);
				nextPage="/pages/main/center/member/modify.jsp";
			}
			else if(path.equals("/UpdateMember.do")){
				
				getMemberBeanProperty(request, response);
					int check = serv.updateMember(mBean);
					if(check == 1){
						System.out.println("수정성공");
						response.setContentType("text/html; charset=utf-8");
						PrintWriter out = response.getWriter();
						out.println("<script type='text/javascript'>");
						out.println("alert('수정되었습니다.');");
						out.println("</script>");
					}else{
						System.out.println(check);
						System.out.println("수정실패");
					}
					nextPage="/main.jsp";
				}
				// ##########회원수정 ############## End
				
				
				
				
				
			System.out.println("nextPage = " + nextPage);
			// null PointException
			if (nextPage != null) 
			{
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private MemberBean getMemberBeanProperty(HttpServletRequest request, HttpServletResponse response) {
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
		// 3. 받은 request파라미터에만 mBean에 값 셋팅
		mBean = new MemberBean();
		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
			mBean.setEmail(email);
			System.out.println("email =" + email);
		}
		if (request.getParameter("pw1") != null) {
			pw = request.getParameter("pw1");
			mBean.setPw(pw);
			System.out.println("pw = " + pw);
		}
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
			mBean.setName(name);
			System.out.println("name = " + name);
		}
		if (request.getParameter("gender") != null) {
			gender = Integer.parseInt(request.getParameter("gender"));
			mBean.setGender(gender);
			System.out.println("gender=" + gender);
		}
		if (request.getParameter("birth_year") != null) {
			birth_year = request.getParameter("birth_year");
			mBean.setBirth_year(birth_year);
			System.out.println("birthyear = " + birth_year);
		}
		if (request.getParameter("birth_month") != null) {
			birth_month = request.getParameter("birth_month");
			mBean.setBirth_month(birth_month);
			System.out.println("birthmonth = " + birth_month);
		}
		if (request.getParameter("birth_day") != null) {
			birth_day = request.getParameter("birth_day");
			mBean.setBirth_day(birth_day);
			System.out.println("birthday = " + birth_day);
		}
		if (request.getParameter("phonenumber") != null) {
			phonenumber = request.getParameter("phonenumber");
			mBean.setPhonenumber(phonenumber);
			System.out.println("phonenubmer = " + phonenumber);
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address");
			mBean.setAddress(address);
			System.out.println("address=" + address);
		}
		if (request.getParameter("address1") != null) {
			address1 = request.getParameter("address1");
			mBean.setAddress1(address1);
			System.out.println("address1 = " + address1);
		}
		if (request.getParameter("address2") != null) {
			address2 = request.getParameter("address2");
			mBean.setAddress2(address2);
			System.out.println("address2 =" + address2);
		}
		if ((request.getParameter("sms")) != null) {
			sms = Integer.parseInt(request.getParameter("sms"));
			mBean.setSms(sms);
			System.out.println("sms수신동의 = " + sms);
		}
		// 3. mBean 객체 리턴
		return mBean;
	}
}
