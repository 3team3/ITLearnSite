package textbook.db;

import java.util.ArrayList;

public interface TextbookDAO{
	public ArrayList<TextbookBean>selectBookList(TextbookBean tBean);
}
