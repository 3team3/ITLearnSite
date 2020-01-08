package comments.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.db.CommentsBean;
import comments.db.CommentsDAO;
import comments.service.CommentsService;




public class CommentsController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	CommentsService cServ = null;
	CommentsDAO cDao = null;
	CommentsBean cBean = null;

	int result = 0; // 상태를 나타낼 변수
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}
}
