package resource.service;

import java.util.List;
import java.util.Map;

import resource.db.ResourceBean;

public interface ResourceService {
	/*자료실 글쓰기*/
	public int addResource(ResourceBean rBean);
	
	/*자료실 글수정*/
	public void modResource(ResourceBean rBean);
	
	/*자료실 내용*/
	public ResourceBean resourceView(int res_no);
	
	public void resourceDelete(int res_no);
	
	//페이징 기능에 필요한 글목록과 전체 글 개를 각각 조회할 수 있도록 구성
	public Map listResource(Map<String, Integer> pagingMap);
	
	//<----자료실 검색 부분
	public List<ResourceBean> resourceSelect(String select_subject, String select_content);
}


