package payment.service;

import java.util.List;

import payment.db.PaymentBean;

public interface PaymentService {
	
	//전체 주문 목록
	public List<PaymentBean> getPaymentlist();
	
	//회원 주문 확인
	public PaymentBean callPayment(String email);
		
	//회원 주문 수정
	public void updatePayment(PaymentBean pBean);
		
	//회원 주문 하기
	public void insertPayment(PaymentBean pBean);
		
	//회원 주문 취소
	public void deletePayment(String email);
}
