package resource.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.db.ResourceBean;
import resource.db.ResourceDAO;

public class ResourceService implements ResourceServiceImpl {
	ResourceDAO rDao;

	public ResourceService() {
		rDao = new ResourceDAO();
	}

	// 자료실 내용
	@Override
	public ResourceBean resourceView(int res_no) {
		ResourceBean rBean = rDao.resourceView(res_no);
		return rBean;
	}

	@Override
	public void resourceDelete(int res_no) {
		rDao.resourceDelete(res_no);

	}

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

}
