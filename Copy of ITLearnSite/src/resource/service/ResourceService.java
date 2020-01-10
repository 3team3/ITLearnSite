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
