package lecture.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lecture.db.CommentsBean;
import lecture.db.LectureBean;


public interface LectureService {

	// 강의실 - 페이징 기능에 필요한 글목록과 전체 글 개를 각각 조회할 수 있도록 구성
	public Map listLecture(Map<String, Integer> pagingMap);

	// 강의 등록
	public void lectureRegister(LectureBean lBean);

	// 강의 상세보기
	public Map lectureDetail(int lec_no);

	// 강의 삭제
	public void deleteLecture(int lec_no);

	// 나의 강의실
	public List myLecture(String email);

	// play
	public Map lectureDetail(String lec_title);

	// 코멘트를 insert하는 서비스 메서드
	public int insertComments(CommentsBean cBean);

	// 코멘트 리스트를 가져오는 메서드
	public ArrayList<CommentsBean> selectCommentsList(CommentsBean cBean);

	// 코멘트 삭제
	public int commentsDelete(int co_no, String co_email);

}
