package notice.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.db.NoticeBean;
import notice.db.NoticeDAO;
import notice.service.NoticeService;


public class NoticeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	NoticeBean nBean = null;
	NoticeDAO nDao = null;
	NoticeService nServ = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}
}
