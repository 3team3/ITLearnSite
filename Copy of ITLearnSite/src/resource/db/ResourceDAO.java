<<<<<<< HEAD
package resource.db;

import java.util.List;
import java.util.Map;

public interface ResourceDAO {
	/*자료 등록*/
	
	/*자료 수정*/
	
	/*자료 삭제*/
	public void resourceDelete(int res_no);

	
	/*자료 목록*/
	public List selectAllResources(Map pagingMap);
	
	/*전체 글 개수*/
	public int selectTotResources();
	
	/*자료 내용*/
	public ResourceBean resourceView(int res_no);
}
=======
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
>>>>>>> refs/remotes/origin/ran
