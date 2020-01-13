package comments.service;

import comments.db.CommentsBean;

public interface CommentsService {
	//코멘트를 insert하는 서비스 메서드
	public int insertComments(CommentsBean cBean);
}
