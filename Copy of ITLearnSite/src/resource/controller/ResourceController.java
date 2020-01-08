package resource.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.db.ResourceBean;
import resource.db.ResourceDAO;
import resource.service.ResourceService;


public class ResourceController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	ResourceService serv = null;
	ResourceDAO rDao = null;
	ResourceBean rBean = null;

	int result = 0; // 상태를 나타낼 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("init()");
		serv = new ResourceService();
		System.out.println("ResourceService() 객체 생성");
		rBean = new ResourceBean();
		System.out.println("ResourceBean() 객체 생성");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/* ##test code## */
		System.out.println("service()");

		String url = request.getRequestURI();
		System.out.println(url);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		
		try {
			if(path.equals("/resourceList.bo"))
			{
				System.out.println("resourceList.bo");
				System.out.println("Test");
				nextPage = "/resource/ResourceList.jsp";
			}
			System.out.println("nextPAge" + nextPage);
			if (nextPage != null) 
			{
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
