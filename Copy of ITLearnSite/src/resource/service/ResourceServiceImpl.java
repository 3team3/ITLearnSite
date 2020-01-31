package resource.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import resource.db.ResourceBean;
import resource.db.ResourceDAOImpl;

public class ResourceServiceImpl implements ResourceService {
	ResourceDAOImpl rDao;

	public ResourceServiceImpl() {
		rDao = new ResourceDAOImpl();
	}
	
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
	// 자료실  내용 삭제
	@Override
	public void resourceDelete(int res_no) {
		rDao.resourceDelete(res_no);

	}
	
	//자료실 리스트
	@Override
	public Map listResource(Map<String, Integer> pagingMap) {

		Map resourcesMap = new HashMap();

		// 전달된 pagingMap 사용, 글 목록 조회
		List<ResourceBean> resourcesList = rDao.selectAllResources(pagingMap);

		// 테이블에 존재하는 전체 글 수 조회
		int totResources = rDao.selectTotResources();
		/*System.out.println(resourcesList);
		System.out.println(totResources);*/

		// 조회된 글 목록을 ArrayList에 저장, 다시 HashMap에 저장
		resourcesMap.put("resourcesList", resourcesList);

		// 조회된 전체 글 수를 HashMap에 저장
		resourcesMap.put("totResources", totResources);

		// articlesMap.put("totArticles", 170);

		return resourcesMap;
	}
	//자료실 검색
	@Override
	public ArrayList<ResourceBean> resourceSelect(String opt,String condition){
		System.out.println("resource select service");
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		
		System.out.println("ser opt : " + opt); 
		System.out.println("ser condition : " + condition);
		
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		ArrayList<ResourceBean> ResourceList = rDao.resourceSelect(listOpt);
		
		System.out.println("ser list :" +  ResourceList);
		
		return ResourceList;

	}
}
