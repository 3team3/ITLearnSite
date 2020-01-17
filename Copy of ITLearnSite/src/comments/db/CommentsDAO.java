package comments.db;

import java.util.ArrayList;

public interface CommentsDAO{
	//코멘트 db insert
	public int insertComments(CommentsBean cBean);
	//코멘트 번호 가져오기
	public int getCommentsNo();
	//코멘트 가져오기
	public ArrayList<CommentsBean> selectCommentsList(CommentsBean cBean);
	//코멘트 삭제
	public int commentsDelete(int co_no, String co_email);
}

