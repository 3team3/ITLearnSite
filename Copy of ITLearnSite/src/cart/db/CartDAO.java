package cart.db;

import java.util.List;

public interface CartDAO{
	
	public List<CartBean> getcartlist(String email);
}