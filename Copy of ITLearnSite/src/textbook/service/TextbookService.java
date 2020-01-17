package textbook.service;

import java.util.ArrayList;

import textbook.db.TextbookBean;

public interface TextbookService {
	public ArrayList<TextbookBean> selectBookList(TextbookBean tBean);
}
