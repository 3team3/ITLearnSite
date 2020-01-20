package cart.service;

import java.util.List;

import cart.db.CartBean;

public interface CartService {
	
	//장바구니리스트
	public List<CartBean> getcartlist(String email);
	
}
