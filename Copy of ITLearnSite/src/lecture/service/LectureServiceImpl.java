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
	
	@Override
	public void lectureRegister(LectureBean lBean) {
		lDao.lectureRegister(lBean);
		
	}
	
/*
	// 자료실 글쓰기
	@Override
	public int addResource(ResourceBean rBean) {
		return rDao.insertResource(rBean);
	}

	// 자료실 글수정
	@Override
	public void modResource(ResourceBean rBean) {
		rDao.updateResource(rBean);
	}

	// 자료실 내용
	@Override
	public ResourceBean resourceView(int res_no) {
		ResourceBean rBean = rDao.resourceView(res_no);
		return rBean;
	}

	// 자료실 내용 삭제
	@Override
	public void resourceDelete(int res_no) {
		rDao.resourceDelete(res_no);

	}

	// 자료실 검색
	@Override
	public ArrayList<ResourceBean> resourceSelect(String opt, String condition) {
		System.out.println("resource select service");
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		ArrayList<ResourceBean> ResourceList = rDao.resourceSelect(listOpt);
		return ResourceList;

	}
*/
}
