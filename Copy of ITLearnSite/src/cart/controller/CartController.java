package cart.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.db.CartBean;
import cart.db.CartDAOImpl;
import cart.service.CartServiceImpl;


public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CartDAOImpl caDao = null;
	CartServiceImpl caServ = null;
	CartBean caBean = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		caDao = new CartDAOImpl();
		caServ = new CartServiceImpl();
		caBean = new CartBean();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String url = request.getRequestURI();
		System.out.println(url);
		
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		String path = url.substring(contextPath.length());
		System.out.println(path);
		
		String nextPage = null;
		String paging = null;
		
		try {
			if(path.equals("/cart.cart"))//목록보기
			{
				String email = (String)request.getSession().getAttribute("email");
				System.out.println(email);
				ArrayList<CartBean> cartlist=caServ.getcartlist(email);
				request.setAttribute("cartlist", cartlist);
				nextPage = "/main.jsp";
				paging = "/pages/main/center/cart/cart.jsp";
				request.setAttribute("paging", paging);
				
				
			}else if(path.equals("/cartAdd.cart")){//장바구니 넣기
				String email = (String)request.getSession().getAttribute("email");
				int lec_no=Integer.parseInt(request.getParameter("lec_no"));
				String pro_name=request.getParameter("lec_title");
				int pro_price=Integer.parseInt(request.getParameter("lec_price"));				
				System.out.println("장바구니에 넣기");
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/cart/cart.jsp";
				request.setAttribute("paging", paging);
				
			}else if(path.equals("/cartEdit.cart")){//수량변경
				System.out.println("수량변경");	
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('수정되었습니다.');" 
				+ " location.href='cart.cart'" + "</script>");
				return;
				
			}else if(path.equals("/cartDelete.cart")){//삭제
				System.out.println("상품삭제");
				
			}else if(path.equals("/cartAllDelete.cart")){//모두삭제
				System.out.println("장바구니비우기");
				
				
			}		
			System.out.println("nextpage" + nextPage);
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