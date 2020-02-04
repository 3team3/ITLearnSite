package textbook.db;

import java.util.ArrayList;

public interface TextbookDAO{
	//책리스트 
	public ArrayList<TextbookBean>selectBookList();
	//도서  등록
	public int insertBook(TextbookBean tBean);
	//도서 상세
	public TextbookBean bookdetail(int product_no);
	//도서 삭제
	public int bookdelete(int product_no);
	//도서 재고/가격 수정
	public int stockmodify(int p_no, int price, int stock);
	
}
