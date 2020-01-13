package comments.service;

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
		System.out.println("commentsService");
	
		int check = cDao.insertComments(cBean);
		
		return check;
	}
}
