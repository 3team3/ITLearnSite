package cart.service;

import java.util.List;

import cart.db.CartBean;

public interface CartService {
	//장바구니리스트
	public List<CartBean> getcartlist(String email);
	
	//장바구니에 상품 넣기
	public int addCart(CartBean cbean);
	
	public int cartDupChk(String pro_name, String email);

	public void cartEdit(int pro_cnt, int cart_num);
	public int DelAllcart(String email);
	public int Delcart(int cart_num);
	//장바구니 담긴 갯수 확인
    public int cartMaxChk(String email);
}
