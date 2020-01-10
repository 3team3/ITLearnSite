package resource.db;

import java.util.List;

public interface ResourceDAO {
	/*자료 등록*/
	
	/*자료 수정*/
	
	/*자료 삭제*/
	
	/*자료 목록*/
	public List<ResourceBean> resourceList();
	/*자료 내용*/
	public ResourceBean resourceView(int res_no);
	/*자료 검색*/
	public List<ResourceBean> resourceSelect(String select_subject,String select_content);
}
