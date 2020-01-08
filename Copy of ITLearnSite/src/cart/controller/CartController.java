package cart.controller;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.db.CartBean;
import cart.db.CartDAO;
import cart.service.CartService;


public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CartDAO caDao = null;
	CartService caServ = null;
	CartBean caBean = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	}
}
