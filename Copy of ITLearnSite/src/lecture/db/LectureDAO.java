package lecture.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.db.ResourceBean;

public interface LectureDAO{
	
	/*자료 목록*/
	public List selectAllLectures(Map pagingMap);
	
	/*전체 글 개수*/
	public int selectTotLectures();
	
	/* 강의 등록 */
	public void lectureRegister(LectureBean lBean);
	
	/* 강의 정보 */
	public LectureBean lectureDetail(int lec_no);
	
	/* 강의 상세 리스트(파일 저장 테이블)*/
	public List lectureList(int lec_no);
	
	/* 강의 삭제*/
	public void deleteLecture(int lec_no);
	
	/* 나의 강의실 */
	public List myLecture(String email);
	
	
}
