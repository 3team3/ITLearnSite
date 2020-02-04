package textbook.service;

import java.util.ArrayList;

import textbook.db.TextbookBean;
import textbook.db.TextbookDAOImpl;

public class TextbookServiceImpl implements TextbookService {
	
	TextbookDAOImpl tbDAO;
	TextbookBean tBean;
	public TextbookServiceImpl() {
		tbDAO = new TextbookDAOImpl();
		tBean = new TextbookBean();
	}
	
	@Override
	public ArrayList<TextbookBean> selectBookList(int num) {
		return tbDAO.selectBookList(num);
	}
	
	
	@Override
	public int insertBook(TextbookBean tBean) {
		int result = tbDAO.insertBook(tBean);
		return result;
	}
	
	@Override
	public TextbookBean bookdetail(int product_no) {
		tBean = tbDAO.bookdetail(product_no);
		return tBean;
	}
	
	@Override
	public int deletebook(int product_no) {
		int check = tbDAO.bookdelete(product_no);
		return check;
	}
	
	@Override
	public int stockModify(int p_no, int price, int stock) {
		int result = tbDAO.stockmodify(p_no, price, stock);
		return result;
	}
	
	@Override
	public int count() {
		int count = tbDAO.count();
		return count;
	}
}
