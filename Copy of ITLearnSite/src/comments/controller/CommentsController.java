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
import comments.service.CommentsService;

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
		int co_no = 0;
		int res_no = 0;
		String co_email = null;
		String co_pw = null;
		Date co_date = new Date(System.currentTimeMillis());
		String co_content = null;
		
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
		if (request.getParameter("co_pw") != null) {
			co_pw = request.getParameter("co_pw");
			cBean.setCo_email(co_pw);
			System.out.println("co_pw =" + co_pw);
		}
		
		cBean.setCo_date(co_date);
		System.out.println("co_date =" + co_date);
		
		if (request.getParameter("co_content") != null) {
			co_content = request.getParameter("co_content");
			cBean.setCo_content(co_content);
			System.out.println("co_content =" + co_content);
		}
		return cBean;
	}
}
