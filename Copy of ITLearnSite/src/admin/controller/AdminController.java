package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import member.db.MemberBean;
import member.db.MemberDAOImpl;
import member.service.MemberServiceImpl;

public class AdminController extends HttpServlet {

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

			// ##########회원리스트########## Start
			else if (path.equals("/memberlist.admin")) 
			{
				List<MemberBean> memberlist = serv.getMemberlist();
				request.setAttribute("memberlist", memberlist);
				nextPage = "/main.jsp";
				paging = "/pages/main/center/admin/memberlist.jsp";
				request.setAttribute("paging", paging);

			}
			// ##########회원리스트########## End
			
			// ##########관리자권한 회원삭제########## Start
			else if(path.equals("/AdminMemberDelete.admin"))
			{		
				if(request.getParameter("email")!=null){
					serv.AdmindeleteMember(request.getParameter("email"));	
				}
				List<MemberBean> memberlist = serv.getMemberlist();
				request.setAttribute("memberlist", memberlist);
				nextPage = "/main.jsp";
				paging = "/pages/main/center/admin/memberlist.jsp";
				request.setAttribute("paging", paging);
				
			}
			// ##########관리자권한 회원삭제########## End
			
			// ##########관리자권한 회원주문정보조회########## Start
			else if(path.equals("/AdminMemberOrder.admin")){
				
				
			}
			// ##########회원주문리스트 조회########## End
			else if(path.equals("/memberorderlist.admin")){
			
				/*List<MemberBean> memberlist = serv.getMemberlist();
				request.setAttribute("memberlist", memberlist);*/
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/admin/memberorderlist.jsp";
				request.setAttribute("paging", paging);
			}
			
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

	
}
