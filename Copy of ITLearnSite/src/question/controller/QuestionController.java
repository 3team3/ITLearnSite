package question.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.db.QuestionBean;
import question.db.QuestionDAO;
import question.service.QuestionService;


public class QuestionController extends HttpServlet{
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
		
		
	}
}

