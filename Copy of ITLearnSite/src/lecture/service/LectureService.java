package lecture.service;

import java.util.ArrayList;
import java.util.Map;

import lecture.db.LectureBean;
import resource.db.ResourceBean;

public interface LectureService {
	
	//페이징 기능에 필요한 글목록과 전체 글 개를 각각 조회할 수 있도록 구성
	public Map listLecture(Map<String, Integer> pagingMap);
/*	
	자료실 검색
	public ArrayList<LectureBean> lectureSelect(String opt,String condition);

	자료실 글쓰기
	public int addLecture(LectureBean lBean);
	
	자료실 글수정
	public void modLecture(LectureBean lBean);
	
	자료실 내용
	public LectureBean lectureView(int lec_no);
	
	public void lectureDelete(int lect_no);
*/
}
