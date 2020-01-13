package comments.service;

import java.util.ArrayList;

import comments.db.CommentsBean;
import comments.db.CommentsDAO;
import comments.db.CommentsDAOImpl;

public class CommentsServiceImpl implements CommentsService {
	CommentsDAOImpl cDao;
	
	public CommentsServiceImpl() {
		cDao = new CommentsDAOImpl();
	}
	
	//코멘트를 db에 insert해줄 메서드 구현하기
	@Override
	public int insertComments(CommentsBean cBean) {
		System.out.println("insertComments");
	
		int check = cDao.insertComments(cBean);
		
		return check;
	}
	@Override
	public ArrayList<CommentsBean> selectCommentsList(CommentsBean cBean) {
		ArrayList<CommentsBean> list = new ArrayList<CommentsBean>();
		System.out.println("selectCommentsList");
		list = cDao.selectCommentsList(cBean);
		return list;
	}
}
