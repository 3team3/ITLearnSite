package textbook.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import textbook.db.TextbookBean;
import textbook.db.TextbookDAOImpl;
import textbook.service.TextbookServiceImpl;

public class TextbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TextbookDAOImpl tDao = null;
	TextbookServiceImpl tSerc = null;
	TextbookBean tBean = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		tDao = new TextbookDAOImpl();
		tSerc = new TextbookServiceImpl();
		tBean = new TextbookBean();
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

	private TextbookBean getTextbookBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int book_no = 0;
		String book_title = null;
		String book_email = null;
		String book_pw = null;
		String book_content = null;
		String book_filename = null;
		Timestamp book_uploaddate = new Timestamp(System.currentTimeMillis());;
		
		if(request.getParameter("book_no") != null)
		{
			book_no = Integer.parseInt(request.getParameter("book_no"));
			tBean.setBook_no(book_no);
			System.out.println("book_no =" + book_no);
		}
		if(request.getParameter("book_title") != null)
		{
			book_title = request.getParameter("book_title");
			tBean.setBook_title(book_title);
			System.out.println("book_title =" + book_title);
		}
		if(request.getParameter("book_email") != null)
		{
			book_email = request.getParameter("book_email");
			tBean.setBook_email(book_email);
			System.out.println("book_email =" + book_email);
		}
		if(request.getParameter("book_pw") != null)
		{
			book_pw = request.getParameter("book_pw");
			tBean.setBook_pw(book_pw);
			System.out.println("book_pw =" + book_pw);
		}
		if(request.getParameter("book_content") != null)
		{
			book_content = request.getParameter("book_content");
			tBean.setBook_content(book_content);
			System.out.println("book_content =" + book_content);
		}
		if(request.getParameter("book_filename") != null)
		{
			book_filename = request.getParameter("book_filename");
			tBean.setBook_filename(book_filename);
			System.out.println("book_filename =" + book_filename);
		}
		
		tBean.setBook_uploaddate(book_uploaddate);
		System.out.println("book_uploaddate =" + book_uploaddate);
		return tBean;
	}
}
