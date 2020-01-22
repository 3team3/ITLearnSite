package textbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import textbook.db.TextbookBean;
import textbook.db.TextbookDAOImpl;
import textbook.naverAPI.NaverSearchAPI;
import textbook.service.TextbookServiceImpl;

public class TextbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TextbookDAOImpl tDao = null;
	TextbookServiceImpl tServ = null;
	TextbookBean tBean = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		tDao = new TextbookDAOImpl();
		tServ = new TextbookServiceImpl();
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
		String paging=null;

		try {
			if(path.equals("/bookList.text"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/books/bookList.jsp";
				request.setAttribute("paging", paging);
			}
			else if(path.equals("/bookselect.text"))
			{
				/*ajax*/
				tBean = getTextbookBeanProperty(request, response);
				ArrayList<TextbookBean> list = tServ.selectBookList(tBean);
				
				//jsondata로 파싱
				JSONObject jsondata = new JSONObject();
				Date date = null;
				//jsonString
				String jsonString = null;
				JSONArray arr = new JSONArray();
				//ArrayList에서 값을 꺼내옴
				for(int i=0; i<list.size(); i++) {
					System.out.println("-----------------------");
					jsondata = new JSONObject();
					jsondata.put("product_no", list.get(i).getProduct_no());
					jsondata.put("book_title", list.get(i).getBook_title());
					jsondata.put("book_content", list.get(i).getBook_content());
					jsondata.put("book_publisher", list.get(i).getBook_publisher());
					jsondata.put("book_page", list.get(i).getBook_page());
					jsondata.put("book_filename", list.get(i).getBook_filename());
					jsondata.put("book_writer", list.get(i).getBook_writer());
					
					date = list.get(i).getBook_uploaddate();
					jsondata.put("book_uploaddate", date.toString());
					
					arr.add(jsondata);
				}
				JSONObject booklist = new JSONObject();
				booklist.put("list", arr);
				
				jsonString = booklist.toJSONString();
				System.out.println(jsonString);
				
				PrintWriter out = response.getWriter();
				out.print(jsonString);
			}
			else if(path.equals("/bookView.text"))
			{
				tBean= getTextbookBeanProperty(request, response);
				int product_no = tBean.getProduct_no();
				
				//네이버 api
				NaverSearchAPI search = new NaverSearchAPI(); 
				String word = request.getParameter("word"); 
				String result = search.Search(word); 

				JSONParser paser = new JSONParser(); 
				Object obj = paser.parse(result); 
				JSONObject jsonObj = (JSONObject) obj; 
//				bookView.text  jsp페이지에서 -> ${requestScope.result.items}
				request.setAttribute("result", jsonObj);
				
				System.out.println("get" + result);
				PrintWriter out = response.getWriter();
				out.print(jsonObj);
				//네이버 api
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/books/bookView.jsp?product_no="+product_no;
				request.setAttribute("paging", paging);
				return ;
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

	private TextbookBean getTextbookBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int product_no = 0;
		String book_title = null;
		String book_content = null;
		String book_filename = null;
		String book_publisher = null;
		String book_writer =null;
		int book_page = 0;
		Date book_uploaddate = new Date(System.currentTimeMillis());
		
		if(request.getParameter("product_no") != null) {
			product_no = Integer.parseInt(request.getParameter("product_no"));
			tBean.setProduct_no(product_no);
			System.out.println("product_no =" +product_no);
		}
		if(request.getParameter("book_writer") != null)
		{
			book_writer = request.getParameter("book_writer");
			tBean.setBook_writer(book_writer);
			System.out.println("book_writer =" +book_writer);
		}
		if(request.getParameter("book_publisher") != null)
		{
			book_publisher = request.getParameter("book_publisher");
			tBean.setBook_publisher(book_publisher);
			System.out.println("book_publisher =" +book_publisher);
		}
		if(request.getParameter("book_page") != null)
		{
			book_page = Integer.parseInt(request.getParameter("book_page"));
			tBean.setBook_page(book_page);
			System.out.println("book_page =" + book_page);
		}
		
		if(request.getParameter("book_title") != null)
		{
			book_title = request.getParameter("book_title");
			tBean.setBook_title(book_title);
			System.out.println("book_title =" + book_title);
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
