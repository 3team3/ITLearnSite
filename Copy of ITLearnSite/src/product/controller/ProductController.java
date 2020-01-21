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
				//Product Bean 객체 생성
				pBean =  new ProductBean();
				//request 객체에서 꺼냄
				//상품명
				String item = request.getParameter("item");
				//상품가격
				int price = Integer.parseInt(request.getParameter("price"));
				//상품 타입
				String type = request.getParameter("type");
				
				System.out.println(item);
				System.out.println(price);
				System.out.println(type);
				
				//객체에 담기
				pBean.setProduct_name(item);
				pBean.setProduct_price(price);
				pBean.setProduct_type(type);
				//Product table에 먼저 등록후
				int product_no = pServ.addProduct(pBean);
				System.out.println("return product_no"+product_no);
				//Product_no 을 가져옴
				
				
				//TextbookBean 객체 생성
				if(product_no != 0) {
					tBean = new TextbookBean();
					//request 객체에서 꺼냄
					String book_title = request.getParameter("book_title");
					String book_content = request.getParameter("book_content");
					String book_writer = request.getParameter("book_writer");
					String book_publisher = request.getParameter("book_publisher");
					int book_page = Integer.parseInt(request.getParameter("book_page"));
					String book_filename = request.getParameter("book_filename");
					
					System.out.println(book_title);
					System.out.println(book_content);
					System.out.println(book_writer);
					System.out.println(book_publisher);
					System.out.println(book_page);
					System.out.println(book_filename);
					
					//TextbookBean  객체에 담기
					tBean.setProduct_no(product_no);
					tBean.setBook_title(book_title);
					tBean.setBook_content(book_content);
					tBean.setBook_writer(book_writer);
					tBean.setBook_publisher(book_publisher);
					tBean.setBook_page(book_page);
					tBean.setBook_filename(book_filename);
				}
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
