package textbook.service;

import java.util.ArrayList;

import textbook.db.TextbookBean;
import textbook.db.TextbookDAOImpl;

public class TextbookServiceImpl implements TextbookService {
	
	TextbookDAOImpl tbDAO;
	public TextbookServiceImpl() {
		tbDAO = new TextbookDAOImpl(); 
	}
	
	@Override
	public ArrayList<TextbookBean> selectBookList(TextbookBean tBean) {
		return tbDAO.selectBookList(tBean);
	}
}
