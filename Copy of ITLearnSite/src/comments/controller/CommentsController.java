package comments.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.db.CommentsBean;
import comments.db.CommentsDAOImpl;
import comments.service.CommentsServiceImpl;
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CommentsServiceImpl cServ = null;
	CommentsDAOImpl cDao = null;
	CommentsBean cBean = null;

	int result = 0; // 상태를 나타낼 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {
		cServ = new CommentsServiceImpl();
		cDao = new CommentsDAOImpl();
		cBean = new CommentsBean();
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

		try {
			//댓글 쓰기를 눌렀을 때
			if(path.equals("/commentsWrite.co"))
			{
				int check = 0;
				//print
				System.out.println("/commentsWrite.co");
				//현재글에 대한 정보를 얻어오기
				cBean=getCommentsBeanProperty(request, response);
				//댓글을 insert 시킬 서비스 호출
				System.out.println(cBean.getCo_email());
				System.out.println(cBean.getCo_no());
				System.out.println(cBean.getRes_no());
				System.out.println(cBean.getCo_content());
				
				check = cServ.insertComments(cBean);
				
			}
			System.out.println("nextPAge" + nextPage);
			// null PointException
			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CommentsBean getCommentsBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int co_no = 0;//댓글 번호
		int res_no = 0;//부모글 번호
		String co_email = null;//댓글 다는 사람
		String co_content = null;//댓글 내용

		cBean = new CommentsBean();
		
		if (request.getParameter("co_no") != null) {
			co_no = Integer.parseInt(request.getParameter("co_no"));
			cBean.setCo_no(co_no);
			System.out.println("co_no =" + co_no);
		}
		if (request.getParameter("res_no") != null) {
			res_no = Integer.parseInt(request.getParameter("res_no"));
			cBean.setRes_no(res_no);
			System.out.println("res_no =" + res_no);
		}
		if (request.getParameter("co_email") != null) {
			co_email = request.getParameter("co_email");
			cBean.setCo_email(co_email);
			System.out.println("co_email =" + co_email);
		}
		
		if (request.getParameter("content") != null) {
			co_content = request.getParameter("content");
			cBean.setCo_content(co_content);
			System.out.println("content =" + co_content);
		}
		return cBean;
	}
}
