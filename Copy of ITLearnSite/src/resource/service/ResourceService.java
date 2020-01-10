package resource.service;

import resource.db.ResourceBean;
import resource.db.ResourceDAO;

public class ResourceService implements ResourceServiceImpl{
	ResourceDAO rDao;
	public ResourceService(){
		rDao = new ResourceDAO();
	}
	//자료실 내용
	@Override
	public ResourceBean resourceView(int res_no) {
		ResourceBean rBean = rDao.resourceView(res_no);
		return rBean;
	}
	
	@Override
	public void resourceDelete(int res_no){
		rDao.resourceDelete(res_no);	
		
	}

}
