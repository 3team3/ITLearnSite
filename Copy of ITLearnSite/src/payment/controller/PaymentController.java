package payment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.MemberBean;
import member.db.MemberDAOImpl;
import member.service.MemberServiceImpl;
import payment.db.PaymentBean;
import payment.db.PaymentDAOImpl;
import payment.service.PaymentServiceImpl;

public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaymentServiceImpl pServ = null;
	PaymentBean pBean = null;
	MemberBean mBean = null;
	MemberServiceImpl mServ = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {	
		pServ = new PaymentServiceImpl();
		pBean = new PaymentBean();
		mBean = new MemberBean();
		mServ = new MemberServiceImpl();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		String nextPage = null;
		String paging = null;
		HttpSession session = null;
		try {
			//주문페이지
			if(path.equals("/payment.pay"))
			{
				session = request.getSession();
				String email = (String)session.getAttribute("email");
				mBean = mServ.callMember(email);
				request.setAttribute("mBean", mBean);
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/payment/payment.jsp";
				request.setAttribute("paging", paging);
			}
			//주문
			else if(path.equals("/payment1.pay")){
				pBean = getPaymentBeanProperty(request, response);
				pServ.insertPayment(pBean);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('주문완료');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/default.jsp";
				request.setAttribute("paging", paging);
			}
			//주문확인
			else if(path.equals("/paymentCheck.pay"))
			{
				session = request.getSession();
				String email = (String)session.getAttribute("email");
				pBean = pServ.callPayment(email);
				request.setAttribute("pBean", pBean);
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/payment/paymentCheck.jsp";
				request.setAttribute("paging", paging);
			}
			//주문수정
			else if(path.equals("/paymentModify.pay"))
			{
				pBean = getPaymentBeanProperty(request, response);
				pServ.updatePayment(pBean);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('주문수정');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/payment/paymentCheck.jsp";
				request.setAttribute("paging", paging);
			}
			System.out.println("nextPage = " + nextPage);
			// null PointException
			if (nextPage != null) {
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
				dispatch.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PaymentBean getPaymentBeanProperty(HttpServletRequest request, HttpServletResponse response) {
		int pay_no = 0;
		int pay_cart_no = 0;
		String pay_email = null;
		String pay_name = null;
		String pay_address = null;
		String pay_address1 = null;
		String pay_address2 = null;
		int pay_book = 0;
		int pay_book_num = 0;
		int pay_lecture = 0;
		int pay_lecture_num = 0;
		String pay_total = null;
		int pay_option = 0;
		
		if(request.getParameter("pay_no") != null)
		{
			pay_no = Integer.parseInt(request.getParameter("pay_no"));
			pBean.setPay_no(pay_no);
		}
		if(request.getParameter("pay_cart_no") != null)
		{
			pay_cart_no = Integer.parseInt(request.getParameter("pay_cart_no"));
			pBean.setPay_cart_no(pay_cart_no);
		}
		if(request.getParameter("pay_email") != null)
		{
			pay_email = request.getParameter("pay_email");
			pBean.setPay_email(pay_email);
		}
		if(request.getParameter("pay_name") != null)
		{
			pay_name = request.getParameter("pay_name");
			pBean.setPay_name(pay_name);
		}
		if(request.getParameter("pay_address") != null)
		{
			pay_address = request.getParameter("pay_address");
			pBean.setPay_address(pay_address);
		}
		if(request.getParameter("pay_address1") != null)
		{
			pay_address1 = request.getParameter("pay_address1");
			pBean.setPay_address1(pay_address1);
		}
		if(request.getParameter("pay_address2") != null)
		{
			pay_address2 = request.getParameter("pay_address2");
			pBean.setPay_address2(pay_address2);
		}		
		if(request.getParameter("pay_book") != null)
		{
			pay_book = Integer.parseInt(request.getParameter("pay_book"));
			pBean.setPay_book(pay_book);
		}
		if(request.getParameter("pay_book_num") != null)
		{
			pay_book_num = Integer.parseInt(request.getParameter("pay_book_num"));
			pBean.setPay_book_num(pay_book_num);
		}
		if(request.getParameter("pay_lecture") != null)
		{
			pay_lecture = Integer.parseInt(request.getParameter("pay_lecture"));
			pBean.setPay_lecture(pay_lecture);
		}
		if(request.getParameter("pay_lecture_num") != null)
		{
			pay_lecture_num = Integer.parseInt(request.getParameter("pay_lecture_num"));
			pBean.setPay_lecture_num(pay_lecture_num);
		}
		if(request.getParameter("pay_total") != null)
		{
			pay_total = request.getParameter("pay_total");
			pBean.setPay_total(pay_total);
		}
		
		if(request.getParameter("pay_option") != null)
		{
			pay_option = Integer.parseInt(request.getParameter("pay_option"));
			pBean.setPay_option(pay_option);
		}
		
		return pBean;
	}
}
