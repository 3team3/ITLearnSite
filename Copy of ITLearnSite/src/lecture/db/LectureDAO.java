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
	
	/*
	자료 내용
	public ResourceBean lectureView(int res_no);
	
	자료 검색
	public ArrayList<ResourceBean> lectureSelect(HashMap<String, Object> listOpt);
	
	자료 등록
	public int insertLecture(ResourceBean rBean);
	
	자료 수정
	public void updateLecture(ResourceBean rBean);
	
	자료 삭제
	public void lectureDelete(int res_no);
	*/
}
