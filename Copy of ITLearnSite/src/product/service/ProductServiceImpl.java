package product.service;

import product.db.ProductBean;
import product.db.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {
	ProductDAOImpl pDAO;
	public ProductServiceImpl() {
		pDAO = new ProductDAOImpl();
	}
	@Override
	public int addProduct(ProductBean pBean) {
		int product_no = pDAO.addProduct(pBean);
		return product_no;
	}
}
