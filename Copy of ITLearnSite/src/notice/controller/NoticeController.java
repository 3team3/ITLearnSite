package notice.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.db.NoticeBean;
import notice.db.NoticeDAO;
import notice.service.NoticeService;

public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeBean nBean = null;
	NoticeDAO nDao = null;
	NoticeService nServ = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		nBean = new NoticeBean();
		nDao = new NoticeDAO();
		nServ = new NoticeService();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String url = request.getRequestURI();
		System.out.println(url);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String path = url.substring(contextPath.length());
		System.out.println(path);
		String nextPage = null;
		String paging = null;
		
		try {
			if(path.equals("/notice.noti"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/notice/notice.jsp";
				request.setAttribute("paging", paging);
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

	private NoticeBean getNoticeBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int noti_no = 0;
		String noti_title = null;
		String noti_email = null;
		String noti_pw = null;
		String noti_content = null;
		Timestamp noti_writedate = new Timestamp(System.currentTimeMillis());
		int noti_readcount = 0;

		if (request.getParameter("noti_no") != null) {
			noti_no = Integer.parseInt(request.getParameter("noti_no"));
			nBean.setNoti_no(noti_no);
			System.out.println("noti_no =" + noti_no);
		}

		if (request.getParameter("noti_title") != null) {
			noti_title = request.getParameter("noti_title");
			nBean.setNoti_title(noti_title);
			System.out.println("noti_title =" + noti_title);
		}
		if (request.getParameter("noti_email") != null) {
			noti_email = request.getParameter("noti_email");
			nBean.setNoti_email(noti_email);
			System.out.println("noti_email =" + noti_email);
		}
		if (request.getParameter("noti_pw") != null) {
			noti_pw = request.getParameter("noti_pw");
			nBean.setNoti_pw(noti_pw);
			System.out.println("noti_pw =" + noti_pw);
		}
		if (request.getParameter("noti_content") != null) {
			noti_content = request.getParameter("noti_content");
			nBean.setNoti_content(noti_content);
			System.out.println("noti_content =" + noti_content);
		}

		nBean.setNoti_writedate(noti_writedate);
		System.out.println("noti_writedate =" + noti_writedate);

		if (request.getParameter("noti_readcount") != null) {
			noti_readcount = Integer.parseInt(request.getParameter("noti_readcount"));
			nBean.setNoti_readcount(noti_readcount);
			System.out.println("noti_readcount =" + noti_readcount);
		}

		return nBean;
	}
}
