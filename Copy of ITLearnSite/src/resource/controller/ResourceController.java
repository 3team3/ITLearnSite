package resource.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.db.ResourceBean;
import resource.db.ResourceDAO;
import resource.service.ResourceService;

public class ResourceController extends HttpServlet {
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
			if (path.equals("/resourceList.bo")) {
				System.out.println("resourceList.bo");
				System.out.println("Test");
				nextPage = "/resource/ResourceList.jsp";
			}
			System.out.println("nextPAge" + nextPage);
			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ResourceBean getResourceBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int res_no = 0;
		String res_title = null;
		String res_email = null;
		String rest_content = null;
		String res_filename = null;
		Timestamp res_writedate = new Timestamp(System.currentTimeMillis());

		if (request.getParameter("res_no") != null) {
			res_no = Integer.parseInt(request.getParameter("res_no"));
			rBean.setRes_no(res_no);
			System.out.println("res_no =" + res_no);
		}
		if (request.getParameter("res_title") != null) {
			res_title = request.getParameter("res_title");
			rBean.setRes_title(res_title);
			System.out.println("res_title =" + res_title);
		}
		if (request.getParameter("res_email") != null) {
			res_email = request.getParameter("res_email");
			rBean.setRes_email(res_email);
			System.out.println("res_email =" + res_email);
		}
		if (request.getParameter("rest_content") != null) {
			rest_content = request.getParameter("rest_content");
			rBean.setRest_content(rest_content);
			System.out.println("rest_content =" + rest_content);
		}
		if (request.getParameter("res_filename") != null) {
			res_filename = request.getParameter("res_filename");
			rBean.setRes_filename(res_filename);
			System.out.println("res_filename =" + res_filename);
		}
		rBean.setRes_writedate(res_writedate);
		System.out.println("res_writedate =" + res_writedate);
		return rBean;
	}
}
