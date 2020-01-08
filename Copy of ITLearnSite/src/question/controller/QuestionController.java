package question.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.db.QuestionBean;
import question.db.QuestionDAO;
import question.service.QuestionService;

public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionBean qBean = null;
	QuestionDAO qDao = null;
	QuestionService qServ = null;

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
			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private QuestionBean getQuestionBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int ques_no = 0;
		String ques_title = null;
		String ques_email = null;
		String ques_pw = null;
		String ques_content = null;
		Timestamp ques_writedate = new Timestamp(System.currentTimeMillis());
		int ques_main_seq = 0;
		int ques_main_tab = 0;
		int ques_sub_seq = 0;
		int ques_readcount = 0;
		
		if(request.getParameter("ques_no") != null)
		{
			ques_no = Integer.parseInt(request.getParameter("ques_no"));
			qBean.setQues_no(ques_no);
			System.out.println("ques_no =" + ques_no);
		}
		if(request.getParameter("ques_title") != null)
		{
			ques_title = request.getParameter("ques_title");
			qBean.setQues_title(ques_title);
			System.out.println("ques_title =" + ques_title);
		}
		if(request.getParameter("ques_email") != null)
		{
			ques_email = request.getParameter("ques_email");
			qBean.setQues_email(ques_email);
			System.out.println("ques_email =" + ques_email);
		}
		if(request.getParameter("ques_pw") != null)
		{
			ques_pw = request.getParameter("ques_pw");
			qBean.setQues_pw(ques_pw);
			System.out.println("ques_pw =" + ques_pw);
		}
		if(request.getParameter("ques_content") != null)
		{
			ques_content = request.getParameter("ques_content");
			qBean.setQues_content(ques_content);
			System.out.println("ques_content =" + ques_content);
		}
		
		qBean.setQues_writedate(ques_writedate);
		System.out.println("ques_writedate =" + ques_writedate);
		
		if(request.getParameter("ques_main_seq") != null)
		{
			ques_main_seq = Integer.parseInt(request.getParameter("ques_main_seq"));
			qBean.setQues_main_seq(ques_main_seq);
			System.out.println("ques_main_seq =" + ques_main_seq);
		}
		if(request.getParameter("ques_main_tab") != null)
		{
			ques_main_tab = Integer.parseInt(request.getParameter("ques_main_tab"));
			qBean.setQues_main_tab(ques_main_tab);
			System.out.println("ques_main_tab =" + ques_main_tab);
		}
		if(request.getParameter("ques_sub_seq") != null)
		{
			ques_sub_seq = Integer.parseInt(request.getParameter("ques_sub_seq"));
			qBean.setQues_sub_seq(ques_sub_seq);
			System.out.println("ques_sub_seq =" + ques_sub_seq);
		}
		if(request.getParameter("ques_readcount") != null)
		{
			ques_readcount = Integer.parseInt(request.getParameter("ques_readcount"));
			qBean.setQues_readcount(ques_readcount);
			System.out.println("ques_readcount =" + ques_readcount);
		}
		return qBean;
	}
}
