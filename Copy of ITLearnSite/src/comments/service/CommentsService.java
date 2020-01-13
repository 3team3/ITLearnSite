package comments.service;

import java.util.ArrayList;

import comments.db.CommentsBean;

public interface CommentsService {
	//코멘트를 insert하는 서비스 메서드
	public int insertComments(CommentsBean cBean);
	//코멘트 리스트를 가져오는 메서드
	public ArrayList<CommentsBean> selectCommentsList(CommentsBean cBean);
}
