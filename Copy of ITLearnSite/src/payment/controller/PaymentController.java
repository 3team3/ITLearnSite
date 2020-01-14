package payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.MemberBean;
import member.db.MemberDAOImpl;
import payment.db.PaymentBean;
import payment.db.PaymentDAOImpl;
import payment.service.PaymentServiceImpl;

public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaymentDAOImpl pDao = null;
	PaymentServiceImpl pServ = null;
	PaymentBean pBean = null;
	MemberBean mBean = null;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		pDao = new PaymentDAOImpl();
		pServ = new PaymentServiceImpl();
		pBean = new PaymentBean();
		mBean = new MemberBean();
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
			if(path.equals("/payment.pay"))
			{
				HttpSession session = request.getSession();
				String email = (String)session.getAttribute("email");
				MemberDAOImpl mDao = new MemberDAOImpl();
				mBean = mDao.callMember(email);
				request.setAttribute("mBean", mBean);
				
				nextPage = "/main.jsp";
				paging = "/pages/main/center/payment/payment.jsp";
				request.setAttribute("paging", paging);
			}else if(path.equals("/paymentCheck.pay"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/payment/paymentCheck.jsp";
				request.setAttribute("paging", paging);
			}else if(path.equals("/paymentModify.pay"))
			{
				nextPage = "/main.jsp";
				paging = "/pages/main/center/payment/paymentModify.jsp";
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
		String pay_option = null;
		String pay_total = null;
		int pay_book1 = 0;
		int pay_book1_num = 0;
		int pay_book2 = 0;
		int pay_book2_num = 0;
		int pay_book3 = 0;
		int pay_book3_num = 0;
		int pay_book4 = 0;
		int pay_book4_num = 0;
		int pay_book5 = 0;
		int pay_book5_num = 0;
		int pay_lecture1 = 0;
		int pay_lecture1_num = 0;
		int pay_lecture2 = 0;
		int pay_lecture2_num = 0;
		int pay_lecture3 = 0;
		int pay_lecture3_num = 0;
		int pay_lecture4 = 0;
		int pay_lecture4_num = 0;
		int pay_lecture5 = 0;
		int pay_lecture5_num = 0;
		
		if(request.getParameter("pay_no") != null)
		{
			pay_no = Integer.parseInt(request.getParameter("pay_no"));
			pBean.setPay_no(pay_no);
			System.out.println("pay_no =" + pay_no);
		}
		if(request.getParameter("pay_cart_no") != null)
		{
			pay_cart_no = Integer.parseInt(request.getParameter("pay_cart_no"));
			pBean.setPay_cart_no(pay_cart_no);
			System.out.println("pay_cart_no =" + pay_cart_no);
		}
		if(request.getParameter("pay_email") != null)
		{
			pay_email = request.getParameter("pay_email");
			pBean.setPay_email(pay_email);
			System.out.println("pay_email =" + pay_email);
		}
		if(request.getParameter("pay_name") != null)
		{
			pay_name = request.getParameter("pay_name");
			pBean.setPay_name(pay_name);
			System.out.println("pay_name =" + pay_name);
		}
		if(request.getParameter("pay_address") != null)
		{
			pay_address = request.getParameter("pay_address");
			pBean.setPay_address(pay_address);
			System.out.println("pay_address =" + pay_address);
		}
		if(request.getParameter("pay_address1") != null)
		{
			pay_address1 = request.getParameter("pay_address1");
			pBean.setPay_address1(pay_address1);
			System.out.println("pay_address1 =" + pay_address1);
		}
		if(request.getParameter("pay_address2") != null)
		{
			pay_address2 = request.getParameter("pay_address2");
			pBean.setPay_address2(pay_address2);
			System.out.println("pay_address2 =" + pay_address2);
		}
		if(request.getParameter("pay_option") != null)
		{
			pay_option = request.getParameter("pay_option");
			pBean.setPay_option(pay_option);
			System.out.println("pay_option =" + pay_option);
		}
		if(request.getParameter("pay_total") != null)
		{
			pay_total = request.getParameter("pay_total");
			pBean.setPay_total(pay_total);
			System.out.println("pay_total =" + pay_total);
		}
		
		if(request.getParameter("pay_book1") != null)
		{
			pay_book1 = Integer.parseInt(request.getParameter("pay_book1"));
			pBean.setPay_book1(pay_book1);
			System.out.println("pay_book1 =" + pay_book1);
		}
		if(request.getParameter("pay_book1_num") != null)
		{
			pay_book1_num = Integer.parseInt(request.getParameter("pay_book1_num"));
			pBean.setPay_book1_num(pay_book1_num);
			System.out.println("pay_book1_num =" + pay_book1_num);
		}
		
		if(request.getParameter("pay_book2") != null)
		{
			pay_book2 = Integer.parseInt(request.getParameter("pay_book2"));
			pBean.setPay_book2(pay_book2);
			System.out.println("pay_book2 =" + pay_book2);
		}
		if(request.getParameter("pay_book2_num") != null)
		{
			pay_book2_num = Integer.parseInt(request.getParameter("pay_book2_num"));
			pBean.setPay_book2_num(pay_book2_num);
			System.out.println("pay_book2_num =" + pay_book2_num);
		}
		if(request.getParameter("pay_book3") != null)
		{
			pay_book4 = Integer.parseInt(request.getParameter("pay_book3"));
			pBean.setPay_book3(pay_book3);
			System.out.println("pay_book3 =" + pay_book3);
		}
		if(request.getParameter("pay_book3_num") != null)
		{
			pay_book3_num = Integer.parseInt(request.getParameter("pay_book3_num"));
			pBean.setPay_book3_num(pay_book3_num);
			System.out.println("pay_book3_num =" + pay_book3_num);
		}
		if(request.getParameter("pay_book4") != null)
		{
			pay_book4 = Integer.parseInt(request.getParameter("pay_book4"));
			pBean.setPay_book4(pay_book4);
			System.out.println("pay_book4 =" + pay_book4);
		}
		if(request.getParameter("pay_book4_num") != null)
		{
			pay_book4_num = Integer.parseInt(request.getParameter("pay_book4_num"));
			pBean.setPay_book4_num(pay_book4_num);
			System.out.println("pay_book4_num =" + pay_book4_num);
		}
		if(request.getParameter("pay_book5") != null)
		{
			pay_book5 = Integer.parseInt(request.getParameter("pay_book5"));
			pBean.setPay_book5(pay_book5);
			System.out.println("pay_book1 =" + pay_book1);
		}
		if(request.getParameter("pay_book5_num") != null)
		{
			pay_book5_num = Integer.parseInt(request.getParameter("pay_book5_num"));
			pBean.setPay_book5_num(pay_book5_num);
			System.out.println("pay_book5_num =" + pay_book5_num);
		}
		
		if(request.getParameter("pay_lecture1") != null)
		{
			pay_lecture1 = Integer.parseInt(request.getParameter("pay_lecture1"));
			pBean.setPay_lecture1(pay_lecture1);
			System.out.println("pay_lecture1 =" + pay_lecture1);
		}
		if(request.getParameter("pay_lecture1_num") != null)
		{
			pay_lecture1_num = Integer.parseInt(request.getParameter("pay_lecture1_num"));
			pBean.setPay_lecture1_num(pay_lecture1_num);
			System.out.println("pay_lecture1_num =" + pay_lecture1_num);
		}
		if(request.getParameter("pay_lecture2") != null)
		{
			pay_lecture2 = Integer.parseInt(request.getParameter("pay_lecture2"));
			pBean.setPay_lecture2(pay_lecture2);
			System.out.println("pay_lecture2 =" + pay_lecture2);
		}
		if(request.getParameter("pay_lecture2_num") != null)
		{
			pay_lecture2_num = Integer.parseInt(request.getParameter("pay_lecture2_num"));
			pBean.setPay_lecture2_num(pay_lecture2_num);
			System.out.println("pay_lecture2_num =" + pay_lecture2_num);
		}
		if(request.getParameter("pay_lecture3") != null)
		{
			pay_lecture3 = Integer.parseInt(request.getParameter("pay_lecture3"));
			pBean.setPay_lecture3(pay_lecture3);
			System.out.println("pay_lecture3 =" + pay_lecture3);
		}
		if(request.getParameter("pay_lecture3_num") != null)
		{
			pay_lecture3_num = Integer.parseInt(request.getParameter("pay_lecture3_num"));
			pBean.setPay_lecture3_num(pay_lecture3_num);
			System.out.println("pay_lecture3_num =" + pay_lecture3_num);
		}
		if(request.getParameter("pay_lecture4") != null)
		{
			pay_lecture4 = Integer.parseInt(request.getParameter("pay_lecture4"));
			pBean.setPay_lecture4(pay_lecture4);
			System.out.println("pay_lecture4 =" + pay_lecture4);
		}
		if(request.getParameter("pay_lecture4_num") != null)
		{
			pay_lecture4_num = Integer.parseInt(request.getParameter("pay_lecture4_num"));
			pBean.setPay_lecture4_num(pay_lecture4_num);
			System.out.println("pay_lecture4_num =" + pay_lecture4_num);
		}
		if(request.getParameter("pay_lecture5") != null)
		{
			pay_lecture5 = Integer.parseInt(request.getParameter("pay_lecture5"));
			pBean.setPay_lecture5(pay_lecture5);
			System.out.println("pay_lecture5 =" + pay_lecture5);
		}
		if(request.getParameter("pay_lecture5_num") != null)
		{
			pay_lecture5_num = Integer.parseInt(request.getParameter("pay_lecture5_num"));
			pBean.setPay_lecture5_num(pay_lecture5_num);
			System.out.println("pay_lecture5_num =" + pay_lecture5_num);
		}
		return pBean;
	}
}
