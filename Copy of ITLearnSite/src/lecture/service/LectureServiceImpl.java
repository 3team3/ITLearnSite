package lecture.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecture.db.LectureBean;
import lecture.db.LectureDAOImpl;

public class LectureServiceImpl implements LectureService {

	LectureDAOImpl lDao;

	public LectureServiceImpl() {
		lDao = new LectureDAOImpl();
	}

	// 자료실 리스트
	@Override
	public Map listLecture(Map<String, Integer> pagingMap) {

		Map lecturesMap = new HashMap();

		List<LectureBean> lecturesList = lDao.selectAllLectures(pagingMap);

		int totLectures = lDao.selectTotLectures();
		/*
		System.out.println("service : " + totLectures);
		
		System.out.println("service : " + lecturesList);
		*/
		lecturesMap.put("lecturesList", lecturesList);

		
		lecturesMap.put("totLectures", totLectures);

		return lecturesMap;
	}
	
	//강의 등록
	@Override
	public void lectureRegister(LectureBean lBean) {
		lDao.lectureRegister(lBean);
		
	}
	
	//강의 상세
	@Override
	public Map lectureDetail(int lec_no) {
		Map lec_DetailMap = new HashMap();
		
		LectureBean lec_Detail = lDao.lectureDetail(lec_no);
		List<LectureBean> lec_list = lDao.lectureList(lec_no);
		
		lec_DetailMap.put("lec_Detail", lec_Detail);
		lec_DetailMap.put("lec_list", lec_list);
		
		return lec_DetailMap;
	}
	
	//강의 삭제
	@Override
	public void deleteLecture(int lec_no) {
		
		lDao.deleteLecture(lec_no);
		
	}
	

}
