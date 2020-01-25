package payment.service;

import java.util.List;

import lecture.db.PaylecBean;
import payment.db.PaymentBean;

public interface PaymentService {
	
	//전체 주문 목록
	public List<PaymentBean> getPaymentlist();
	
	//회원 주문 확인
	public List<PaymentBean> callPayment(String email);

	//회원 주문 하기
	public void insertPayment(PaymentBean pBean);
		
	//회원 주문 취소
	public void deletePayment(String email);

	//회원 결제 확인
    public void updatePayment(int pay_no,int pay_option);

    //결제 확인 시 강의리스트 insert
    public PaylecBean setPay_lec(int pay_no);
}
