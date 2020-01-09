package cart.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		caDao = new CartDAO();
		caServ = new CartService();
		caBean = new CartBean();
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
	
	private CartBean getCartBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		 int cart_no = 0;
		 String cart_email = null; 
		 int cart_book1 = 0;
		 int cart_book1_num = 0;
		 int cart_book2 = 0;
		 int cart_book2_num = 0;
		 int cart_book3 = 0; 
		 int cart_book3_num = 0;
		 int cart_book4 = 0;
		 int cart_book4_num = 0; 
		 int cart_book5 = 0; 
		 int cart_book5_num = 0; 
		 int cart_lecture1 = 0; 
		 int cart_lecture1_num = 0; 
		 int cart_lecture2 = 0; 
		 int cart_lecture2_num = 0; 
		 int cart_lecture3 = 0; 
		 int cart_lecture3_num = 0;
		 int cart_lecture4 = 0;
		 int cart_lecture4_num = 0;
		 int cart_lecture5 = 0;
		 int cart_lecture5_num = 0;
		 
		 caBean = new CartBean();
		
		if (request.getParameter("cart_no") != null) {
			cart_no = Integer.parseInt(request.getParameter("cart_no"));
			caBean.setCart_no(cart_no);
			System.out.println("cart_no =" + cart_no);
		}
		if (request.getParameter("cart_email") != null) {
			cart_email = request.getParameter("cart_email");
			caBean.setCart_email(cart_email);
			System.out.println("cart_email =" + cart_email );
		}
		if (request.getParameter("cart_book1") != null) {
			cart_book1 = Integer.parseInt(request.getParameter("cart_book1"));
			caBean.setCart_book1(cart_book1);
			System.out.println("cart_book1 =" + cart_book1);
		}
		if (request.getParameter("cart_book1_num") != null) {
			cart_book1_num = Integer.parseInt(request.getParameter("cart_book1_num"));
			caBean.setCart_book1_num(cart_book1_num);
			System.out.println("cart_book1_num =" + cart_book1_num);
		}
		if (request.getParameter("cart_book2") != null) {
			cart_book2 = Integer.parseInt(request.getParameter("cart_book2"));
			caBean.setCart_book2(cart_book2);
			System.out.println("cart_book2 =" + cart_book2);
		}
		if (request.getParameter("cart_book2_num") != null) {
			cart_book2_num = Integer.parseInt(request.getParameter("cart_book2_num"));
			caBean.setCart_book2_num(cart_book2_num);
			System.out.println("cart_book2_num =" + cart_book2_num);
		}
		if (request.getParameter("cart_book3") != null) {
			cart_book3 = Integer.parseInt(request.getParameter("cart_book3"));
			caBean.setCart_book3(cart_book3);
			System.out.println("cart_book3 =" + cart_book3);
		}
		if (request.getParameter("cart_book3_num") != null) {
			cart_book3_num = Integer.parseInt(request.getParameter("cart_book3_num"));
			caBean.setCart_book3_num(cart_book3_num);
			System.out.println("cart_book3_num =" + cart_book3_num);
		}
		if (request.getParameter("cart_book4") != null) {
			cart_book4 = Integer.parseInt(request.getParameter("cart_book4"));
			caBean.setCart_book4(cart_book4);
			System.out.println("cart_book4 =" + cart_book4);
		}
		if (request.getParameter("cart_book4_num") != null) {
			cart_book4_num = Integer.parseInt(request.getParameter("cart_book4_num"));
			caBean.setCart_book4_num(cart_book4_num);
			System.out.println("cart_book4_num =" + cart_book4_num);
		}
		if (request.getParameter("cart_book5") != null) {
			cart_book5 = Integer.parseInt(request.getParameter("cart_book5"));
			caBean.setCart_book5(cart_book5);
			System.out.println("cart_book5 =" + cart_book5);
		}
		if (request.getParameter("cart_book5_num") != null) {
			cart_book5_num = Integer.parseInt(request.getParameter("cart_book5_num"));
			caBean.setCart_book5_num(cart_book5_num);
			System.out.println("cart_book5_num =" + cart_book5_num);
		}
		
		if (request.getParameter("cart_lecture1") != null) {
			cart_lecture1 = Integer.parseInt(request.getParameter("cart_lecture1"));
			caBean.setCart_lecture1(cart_lecture1);
			System.out.println("cart_lecture1 =" + cart_lecture1);
		}
		if (request.getParameter("cart_lecture1_num") != null) {
			cart_lecture1_num = Integer.parseInt(request.getParameter("cart_lecture1_num"));
			caBean.setCart_lecture1_num(cart_lecture1_num);
			System.out.println("cart_lecture1_num =" + cart_lecture1_num);
		}
		
		if (request.getParameter("cart_lecture2") != null) {
			cart_lecture2 = Integer.parseInt(request.getParameter("cart_lecture2"));
			caBean.setCart_lecture2(cart_lecture2);
			System.out.println("cart_lecture2 =" + cart_lecture2);
		}
		if (request.getParameter("cart_lecture2_num") != null) {
			cart_lecture2_num = Integer.parseInt(request.getParameter("cart_lecture2_num"));
			caBean.setCart_lecture2_num(cart_lecture2_num);
			System.out.println("cart_lecture2_num =" + cart_lecture2_num);
		}
		
		if (request.getParameter("cart_lecture3") != null) {
			cart_lecture3 = Integer.parseInt(request.getParameter("cart_lecture3"));
			caBean.setCart_lecture3(cart_lecture3);
			System.out.println("cart_lecture3 =" + cart_lecture3);
		}
		if (request.getParameter("cart_lecture3_num") != null) {
			cart_lecture3_num = Integer.parseInt(request.getParameter("cart_lecture3_num"));
			caBean.setCart_lecture3_num(cart_lecture3_num);
			System.out.println("cart_lecture3_num =" + cart_lecture3_num);
		}
		
		if (request.getParameter("cart_lecture4") != null) {
			cart_lecture4 = Integer.parseInt(request.getParameter("cart_lecture4"));
			caBean.setCart_lecture4(cart_lecture4);
			System.out.println("cart_lecture4 =" + cart_lecture4);
		}
		if (request.getParameter("cart_lecture4_num") != null) {
			cart_lecture4_num = Integer.parseInt(request.getParameter("cart_lecture4_num"));
			caBean.setCart_lecture4_num(cart_lecture4_num);
			System.out.println("cart_lecture4_num =" + cart_lecture4_num);
		}
		
		if (request.getParameter("cart_lecture5") != null) {
			cart_lecture5 = Integer.parseInt(request.getParameter("cart_lecture5"));
			caBean.setCart_lecture5(cart_lecture5);
			System.out.println("cart_lecture5 =" + cart_lecture5);
		}
		if (request.getParameter("cart_lecture5_num") != null) {
			cart_lecture5_num = Integer.parseInt(request.getParameter("cart_lecture5_num"));
			caBean.setCart_lecture5_num(cart_lecture5_num);
			System.out.println("cart_lecture5_num =" + cart_lecture5_num);
		}
		
		return caBean;
	}
}
