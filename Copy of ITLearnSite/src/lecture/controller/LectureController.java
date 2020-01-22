package lecture.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
			if (path.equals("/lectures.lec")) {
				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectures.jsp";
				request.setAttribute("paging", paging);

				// 강의실
			} else if (path.equals("/lectureList.lec")) {

				System.out.println("lectureList.lec");

				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");

				int section = Integer.parseInt(((_section == null) ? "1" : _section));
				int pageNum = Integer.parseInt(((_pageNum == null) ? "1" : _pageNum));

				Map pagingMap = new HashMap();

				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);

				Map lecturesMap = lServ.listLecture(pagingMap);
				lecturesMap.put("section", section);
				lecturesMap.put("pageNum", pageNum);
				/*
				 * System.out.println("controller : " + lecturesMap);
				 */
				request.setAttribute("lecturesMap", lecturesMap);

				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectureList.jsp";
				request.setAttribute("paging", paging);

			}
			// 강의 등록 페이지
			else if (path.equals("/lectureForm.lec")) {
				System.out.println("lectureForm.lec");
				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectureForm.jsp";
				request.setAttribute("paging", paging);
				// 글쓰기
			} else if (path.equals("/lectureRegister.lec")) {
				System.out.println("lectureRegister.lec");
				request.setCharacterEncoding("UTF-8");

				int max = 1000 * 1024 * 1024;

				String realFoldar = request.getServletContext().getRealPath("pages/main/center/lecture/temp");

				System.out.println("realFoldar :" + realFoldar);

				MultipartRequest multi = new MultipartRequest(request, realFoldar, max, "UTF-8",
						new DefaultFileRenamePolicy());

				ArrayList<String> list_title = new ArrayList<String>();
				ArrayList<String> saveFiles = new ArrayList<String>();
				ArrayList<String> originFiles = new ArrayList<String>();

				int cnt = Integer.parseInt(multi.getParameter("cnt"));
				System.out.println(cnt);

				for (int i = 1; i <= cnt; i++) {
					/*System.out.println(multi.getParameter("list_title" + i));*/
					list_title.add(multi.getParameter("list_title" + i));
				}

				Enumeration e = multi.getFileNames();

				while (e.hasMoreElements()) {
					String InputName = (String) e.nextElement();

					// 서버에 업로드한 실제 파일명 받아오기
					String RealName = multi.getFilesystemName(InputName);

					/*System.out.println(RealName);*/

					// 서버에 실제로 업로드된 파일의 이름을 하나 하나씩 어레이리스트에 추가!
					saveFiles.add(RealName);

					// 클라이언트가 업로드한 파일의 원본이름을 얻어서.. 하나씩 ArrayList에 추가!
					originFiles.add(multi.getOriginalFileName(InputName));
				}
				
				//역순으로 정렬
				Collections.reverse(saveFiles);
				Collections.reverse(originFiles);

				lBean.setList_title(list_title);
				lBean.setOriginFiles(originFiles);
				lBean.setSaveFiles(saveFiles);
				lBean.setLec_title(multi.getParameter("lec_title"));
				lBean.setLec_price(Integer.parseInt(multi.getParameter("lec_price")));
				lBean.setLec_content(multi.getParameter("lec_content"));

				lServ.lectureRegister(lBean);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('강의를 등록했습니다.');" + " location.href='" + request.getContextPath()
						+ "/lectureList.lec';" + "</script>");
				return;

				//강의 상세보기
			} else if (path.equals("/lectureDetail.lec")) {
				
				System.out.println("lectureDetail.lec");
				request.setCharacterEncoding("UTF-8");
				
				int lec_no = Integer.parseInt(request.getParameter("lec_no"));
				
				Map lec_DetailMap = lServ.lectureDetail(lec_no);
				
				request.setAttribute("lec_DetailMap", lec_DetailMap);
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectureDetail.jsp";
				request.setAttribute("paging", paging);
				
			}

			System.out.println("nextPAge :" + nextPage);
			// null PointException
			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}
