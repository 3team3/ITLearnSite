<<<<<<< HEAD
package resource.service;

import java.util.Map;

import resource.db.ResourceBean;

public interface ResourceService {
	/*자료실 내용*/
	public ResourceBean resourceView(int res_no);
	
	public void resourceDelete(int res_no);
	
	//페이징 기능에 필요한 글목록과 전체 글 개를 각각 조회할 수 있도록 구성
	public Map listResource(Map<String, Integer> pagingMap);
}


=======
package resource.service;

import java.util.List;

import resource.db.ResourceBean;
import resource.db.ResourceDAOImpl;

public class ResourceService implements ResourceServiceImpl{
	ResourceDAOImpl rDao;
	ResourceBean rBean;
	public ResourceService(){
		rDao = new ResourceDAOImpl();
	}
	//자료실 내용
	@Override
	public ResourceBean resourceView(int res_no) {
		rBean = rDao.resourceView(res_no);
		return rBean;
	}
	
	//자료실 검색
	@Override
	public List<ResourceBean> resourceSelect(String select_subject,String select_content){
		List<ResourceBean> ResourceList = rDao.resourceSelect(select_subject,select_content);
		return ResourceList;
	}

}
>>>>>>> refs/remotes/origin/ran
