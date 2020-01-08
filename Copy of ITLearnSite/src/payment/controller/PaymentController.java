package payment.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.db.PaymentBean;
import payment.db.PaymentDAO;
import payment.service.PaymentService;


public class PaymentController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	PaymentDAO pDao = null;
	PaymentService pServ = null;
	PaymentBean pBean = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}
}
