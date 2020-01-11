package resource.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import resource.db.ResourceBean;
import resource.db.ResourceDAOImpl;
import resource.service.ResourceServiceImpl;

public class ResourceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResourceServiceImpl serv = null;
	ResourceDAOImpl rDao = null;
	ResourceBean rBean = null;

	int result = 0; // 상태를 나타낼 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("init()");
		serv = new ResourceServiceImpl();
		System.out.println("ResourceService() 객체 생성");
		rBean = new ResourceBean();
		System.out.println("ResourceBean() 객체 생성");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		/* ##test code## */
		System.out.println("service()");

		String url = request.getRequestURI();
		System.out.println(url);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		String paging = null;
		HttpSession session;

		try {
			
			//자료실 main페이지 - list
			if (path.equals("/resourceList.bo")) {
				
				System.out.println("resourceList.bo");
				
				String _section=request.getParameter("section");
				String _pageNum=request.getParameter("pageNum");
				
				int section = Integer.parseInt(((_section==null)? "1":_section) );
				int pageNum = Integer.parseInt(((_pageNum==null)? "1":_pageNum));
				
				Map pagingMap=new HashMap();
				
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				
				Map resourcesMap=serv.listResource(pagingMap);
				resourcesMap.put("section", section);
				resourcesMap.put("pageNum", pageNum);
				
				request.setAttribute("resourcesMap", resourcesMap);
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/resource/resourceList.jsp";
				request.setAttribute("paging", paging);
				
			}
			//자료실게시판 - 글 내용보기 페이지
			else if(path.equals("/resourceView.bo"))
			{
				System.out.println("resourceView.bo");
				int res_no = Integer.parseInt(request.getParameter("res_no"));
				rBean = serv.resourceView(res_no);
				request.setAttribute("rBean", rBean);			
				nextPage = "/resource/ResourceView.jsp";
			}
			//자료실게시판 - 글 쓰기 페이지
			else if(path.equals("resourceWrite.bo"))
			{
				System.out.println("resourceWrite.bo");
				nextPage = "/resource/ResourceView.jsp";
			}
			//자료실게시판 - 글 글 수정 페이지
			else if(path.equals("resourceModify.bo"))
			{
				System.out.println("resourceModify.bo");
				nextPage = "/resource/ResourceModfiy.jsp";
			}
			//자료실게시판- 글 삭제
			else if(path.equals("resourceDelete.bo"))
			{
				System.out.println("resourceDelete.bo");
				int res_no = Integer.parseInt(request.getParameter("res_no"));
				serv.resourceDelete(res_no);
				//파일 삭제시 필요
			/*	File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _res_no);
				if(imgDir.exists()){
					FileUtils.deleteDirectory(imgDir);
				}*/
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('글을 삭제했습니다.');" 
				         + " location.href='" + request.getContextPath()
				         + "/resource/resourceList.bo';" + "</script>");
				return;
				
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
		String res_content = null;
		String res_filename = null;
		Date res_writedate = null;

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
		if (request.getParameter("res_content") != null) {
			res_content = request.getParameter("res_content");
			rBean.setRes_content(res_content);
			System.out.println("res_content =" + res_content);
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
