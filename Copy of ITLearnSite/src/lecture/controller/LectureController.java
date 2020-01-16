package lecture.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import lecture.db.LectureBean;
import lecture.db.LectureDAOImpl;
import lecture.service.LectureServiceImpl;


public class LectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LectureDAOImpl lDao = null;
	LectureBean lBean = null;
	LectureServiceImpl lServ = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		lDao = new LectureDAOImpl();
		lBean = new LectureBean();
		lServ = new LectureServiceImpl();
		
		System.out.println("LectureService() 객체 생성");
		System.out.println("LectureBean() 객체 생성");
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
			if(path.equals("/lectures.lec"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectures.jsp";
				request.setAttribute("paging", paging);
			}else if (path.equals("/lectureList.lec")) {
				
				System.out.println("lectureList.lec");
				
				String _section=request.getParameter("section");
				String _pageNum=request.getParameter("pageNum");
				
				int section = Integer.parseInt(((_section==null)? "1":_section) );
				int pageNum = Integer.parseInt(((_pageNum==null)? "1":_pageNum));
				
				Map pagingMap=new HashMap();
				
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				
				Map lecturesMap= lServ.listLecture(pagingMap);
				lecturesMap.put("section", section);
				lecturesMap.put("pageNum", pageNum);
				/*
				System.out.println("controller : " + lecturesMap);
				*/
				request.setAttribute("lecturesMap", lecturesMap);
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectureList.jsp";
				request.setAttribute("paging", paging);
				
			}/*
			//자료실게시판 - 글 내용보기 페이지
			else if(path.equals("/resourceView.bo"))
			{
				System.out.println("resourceView.bo");
				int res_no = Integer.parseInt(request.getParameter("res_no"));
				rBean = serv.resourceView(res_no);
				request.setAttribute("rBean", rBean);	
				request.setAttribute("res_no", res_no);
				nextPage = "/main.jsp";
				paging= "/pages/main/center/resource/resourceView.jsp?res_no="+res_no;
				request.setAttribute("paging", paging);	
			}
			//자료실게시판 - 글 내용보기 페이지(파일다운로드)
			else if(path.equals("/filedown.bo"))
			{
				System.out.println("filedown.bo");
				int res_no = Integer.parseInt(request.getParameter("res_no"));
				rBean = serv.resourceView(res_no);
				
				String res_filename = rBean.getRes_filename();
				
				FileDownloadController filedown = new FileDownloadController();
				filedown.download(response, RESOURCE_REPO + "\\" + res_no + "\\" + res_filename);
				request.setAttribute("rBean", rBean);
					
			}
			//자료실게시판 - 글 쓰기 페이지
			else if(path.equals("/resourceWrite.bo"))
			{
				System.out.println("resourceWrite.bo");
				nextPage = "/main.jsp";
				paging= "/pages/main/center/resource/resourceWrite.jsp";
				request.setAttribute("paging", paging);
			}
			//글쓰기
			else if(path.equals("/addResource.bo"))
			{
				System.out.println("addResource.bo");
				
				String email = (String)request.getSession().getAttribute("email");
				
				int res_no = 0;
				Map<String, String> resourceMap = upload(request, response);
				String res_title = resourceMap.get("res_title");
				String res_content = resourceMap.get("res_content");
				String res_filename = resourceMap.get("res_filename");

				rBean.setRes_parentno(0);
				rBean.setRes_email(email);
				rBean.setRes_title(res_title);
				rBean.setRes_content(res_content);
				rBean.setRes_filename(res_filename);
				res_no = serv.addResource(rBean);
				
				if (res_filename != null && res_filename.length() != 0) {
					File srcFile = new File(RESOURCE_REPO + "\\" + "temp" + "\\" + res_filename);
					File destDir = new File(RESOURCE_REPO + "\\" + res_no);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('글쓰기를 완료했습니다.');" + " location.href='" + 
				"resourceList.bo';" + "</script>");
				return;
			}	
			
			//자료실게시판 - 글  수정 페이지
			else if(path.equals("/resourceModify.bo"))
			{
				System.out.println("resourceModify.bo");
				int res_no = Integer.parseInt(request.getParameter("res_no"));
				rBean = serv.resourceView(res_no);
				request.setAttribute("rBean", rBean);
				nextPage = "/main.jsp";
				paging= "/pages/main/center/resource/resourceModify.jsp?res_no="+res_no;
				request.setAttribute("paging", paging);	
				
			}
			//자료실게시판 - 글 수정
			else if(path.equals("/updateResource.bo")){
				rBean=getResourceBeanProperty(request, response);
				serv.modResource(rBean);
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('수정되었습니다.');" + " location.href='" + 
				"resourceList.bo';" + "</script>");
				return;
			}
			//자료실게시판 - 글 검색
			else if(path.equals("/resourceSelect.bo"))
			{
				System.out.println("resourceSelect.bo");
				
				String select_subject = request.getParameter("select_subject");
				String select_content = request.getParameter("select_content");
				
				List<ResourceBean> ResourceList = serv.resourceSelect(select_subject,select_content);
				request.setAttribute("ResourceList", ResourceList);
				nextPage = "/main.jsp";
				paging= "/pages/main/center/resource/resourceSelect.jsp";
				request.setAttribute("paging", paging);
			}
			//자료실게시판 - 글 삭제
			else if(path.equals("/resourceDelete.bo"))
			{ 
				System.out.println("resourceDelete.bo");
				int res_no = Integer.parseInt(request.getParameter("res_no"));
				serv.resourceDelete(res_no);
				//파일 삭제시 필요
				File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _res_no);
				if(imgDir.exists()){
					FileUtils.deleteDirectory(imgDir);
				}
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('글을 삭제했습니다.');" 
				         + " location.href='" + request.getContextPath()
				         + "/resource/resourceList.bo';" + "</script>");
				return;
				
			}*/
			
			
			System.out.println("nextPAge :" + nextPage);
			// null PointException
			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/*
	private LectureBean getLectureBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int lec_no = 0;
		String lec_title = null;
		String lec_email = null;
		String lec_pw = null;
		String lec_content = null;
		String lec_filename = null;
		Date lec_uploaddate = new Date(System.currentTimeMillis());

		if (request.getParameter("lec_no") != null) {
			lec_no = Integer.parseInt(request.getParameter("lec_no"));
			lBean.setLec_no(lec_no);
			System.out.println("lec_no =" + lec_no);
		}
		if (request.getParameter("lec_title") != null) {
			lec_title = request.getParameter("lec_title");
			lBean.setLec_title(lec_title);
			System.out.println("lec_title =" + lec_title);
		}
		if (request.getParameter("lec_email") != null) {
			lec_email = request.getParameter("lec_email");
			lBean.setLec_email(lec_email);
			System.out.println("lec_email =" + lec_email);
		}
		if (request.getParameter("lec_pw") != null) {
			lec_pw = request.getParameter("lec_pw");
			lBean.setLec_pw(lec_pw);
			System.out.println("lec_pw =" + lec_pw);
		}
		if (request.getParameter("lec_title") != null) {
			lec_title = request.getParameter("lec_title");
			lBean.setLec_title(lec_title);
			System.out.println("lec_title =" + lec_title);
		}
		if (request.getParameter("lec_content") != null) {
			lec_content = request.getParameter("lec_content");
			lBean.setLec_content(lec_content);
			System.out.println("lec_content =" + lec_content);
		}
		if (request.getParameter("lec_filename") != null) {
			lec_filename = request.getParameter("lec_filename");
			lBean.setLec_filename(lec_filename);
			System.out.println("lec_filename =" + lec_filename);
		}
		lBean.setLec_uploaddate(lec_uploaddate);
		System.out.println("lec_uploaddate =" + lec_uploaddate);

		return lBean;
	}
*/	
}
