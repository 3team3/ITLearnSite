package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lecture.db.CommentsBean;
import lecture.db.LectureBean;
import lecture.db.LectureDAOImpl;
import lecture.service.LectureServiceImpl;

public class LectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LectureDAOImpl lDao = null;
	LectureBean lBean = null;
	LectureServiceImpl lServ = null;
	CommentsBean cBean = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		lDao = new LectureDAOImpl();
		lBean = new LectureBean();
		lServ = new LectureServiceImpl();
		cBean = new CommentsBean();

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
				
				System.out.println(lecturesMap.get("totLectures"));
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
					/*
					 * System.out.println(multi.getParameter("list_title" + i));
					 */
					list_title.add(multi.getParameter("list_title" + i));
				}

				Enumeration e = multi.getFileNames();

				while (e.hasMoreElements()) {
					String InputName = (String) e.nextElement();

					// 서버에 업로드한 실제 파일명 받아오기
					String RealName = multi.getFilesystemName(InputName);

					/* System.out.println(RealName); */

					// 서버에 실제로 업로드된 파일의 이름을 하나 하나씩 어레이리스트에 추가!
					saveFiles.add(RealName);

					// 클라이언트가 업로드한 파일의 원본이름을 얻어서.. 하나씩 ArrayList에 추가!
					originFiles.add(multi.getOriginalFileName(InputName));
				}

				Collections.sort(saveFiles);
				Collections.sort(originFiles);

				
				lBean.setList_title(list_title);
				lBean.setOriginFiles(originFiles);
				lBean.setSaveFiles(saveFiles);
				lBean.setLec_title(multi.getParameter("lec_title"));
				lBean.setLec_price(Integer.parseInt(multi.getParameter("lec_price")));
				lBean.setLec_teacher(multi.getParameter("lec_teacher"));
				lBean.setLec_content(multi.getParameter("lec_content"));

				lServ.lectureRegister(lBean);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('강의를 등록했습니다.');" + " location.href='" + request.getContextPath()
						+ "/lectureList.lec';" + "</script>");
				return;

				// 강의 상세보기
			} else if (path.equals("/lectureDetail.lec")) {

				System.out.println("lectureDetail.lec");
				request.setCharacterEncoding("UTF-8");

				int lec_no = Integer.parseInt(request.getParameter("lec_no"));

				Map lec_DetailMap = lServ.lectureDetail(lec_no);

				request.setAttribute("lec_DetailMap", lec_DetailMap);

				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/lectureDetail.jsp";
				request.setAttribute("paging", paging);

			} else if (path.equals("/deleteLecture.lec")) {

				System.out.println("deleteLecture.lec");

				int lec_no = Integer.parseInt(request.getParameter("lec_no"));

				lServ.deleteLecture(lec_no);

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('강의를 삭제했습니다.');" + " location.href='" + request.getContextPath()
						+ "/lectureList.lec';" + "</script>");
				return;

			//내 강의실
			} else if (path.equals("/myLecture.lec")) {
				String email = (String) request.getSession().getAttribute("email");
				if (email == null) {
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('로그인을 해주세요.');");
					out.println("history.back();");
					out.println("</script>");
					out.close();
				}else{
				System.out.println("myLecture.lec");

				List myList = lServ.myLecture(email);
				/* System.out.println(myList); */

				request.setAttribute("myList", myList);

				nextPage = "/main.jsp";
				paging = "/pages/main/center/lecture/myLecture.jsp";
				request.setAttribute("paging", paging);
				}
			} else if (path.equals("/lecturePlay.lec")) {

				System.out.println("lecturePlay.lec");

				String lec_title = request.getParameter("lec_title");
				/* System.out.println(lec_title); */

				Map lec_DetailMap = lServ.lectureDetail(lec_title);

				request.setAttribute("lec_DetailMap", lec_DetailMap);
				nextPage = "/pages/main/center/lecture/lecturePlay.jsp";

			}
			// 댓글 쓰기를 눌렀을 때
			else if (path.equals("/commentsWrite.lec")) {
				int check = 0;
				// print
				System.out.println("/commentsWrite.lec");
				// 현재글에 대한 정보를 얻어오기
				cBean = getCommentsBeanProperty(request, response);
				
				/*
				// 댓글을 insert 시킬 서비스 호출
				System.out.println(cBean.getCo_email());
				System.out.println(cBean.getCo_no());
				System.out.println(cBean.getList_no());
				System.out.println(cBean.getLec_no());
				System.out.println(cBean.getCo_content());
*/
				check = lServ.insertComments(cBean);

				if (check == 1) {
					PrintWriter out = response.getWriter();
					out.print(1);
				}
			} else if (path.equals("/commentsList.lec")) {
				System.out.println("/commentsList.lec");
				// request.getParameter
				cBean = getCommentsBeanProperty(request, response);

				ArrayList<CommentsBean> list = lServ.selectCommentsList(cBean);

				JSONObject jsondata = new JSONObject();
				JSONArray arr = new JSONArray();
				String jsonString = null;
				Date date = null;

				for (int i = 0; i < list.size(); i++) {
					/*System.out.println("-------------------------");
					System.out.println("list.get(i)" + i);
					System.out.println(list.get(i).getCo_email());
					System.out.println(list.get(i).getCo_no());
					System.out.println(list.get(i).getCo_content());
					System.out.println(list.get(i).getCo_date());*/

					jsondata = new JSONObject();
					jsondata.put("co_email", list.get(i).getCo_email());
					jsondata.put("co_no", list.get(i).getCo_no());
					jsondata.put("co_content", list.get(i).getCo_content());

					date = list.get(i).getCo_date();
					jsondata.put("co_date", date.toString());

					arr.add(jsondata);
				}
				JSONObject commentlist = new JSONObject();
				commentlist.put("list", arr);

				jsonString = commentlist.toJSONString();
				/* System.out.println(jsonString); */

				PrintWriter out = response.getWriter();
				out.print(jsonString);
			} else if (path.equals("/commentsDelete.lec")) {
				cBean = getCommentsBeanProperty(request, response);
				HttpSession session = request.getSession();
				String email = (String) session.getAttribute("email");
				int check = lServ.commentsDelete(cBean.getCo_no(), email);
				PrintWriter out = response.getWriter();
				if (check == 1) {
					// 지우기 성공
					out.print(1);
				} else {
					// 지우기 실패 다른사람 글 지우려고 함

					out.print(0);
				}
			}

			System.out.println("nextPAge :" + nextPage);

			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	private CommentsBean getCommentsBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int co_no = 0;// 댓글 번호
		int list_no = 0;
		int lec_no = 0;
		String co_email = null;// 댓글 다는 사람
		String co_content = null;// 댓글 내용

		cBean = new CommentsBean();

		if (request.getParameter("co_no") != null) {
			co_no = Integer.parseInt(request.getParameter("co_no"));
			cBean.setCo_no(co_no);
			/*System.out.println("co_no =" + co_no);*/
		}
		if (request.getParameter("list_no") != null) {
			list_no = Integer.parseInt(request.getParameter("list_no"));
			cBean.setList_no(list_no);
			/*System.out.println("list_no =" + list_no);*/
		}
		if (request.getParameter("lec_no") != null) {
			lec_no = Integer.parseInt(request.getParameter("lec_no"));
			cBean.setLec_no(lec_no);
			/*System.out.println("lec_no =" + lec_no);*/
		}
		if (request.getParameter("co_email") != null) {
			co_email = request.getParameter("co_email");
			cBean.setCo_email(co_email);
			/*System.out.println("co_email =" + co_email);*/
		}

		if (request.getParameter("content") != null) {
			co_content = request.getParameter("content");
			cBean.setCo_content(co_content);
			/*System.out.println("content =" + co_content);*/
		}
		return cBean;
	}

}
