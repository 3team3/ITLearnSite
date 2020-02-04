package cart.db;

import java.util.List;

public interface CartDAO{
	
	public List<CartBean> getcartlist(String email);
	public int addCart(CartBean cbean);
	public int cartDupChk(String pro_name, String email);
	public void editCart(int pro_cnt, int cart_num);
	public int delAllCart(String email);
	public int cartMaxChk(String email);
	public int delCart(int cart_num);
}
