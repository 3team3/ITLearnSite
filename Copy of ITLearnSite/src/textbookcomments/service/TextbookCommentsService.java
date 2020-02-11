package textbookcomments.service;

import java.util.ArrayList;

import comments.db.CommentsBean;
import textbookcomments.db.TextbookCommentsBean;

public interface TextbookCommentsService {
	//후기를 insert하는 서비스 메서드
	public int insertTextbookComments(TextbookCommentsBean cbBean);
	//후기 리스트를 가져오는 메서드
	public ArrayList<TextbookCommentsBean> selectTextbookCommentsList(TextbookCommentsBean cbBean);
	//후기 삭제
	public int TextbookcommentsDelete(int bo_no, String bo_email);
}
