package resource.service;

import java.util.List;

import resource.db.ResourceBean;

public interface ResourceServiceImpl {
	
	/*자료실 내용*/
	public ResourceBean resourceView(int res_no);
	
	/*자료실 검색*/
	public List<ResourceBean> resourceSelect(String select_subject,String select_content);
}
