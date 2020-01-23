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
	public ArrayList<TextbookBean> selectBookList(TextbookBean tBean) {
		return tbDAO.selectBookList(tBean);
	}
	
	
	@Override
	public int insertBook(TextbookBean tBean) {
		int result = tbDAO.insertBook(tBean);
		return result;
	}
	
	@Override
	public TextbookBean bookdetail(int product_no) {
		tBean = tbDAO.bookdetail(product_no);
		return null;
	}
	
}
