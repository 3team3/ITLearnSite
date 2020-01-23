package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import product.db.ProductBean;
import product.db.ProductDAOImpl;
import product.service.ProductServiceImpl;
import textbook.db.TextbookBean;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAOImpl pDao = null;
	ProductServiceImpl pServ = null;
	ProductBean pBean = null;
	TextbookBean tBean = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		pDao = new ProductDAOImpl();
		pServ = new ProductServiceImpl();
		pBean = new ProductBean();
		tBean = new TextbookBean();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String url = request.getRequestURI();
		System.out.println(url);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		String paging = null;

		try {
			if (path.equals("/productWrite.pd")) {
				nextPage = "/main.jsp";
				paging = "/pages/main/center/product/productWrite.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/addProduct.pd"))
			{
				String book_title = request.getParameter("book_title");
				System.out.println(book_title);
				
				String book_link = request.getParameter("book_link");
				System.out.println(book_link);
				
				String book_image = request.getParameter("book_image");
				System.out.println(book_image);
				
				String book_author = request.getParameter("book_author");
				System.out.println(book_author);
				
				int book_price = Integer.parseInt(request.getParameter("book_price"));
				System.out.println(book_price);
				
				int book_discount = Integer.parseInt(request.getParameter("book_discount"));
				System.out.println(book_discount);
				
				String book_publisher = request.getParameter("book_publisher");
				System.out.println(book_publisher);
				
				String book_isbn = request.getParameter("book_isbn");
				System.out.println(book_isbn); 
				
				String book_description = request.getParameter("book_description");
				System.out.println(book_description);
				
//				tBean.
//				pServ.addBook(tBean);
				
				
				
			}
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
}
