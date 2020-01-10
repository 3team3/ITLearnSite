package resource.db;

import java.util.List;
import java.util.Map;

public interface ResourceDAOImpl {
	/*자료 등록*/
	
	/*자료 수정*/
	
	/*자료 삭제*/
	public void resourceDelete(int res_no);

	
	/*자료 목록*/
	public List selectAllResources(Map pagingMap);
	
	/*자료 내용*/
	public ResourceBean resourceView(int res_no);
}
