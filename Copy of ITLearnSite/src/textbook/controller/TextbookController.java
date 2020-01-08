package textbook.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import textbook.db.TextbookBean;
import textbook.db.TextbookDAO;
import textbook.service.TextbookService;


public class TextbookController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	TextbookDAO tDao = null;
	TextbookService tSerc = null;
	TextbookBean tBean = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}
}

