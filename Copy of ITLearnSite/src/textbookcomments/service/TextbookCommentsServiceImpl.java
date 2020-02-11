package textbookcomments.service;

import java.util.ArrayList;

import comments.db.CommentsBean;
import comments.db.CommentsDAOImpl;
import textbookcomments.db.TextbookCommentsBean;
import textbookcomments.db.TextbookCommentsDAOImpl;

public class TextbookCommentsServiceImpl implements TextbookCommentsService {
	TextbookCommentsDAOImpl tcDao;
	
	public TextbookCommentsServiceImpl() {
		tcDao = new TextbookCommentsDAOImpl();
	}
	
	//후기를 db에 insert해줄 메서드 구현하기
	@Override
	public int insertTextbookComments(TextbookCommentsBean tcBean) {
		int check = tcDao.insertTextbookComments(tcBean);
		
		return check;
	}
	@Override
	public ArrayList<TextbookCommentsBean> selectTextbookCommentsList(TextbookCommentsBean tcBean) {
		
		return tcDao.selectTextbookCommentsList(tcBean);
	}
	
	@Override
	public int TextbookcommentsDelete(int bo_no, String bo_email) {
		return tcDao.TextbookcommentsDelete(bo_no, bo_email);
	}
}
