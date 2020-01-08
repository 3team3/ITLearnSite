package textbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			if (nextPage != null) 
			{
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

