package resource.service;

import java.util.Map;

import resource.db.ResourceBean;

public interface ResourceServiceImpl {
	
	/*자료실 내용*/
	public ResourceBean resourceView(int res_no);
	
	public void resourceDelete(int res_no);
	
	//페이징 기능에 필요한 글목록과 전체 글 개를 각각 조회할 수 있도록 구성
	public Map listArticles(Map<String, Integer> pagingMap);
}
