package textbook.service;

import java.util.ArrayList;

import textbook.db.TextbookBean;

public interface TextbookService {
	//리스트가져오기
	public ArrayList<TextbookBean> selectBookList(TextbookBean tBean);
	//도서 등록
	public int insertBook(TextbookBean  tBean);
	//도서 자세히 보기
	public TextbookBean bookdetail(int product_no);
	//도서 삭제
	public int deletebook (int product_no);
}
