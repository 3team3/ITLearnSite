package payment.service;

import java.util.List;

import payment.db.PaymentBean;
import payment.db.PaymentDAOImpl;

public class PaymentServiceImpl implements PaymentService{

	PaymentDAOImpl pDao = new PaymentDAOImpl();
	
	//전체 주문 목록 
	@Override
	public List<PaymentBean> getPaymentlist() {
		List<PaymentBean> listPayment = pDao.getPaymentlist();
		return listPayment;
	}
	
	//회원 주문 확인
    @Override
  	public PaymentBean callPayment(String email){
    	PaymentBean pBean = pDao.callPayment(email);
		return pBean;
    }
  	
  	//회원 주문 수정
    @Override
  	public void updatePayment(PaymentBean pBean){
    	pDao.updatePayment(pBean);
    }
  	
  	//회원 주문 하기
    @Override
  	public void insertPayment(PaymentBean pBean){
    	pDao.insertPayment(pBean);		
    }
  	
  	//회원 주문 취소
    @Override
  	public void deletePayment(String email){
    	pDao.deletePayment(email);
		
    }
}
