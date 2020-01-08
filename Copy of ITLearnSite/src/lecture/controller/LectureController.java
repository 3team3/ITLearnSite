package lecture.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.db.LectureBean;
import lecture.db.LectureDAO;
import lecture.service.LectureService;


public class LectureController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LectureDAO lDao = null;
	LectureBean lBean = null;
	LectureService lServ = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}
}
