package lecture.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.db.LectureBean;
import lecture.db.LectureDAO;
import lecture.service.LectureService;

public class LectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LectureDAO lDao = null;
	LectureBean lBean = null;
	LectureService lServ = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		lDao = new LectureDAO();
		lBean = new LectureBean();
		lServ = new LectureService();
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

	private LectureBean getLectureBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int lec_no = 0;
		String lec_title = null;
		String lec_email = null;
		String lec_pw = null;
		String lec_content = null;
		String lec_filename = null;
		Date lec_uploaddate = new Date(System.currentTimeMillis());

		if (request.getParameter("lec_no") != null) {
			lec_no = Integer.parseInt(request.getParameter("lec_no"));
			lBean.setLec_no(lec_no);
			System.out.println("lec_no =" + lec_no);
		}
		if (request.getParameter("lec_title") != null) {
			lec_title = request.getParameter("lec_title");
			lBean.setLec_title(lec_title);
			System.out.println("lec_title =" + lec_title);
		}
		if (request.getParameter("lec_email") != null) {
			lec_email = request.getParameter("lec_email");
			lBean.setLec_email(lec_email);
			System.out.println("lec_email =" + lec_email);
		}
		if (request.getParameter("lec_pw") != null) {
			lec_pw = request.getParameter("lec_pw");
			lBean.setLec_pw(lec_pw);
			System.out.println("lec_pw =" + lec_pw);
		}
		if (request.getParameter("lec_title") != null) {
			lec_title = request.getParameter("lec_title");
			lBean.setLec_title(lec_title);
			System.out.println("lec_title =" + lec_title);
		}
		if (request.getParameter("lec_content") != null) {
			lec_content = request.getParameter("lec_content");
			lBean.setLec_content(lec_content);
			System.out.println("lec_content =" + lec_content);
		}
		if (request.getParameter("lec_filename") != null) {
			lec_filename = request.getParameter("lec_filename");
			lBean.setLec_filename(lec_filename);
			System.out.println("lec_filename =" + lec_filename);
		}
		lBean.setLec_uploaddate(lec_uploaddate);
		System.out.println("lec_uploaddate =" + lec_uploaddate);

		return lBean;
	}
}
